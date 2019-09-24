package com.zcjd.app_server.model;

public class AttendanceSetPojo extends AttendanceSetPojoKey {
    // 工作日
    private String workDay;
    // 打卡次数
    private Integer count;
    // 上班时间
    private String workTime;
    // 下班时间
    private String afterTime;
    // 上班打卡结束时间
    private String workEndTime;
    // 下班打卡开始时间
    private String afterStartTime;
    // 下班打卡结束时间
    private String afterEndTime;
    //应出勤天数
    private Integer attendanceDay;
    //删除状态
    private Integer deleteState;
    //经度
    private String maplng;
    //纬度
    private String maplat;
    //打卡地点
    private String address;


    public String getWorkDay() {
        return workDay;
    }


    public void setWorkDay(String workDay) {
        this.workDay = workDay == null ? null : workDay.trim();
    }


    public Integer getCount() {
        return count;
    }


    public void setCount(Integer count) {
        this.count = count;
    }


    public String getWorkTime() {
        return workTime;
    }


    public void setWorkTime(String workTime) {
        this.workTime = workTime == null ? null : workTime.trim();
    }


    public String getAfterTime() {
        return afterTime;
    }


    public void setAfterTime(String afterTime) {
        this.afterTime = afterTime == null ? null : afterTime.trim();
    }


    public String getWorkEndTime() {
        return workEndTime;
    }


    public void setWorkEndTime(String workEndTime) {
        this.workEndTime = workEndTime == null ? null : workEndTime.trim();
    }


    public String getAfterStartTime() {
        return afterStartTime;
    }


    public void setAfterStartTime(String afterStartTime) {
        this.afterStartTime = afterStartTime == null ? null : afterStartTime.trim();
    }


    public String getAfterEndTime() {
        return afterEndTime;
    }


    public void setAfterEndTime(String afterEndTime) {
        this.afterEndTime = afterEndTime == null ? null : afterEndTime.trim();
    }


    public Integer getAttendanceDay() {
        return attendanceDay;
    }


    public void setAttendanceDay(Integer attendanceDay) {
        this.attendanceDay = attendanceDay;
    }


    public Integer getDeleteState() {
        return deleteState;
    }


    public void setDeleteState(Integer deleteState) {
        this.deleteState = deleteState;
    }


    public String getMaplng() {
        return maplng;
    }


    public void setMaplng(String maplng) {
        this.maplng = maplng == null ? null : maplng.trim();
    }

    public String getMaplat() {
        return maplat;
    }


    public void setMaplat(String maplat) {
        this.maplat = maplat == null ? null : maplat.trim();
    }


    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    @Override
    public String toString() {
        return "AttendanceSetPojo{" +
                "workDay='" + workDay + '\'' +
                ", count=" + count +
                ", workTime='" + workTime + '\'' +
                ", afterTime='" + afterTime + '\'' +
                ", workEndTime='" + workEndTime + '\'' +
                ", afterStartTime='" + afterStartTime + '\'' +
                ", afterEndTime='" + afterEndTime + '\'' +
                ", attendanceDay=" + attendanceDay +
                ", deleteState=" + deleteState +
                ", maplng='" + maplng + '\'' +
                ", maplat='" + maplat + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}