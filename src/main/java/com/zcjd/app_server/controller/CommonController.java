package com.zcjd.app_server.controller;

import com.zcjd.app_server.model.UserInfoPojo;
import com.zcjd.app_server.service.LoginService;
import com.zcjd.app_server.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.BASE64Decoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * app公共事务处理类
 */
@Controller
@RequestMapping("app_common")
public class CommonController {
    @Autowired
    LoginService loginService;
    @Autowired
    UserService userService;
    /**
     * app登陆主方法
     *
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("appLogin")
    public ModelMap appLogin(HttpServletRequest request, HttpSession session) throws Exception {
        String account = request.getParameter("account");
        String password  = request.getParameter("password");
        HashMap<String, Object> map = new HashMap<String, Object>();
        ModelMap model=new ModelMap();
        String data = "200";//返回状态:200=成功 201=用户名密码不能为null　202＝用户名或密码错误 203=账号已停用
        if(StringUtils.isNotBlank(account) && StringUtils.isNotBlank(password) ){
            map.put("u_number", account);
            map.put("password", password);
            List<UserInfoPojo> list = loginService.getUserInfoByNumber(map);
            if(list != null && list.size()>0){
                UserInfoPojo pojo = list.get(0);
                if(pojo.getU_count() == 0){
                    UserInfoPojo userInfo=list.get(0);
                    userInfo.setPicdata(request.getContextPath()+"/app_common/getUserImg.action?userid="+userInfo.getId());
                    model.addAttribute("state","200");
                    model.addAttribute("userInfo",userInfo);
                    session.setAttribute("userInfo", userInfo);
                }else{
                    model.addAttribute("state","203");
                }
            }else{
                map.clear();
                map.put("u_name", account);
                map.put("password", password);
                List<UserInfoPojo> listName = loginService.getUserInfoByName(map);
                if(listName != null && listName.size() > 0){
                    UserInfoPojo pojo = listName.get(0);
                    if(pojo.getU_count() == 0){
                        UserInfoPojo userInfo=list.get(0);
                        userInfo.setPicdata(request.getContextPath()+"/userinfo/getUserImg.action?userid="+userInfo.getId());
                        model.addAttribute("state","200");
                        model.addAttribute("userInfo",userInfo);
                        session.setAttribute("userInfo", userInfo);
                    }else{
                        model.addAttribute("state","203");
                    }
                }else{
                    model.addAttribute("state","202");
                }
            }
        }else{
            model.addAttribute("state","201");
        }

        return model;
    }
    /**
     * 退出登陆　
     * @param session
     * @return
     */
    @RequestMapping("appLoginOut")
    public ModelMap appLoginOut(HttpSession session){
        ModelMap m=new ModelMap();
        // 设置session失效
        session.invalidate();
        m.addAttribute("state",200);
        return m;
    }
    //获取图片信息
    @RequestMapping("getUserImg")
    public void getUserImg(HttpServletRequest request, HttpServletResponse response, String userid) throws Exception{
        UserInfoPojo user = userService.getUserById(userid);
        if(user!=null){
            byte[] byteAry = user.getPicdata().getBytes();
            String data = new String(byteAry,"UTF-8");
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] bytes =decoder.decodeBuffer(data);
            for(int i=0; i < bytes.length; ++i) {
                if(bytes[i]<0){
                    bytes[i] += 256;
                }
            }
            response.setContentType("image/jpeg");
            ServletOutputStream out = response.getOutputStream();
            out.write(bytes);
            out.flush();
            out.close();
        }
    }

}
