package com.zcjd.app_server.model;

/**
 * 聊天群pojo
 */
public class Group {

    private Integer id;//群id
    private String createUserId;
    private  String groupName;
    private String groupImg;//群头像
    private String groupDesc;//群描述
    private Integer totalNumber;//群总人数

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupImg() {
        return groupImg;
    }

    public void setGroupImg(String groupImg) {
        this.groupImg = groupImg;
    }

    public String getGroupDesc() {
        return groupDesc;
    }

    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }

    public Integer getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(Integer totalNumber) {
        this.totalNumber = totalNumber;
    }
    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", createUserId='" + createUserId + '\'' +
                ", groupName='" + groupName + '\'' +
                ", groupImg='" + groupImg + '\'' +
                ", groupDesc='" + groupDesc + '\'' +
                ", totalNumber='" + totalNumber + '\'' +
                '}';
    }
}
