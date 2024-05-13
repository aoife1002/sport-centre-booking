package com.example.venuebookingserver.Interceptor.config;

import com.example.venuebookingserver.Interceptor.LoginInterceptor;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import static org.mockito.Mockito.*;

class LoginConfigTest {

    @Test
    void addInterceptors() {
        // 创建一个 mock 对象
        InterceptorRegistry registry = mock(InterceptorRegistry.class);
        InterceptorRegistration registration = mock(InterceptorRegistration.class);

        // 当 registry.addInterceptor 方法被调用时，返回我们预设的 registration 对象
        when(registry.addInterceptor(any(LoginInterceptor.class))).thenReturn(registration);

        // 创建一个 LoginConfig 对象并调用 addInterceptors 方法
        LoginConfig loginConfig = new LoginConfig();
        loginConfig.addInterceptors(registry);

        // 验证 registry.addInterceptor 方法是否被调用
        verify(registry, times(1)).addInterceptor(any(LoginInterceptor.class));
    }
}