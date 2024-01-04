package com.tjetc.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.tjetc.common.JsonResult;
import com.tjetc.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取session
        log.info("登录校验");
        HttpSession session = request.getSession();
        //判断session是否有登录标记  
        Object username = session.getAttribute("user");
        User comUser = (User)session.getAttribute("comUser");
        //有登录标记就放行，没有就禁止向下运行
        if (username != null || comUser != null) {
            //放行
            return true;
        } else {
            response.setHeader("Content-Type", "application/json;charset=UTF-8");
            //跳转登录页面，禁止向下运行
            JsonResult jsonResult = new JsonResult(-1, "未登录或登录过期", null);
            String jsonString = JSONObject.toJSONString(jsonResult);
            response.getWriter().write(jsonString);
            return false;
        }
    }
}
