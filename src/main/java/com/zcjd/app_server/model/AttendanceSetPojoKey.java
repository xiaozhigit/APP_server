package com.zcjd.app_server.model;

public class AttendanceSetPojoKey {

    private String id;
    //上班开始打卡时间
    private String workStartTime;

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }


    public String getWorkStartTime() {
        return workStartTime;
    }


    public void setWorkStartTime(String workStartTime) {
        this.workStartTime = workStartTime == null ? null : workStartTime.trim();
    }
}