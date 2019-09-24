package com.zcjd.app_server.controller;


import com.zcjd.app_server.service.NewsService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("app_news")
public class NewsController {
    @Autowired
    @Qualifier("appNewsService")
    private NewsService newsService;

    @RequestMapping("push")
    public  String push(HttpServletResponse response) {
        Map<String, String> maps=new HashMap<String, String>();
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out=null;
        try {
            newsService.sendMessage("13cf1971da6e4d3ca6ea83ea7f5ecf41",1,"推送测试","你好，极光推送",null);
            maps.put("name", "推送成功");
            JSONArray array= JSONArray.fromObject(maps);
            // JSONObject obj = JSONObject.fromObject(app);
            out=response.getWriter();
            out.print(array);

        } catch (IOException e) {
            e.printStackTrace();
            maps.put("name", "推送失败");
        }finally{
            out.close();
        }
        return null;
    }
}
