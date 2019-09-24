package com.zcjd.app_server.model;

public class ChatInfo {
	/*
	 * 	sendUserId: userId,receiveUserId: touserId,: touserId, content: content, id: msgId,
	 * type: 3, isqz: 0
	 */
	//发送消息用户id
	private String sendUserId;
	//接受用户id
	private String receiveUserId;
	//内容
	private String content;
	//消息id
	private Integer msgId;
	//消息类型
	private Integer type;
	//是否为群组消息
	private Integer isqz;
	
	
	public String getSendUserId() {
		return sendUserId;
	}
	public void setSendUserId(String sendUserId) {
		this.sendUserId = sendUserId;
	}
	public String getReceiveUserId() {
		return receiveUserId;
	}
	public void setReceiveUserId(String receiveUserId) {
		this.receiveUserId = receiveUserId;
	}
	public String getContent() {
		return content;
	}
	public void setContentString(String content) {
		this.content = content;
	}
	public Integer getMsgId() {
		return msgId;
	}
	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getIsqz() {
		return isqz;
	}
	public void setIsqz(Integer isqz) {
		this.isqz = isqz;
	}
	
	@Override
	public String toString() {
		return "ChatInfo [sendUserId=" + sendUserId + ", receiveUserId=" + receiveUserId + ", contentString="
				+ content + ", msgId=" + msgId + ", type=" + type + ", isqz=" + isqz + "]";
	}
	
	
}
