package com.tjetc.config;

import com.tjetc.interceptor.LoginInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@Component
public class LoginInterceptorConfig implements WebMvcConfigurer {
    //配置拦截器，添加登录拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加登录拦截器
        registry.addInterceptor(new LoginInterceptor())
                //对哪些url请求使用登录拦截器
                .addPathPatterns("/**")
                //排除掉哪些url不登录拦截器拦截
                .excludePathPatterns("/user/login", "/user/register", "/user/home", "/user/home/**", "/image/**", "/css/**");
    }
}
