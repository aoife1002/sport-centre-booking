package com.example.venuebookingserver.service.impl;

import com.example.venuebookingserver.common.R;
import com.example.venuebookingserver.entity.Account;
import com.example.venuebookingserver.entity.User;
import com.example.venuebookingserver.service.UserService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;

@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    UserService userService;

    static MockHttpSession mockHttpSession;
    @BeforeAll
    public static void setUp() {

        Account account = new Account();
        account.setId(1L);
        account.setType(1);
        account.setUserName("test");
        account.setPassword("test");

        mockHttpSession = new MockHttpSession();
        mockHttpSession.setAttribute("accountInfo",account);
    }

    @Test
    public void testGetUserInfo() {
        userService.getUserInfo(mockHttpSession);
    }

    @Test
    public void testUpdateUserInfo() {
        User user = new User();
        user.setEmail("test@163.com");
        user.setAge(1);
        user.setName("test");
        user.setAccountId(1L);
        userService.updateUserInfo(user, mockHttpSession);
    }

    @Test
    public void testAddUserInfo() {
        User user = new User();
        user.setAccountId(1787139641558102019L);
        user.setAge(1);
        user.setEmail("test");
        user.setName("test");
        R r = userService.addUserInfo(user);
        System.out.println(r);
    }

    @Test
    public void testGetUser() {
        userService.getUser(1L);
    }

}
