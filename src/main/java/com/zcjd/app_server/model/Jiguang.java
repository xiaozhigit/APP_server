package com.zcjd.app_server.model;

import cn.jpush.api.JPushClient;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;

public class Jiguang {
    static JPushClient jPushClient=null;
    static String masterSecret="d7bc2e0b8046b96ef72beecb";
    //static String appKey="15d39c8316d86519244de74f";
    static String appKey="f1d28b6f51f4c6e50287bad9";
    static {
        jPushClient =new JPushClient(masterSecret, appKey);
        //PushPayload payload = buildPushObject_all_all_alert();
    }


    public static PushPayload buildPushObject_all_all_alert(){
        return PushPayload.newBuilder().setPlatform(Platform.android()).setAudience(Audience.tag("tag1")).setNotification(Notification.android("乐吧一日游", "title", null)).build();
    }
}
