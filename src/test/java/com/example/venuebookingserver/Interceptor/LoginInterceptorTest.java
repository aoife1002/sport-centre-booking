package com.example.venuebookingserver.Interceptor;

import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LoginInterceptorTest {

    @Test
    void preHandle() throws Exception {
        // 创建一个 LoginInterceptor 对象
        LoginInterceptor loginInterceptor = new LoginInterceptor();

        // 创建一个模拟的 HttpServletRequest 和 HttpServletResponse 对象
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();

        // 调用 preHandle 方法
        boolean result = loginInterceptor.preHandle(request, response, null);

        // 验证 preHandle 方法的返回值是否为 true
        assertTrue(result);
    }
}