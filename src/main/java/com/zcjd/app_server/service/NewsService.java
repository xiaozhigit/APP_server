package com.zcjd.app_server.service;


import java.util.Map;

/**
 * 消息服务类
 */
public interface NewsService {
    /**
     * 发送消息接口方法
     * @param tagId 接收消息者id
     * @param magType 消息类型1：系统消息，2:业务消息
     * @param title 消息主题
     * @param content 消息内容
     * @param extras 消息附件
     * @return
     */
    public int sendMessage(String tagId, int magType, String title, String content, Map<String, String> extras);
}
