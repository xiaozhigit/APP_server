package com.zcjd.app_server.service;

import com.zcjd.app_server.mapper.AttendanceRecordPojoMapper;
import com.zcjd.app_server.mapper.AttendanceSetPojoMapper;
import com.zcjd.app_server.model.AttendanceRecordPojo;
import com.zcjd.app_server.model.AttendanceSetPojo;
import com.zcjd.app_server.model.AttendanceSetPojoExample;
import com.zcjd.app_server.util.GenID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class PersionServiceImpl implements PersionService {
    //打卡考勤设置mapper
    @Autowired
    private AttendanceSetPojoMapper attendanceSetPojoMapper;

    //打卡考勤记录mapper
    @Autowired
    private AttendanceRecordPojoMapper attendanceRecordPojoMapper;


    @Override
    public List<AttendanceSetPojo> getCheckInAddre() {
        return attendanceSetPojoMapper.selectByExample(null);
    }

    @Override
    public Integer putCheckInData(String userId, String lon, String lat, String address) {
        try {
            // 判断星期几
            Calendar cal = Calendar.getInstance();
            //通过当前日期查询日期打卡设置对象
            AttendanceSetPojo pojoset = attendanceSetPojoMapper.selectWeek(cal.get(Calendar.DAY_OF_WEEK) - 1);
            // 初始化打卡记录对象
            AttendanceRecordPojo recordPojo = new AttendanceRecordPojo();
            //时间处理设置
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            SimpleDateFormat simdf = new SimpleDateFormat("MM月dd日");
            SimpleDateFormat s = new SimpleDateFormat("yyyy年MM月");
            String time = s.format(d);
            if (pojoset != null) {
                //获取当前时间
                Date nowTime = sdf.parse(sdf.format(d));
                //获取上班开始打卡时间
                Date startTime = sdf.parse(pojoset.getWorkStartTime());
                //获取上班结束打卡时间
                Date endTime = sdf.parse(pojoset.getWorkEndTime());
                //获取下班开始打卡时间
                Date startTimes = sdf.parse(pojoset.getAfterStartTime());
                //下班结束打卡时间
                Date endTimes = sdf.parse(pojoset.getAfterEndTime());
                //填充打卡记录公共数据
                recordPojo.setId(GenID.GenUUID());
                recordPojo.setUserId(userId);
                recordPojo.setTime(time);
                recordPojo.setLon(lon);
                recordPojo.setLat(lat);
                recordPojo.setAddress(address);
                //打卡状态判断
                if ((pojoset.getCount() == 1) && (nowTime.getTime()) >= (startTime.getTime())
                        && (nowTime.getTime()) <= (endTime.getTime())) {
                    //填充打卡记录数据
                    recordPojo.setLateState("未迟到");
                    recordPojo.setDkTime("(" + (cal.get(cal.YEAR) + "年" + simdf.format(cal.getTime())) + ")" + sdf.format(d));
                } else if ((pojoset.getCount() == 1) && (nowTime.getTime()) >= (startTime.getTime())
                        && (nowTime.getTime()) >= (endTime.getTime())) {
                    recordPojo.setLateState("迟到");
                    recordPojo.setDkTime("(" + (cal.get(cal.YEAR) + "年" + simdf.format(cal.getTime())) + ")" + sdf.format(d));
                } else if (pojoset.getCount() >= 2) {
                    if (nowTime.getTime() >= (startTime.getTime()) && (nowTime.getTime()) <= (endTime.getTime())) {
                        recordPojo.setLeaveEarly("正常");
                        recordPojo.setDkTime(
                                "(" + (cal.get(cal.YEAR) + "年" + simdf.format(cal.getTime())) + ")" + sdf.format(d) + "-下" +
                                        "上班打卡");
                    } else if ((nowTime.getTime()) >= (endTime.getTime()) && (nowTime.getTime()) <= (endTime.getTime() + 3600000)) {
                        recordPojo.setLateState("迟到");
                        recordPojo.setDkTime("(" + (cal.get(cal.YEAR) + "年" + simdf.format(cal.getTime())) + ")" + sdf.format(d));
                    } else if (nowTime.getTime() >= (startTimes.getTime()) && (nowTime.getTime()) <= (endTimes.getTime())) {
                        recordPojo.setLeaveEarly("未早退");
                        recordPojo.setDkTime(
                                "(" + (cal.get(cal.YEAR) + "年" + simdf.format(cal.getTime())) + ")" + sdf.format(d) + "-下班打卡");
                    } else if (nowTime.getTime() < (startTimes.getTime()) && nowTime.getTime() > (startTimes.getTime()) - 3600000) {
                        recordPojo.setLeaveEarly("早退");
                        recordPojo.setDkTime(
                                "(" + (cal.get(cal.YEAR) + "年" + simdf.format(cal.getTime())) + ")" + sdf.format(d) + "-下班打卡");
                    } else {
                        return 0;
                    }
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
            return attendanceRecordPojoMapper.insert(recordPojo);
        } catch (Exception e) {
            return -1;
        }

    }
}
