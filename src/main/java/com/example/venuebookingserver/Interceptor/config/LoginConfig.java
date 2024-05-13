package com.example.venuebookingserver.Interceptor.config;

import com.example.venuebookingserver.Interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class LoginConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(new LoginInterceptor());
        registration.addPathPatterns("/**"); //所有路径都被拦截
        registration.excludePathPatterns(    //添加不拦截路径
                "/login-page",                    //登录路径
                "/**/*.html",                //html静态资源
                "/**/*.js",                  //js静态资源
                "/**/*.css",                  //css静态资源
                "/**/*.jpg"
        );
    }
}
