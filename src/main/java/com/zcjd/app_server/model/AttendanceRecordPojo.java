package com.zcjd.app_server.model;

public class AttendanceRecordPojo {
    private String id;
    //打卡用户id
    private String userId;
    //打卡时间
    private String dkTime;
    //是否删除
    private Integer deleteState;
    //迟到状态
    private String lateState;
    //早退状态
    private String leaveEarly;
    //时间
    private String time;
    //打卡经度
    private String lon;
    //打卡维度
    private String lat;
    //打开地址
    private String address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getDkTime() {
        return dkTime;
    }

    public void setDkTime(String dkTime) {
        this.dkTime = dkTime == null ? null : dkTime.trim();
    }

    public Integer getDeleteState() {
        return deleteState;
    }

    public void setDeleteState(Integer deleteState) {
        this.deleteState = deleteState;
    }

    public String getLateState() {
        return lateState;
    }

    public void setLateState(String lateState) {
        this.lateState = lateState == null ? null : lateState.trim();
    }

    public String getLeaveEarly() {
        return leaveEarly;
    }

    public void setLeaveEarly(String leaveEarly) {
        this.leaveEarly = leaveEarly == null ? null : leaveEarly.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon == null ? null : lon.trim();
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat == null ? null : lat.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    @Override
    public String toString() {
        return "AttendanceRecordPojo{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", dkTime='" + dkTime + '\'' +
                ", deleteState=" + deleteState +
                ", lateState='" + lateState + '\'' +
                ", leaveEarly='" + leaveEarly + '\'' +
                ", time='" + time + '\'' +
                ", lon='" + lon + '\'' +
                ", lat='" + lat + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}