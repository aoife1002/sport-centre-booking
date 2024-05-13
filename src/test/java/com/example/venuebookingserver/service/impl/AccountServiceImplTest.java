package com.example.venuebookingserver.service.impl;

import com.example.venuebookingserver.entity.Account;
import com.example.venuebookingserver.service.AccountService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;

@SpringBootTest
class AccountServiceImplTest {
    @Autowired
    AccountService accountService;

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
    public void testLogin() {
        Account account = new Account();
        account.setUserName("test");
        account.setPassword("test");
        accountService.login(account, mockHttpSession);
    }

    @Test
    public void testRegister() {
        Account account = new Account();
        account.setUserName("test");
        account.setPassword("test");
        accountService.register(account);
    }

    @Test
    public void testLogout() {
        accountService.logout(mockHttpSession);
    }


    @Test
    public void testUpdate() {
        Account account = new Account();
        account.setId(1L);
        account.setType(1);
        account.setUserName("test1");
        account.setPassword("test1");
        accountService.update(account);
    }

    @Test
    public void testGetList() {
        accountService.getList();
    }
}