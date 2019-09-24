package com.zcjd.app_server.service;

import com.zcjd.app_server.model.AttendanceSetPojo;

import java.text.ParseException;
import java.util.List;

/**
 * 个人中心service
 */
public interface PersionService {
    /**
     * 获取打卡地址经纬度
     */
    List<AttendanceSetPojo> getCheckInAddre();

    /**
     * 提交打卡数据
     * @param userId 打卡人
     * @param lon 打卡经度
     * @param lat 打卡维度
     * @param address 打卡地点
     * @return
     */
    Integer putCheckInData(String userId, String lon, String lat,String address);
}
