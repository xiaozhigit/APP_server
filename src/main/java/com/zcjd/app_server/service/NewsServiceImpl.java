package com.zcjd.app_server.service;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("appNewsService")
public class NewsServiceImpl implements NewsService {
    protected static final Logger LOG = LoggerFactory.getLogger(NewsService.class);
    //极光推送appkey
    @Value("${jiguang_appKey}")
    private  String appKey;

    //极光推送secret
    @Value("${jiguang_masterSecret}")
    private  String masterSecret;

    //极光推送客户端
    private  JPushClient jPushClient;


    @Override
    public int sendMessage(String tagId, int magType, String title, String content, Map<String, String> extras){
        PushResult result;
        try {
            if(jPushClient==null){
                jPushClient =new JPushClient(masterSecret, appKey);
                LOG.debug("创建了=======jPushClient");
            }
            PushPayload payload =
                    PushPayload.newBuilder().setPlatform(Platform.android()).setAudience(Audience.tag(tagId)).
                            setNotification(Notification.android(content, title, extras)).build();
            LOG.debug("所有连接到服务器的客户端数据======="+Audience.all().toString()+"推送用户id："+tagId);
                result = jPushClient.sendPush(payload);
            } catch ( APIConnectionException | APIRequestException e) {
                e.printStackTrace();
                return 0;
            }
        return result.getResponseCode();
    }
}
