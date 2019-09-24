package com.zcjd.app_server.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * 登陆拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 日志对象
     */
    private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    /**
     * 在DispatcherServlet完全处理完请求后被调用，可用于清理资源等。返回处理（已经渲染了页面）；
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3) throws Exception {
//		System.out.println("this is afterCompletion");
    }

    /**
     * 在业务处理器处理请求执行完成后，生成视图之前执行。后处理（调用了Service并返回ModelAndView，但未进行页面渲染），有机会修改ModelAndView；
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView modelAndView) throws Exception {
//		System.out.println("this is postHandle");
    }

    /**
     * 在业务处理器处理请求之前被调用。预处理，可以进行编码、安全控制、权限校验等处理；
     */
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object obj) throws Exception {
        HttpSession hsession = request.getSession();

        String url = request.getRequestURI();
        //获取用户头像不拦截请求
        if((url.indexOf("userinfo/getUserImg.action") != -1)||(url.indexOf("app_") != -1)) {
            return true;
        }else{
            // 如果session中不存在登录的用户信息则 拦截
            Object existObj = hsession.getAttribute("userInfo");
            if(existObj == null){
                response.setContentType("text/html;charset=UTF-8");
                if(request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){
                    // Ajax请求, 前段根据此header进行处理
                    response.setHeader("sessionTimeout", "Session time out, you need relogin !");
                    // 返回未认证的状态码(401)
                    response.setStatus(HttpStatus.UNAUTHORIZED.value());
                    logger.debug("请求路径：" + url + ", 请求方式 ：Ajax请求, Session超时, 需要重新登录!");
                }else{
                    // 普通请求
                    String path = request.getContextPath();
                    StringBuffer basePath = new StringBuffer()
                            .append(request.getScheme())
                            .append("://")
                            .append(request.getServerName())
                            .append(":")
                            .append(request.getServerPort())
                            .append(path)
                            .append("/");
                    StringBuffer responseStr = new StringBuffer()
                            .append("<html><header><script type=\"text/javascript\">")
                            .append("window.location.href=\"")
                            .append(basePath).append(request.getContextPath()+"/loginout.action").append("\";")
                            .append("</script></header></html>");
                    response.getWriter().write(responseStr.toString());
                    logger.debug("请求路径：" + url + ",请求方式 ：普通请求, Session超时, 需要重新登录!");
                }
                return false;
            }
        }
        return true;
    }
}
