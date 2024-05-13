package com.example.venuebookingserver.controller;

import com.example.venuebookingserver.common.R;
import com.example.venuebookingserver.entity.Account;
import com.example.venuebookingserver.service.AccountService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private AccountService accountService;

    @InjectMocks
    private AccountController accountController;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        objectMapper = new ObjectMapper();
    }

//    @Test
//    void login() throws Exception {
//        Account account = new Account();
//        account.setUserName("user");
//        account.setPassword("1233975");
//
//        when(accountService.login(any(Account.class), any())).thenReturn(null);
//
//        mockMvc.perform(post("/account/login")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(account)))
//                .andExpect(status().isOk());
//    }

    @Test
    void login() throws Exception {
        // 创建一个 Account 对象
        Account account = new Account();
        account.setUserName("testUser");
        account.setPassword("testPassword");

        // 创建一个 R 对象作为 accountService.login 方法的返回值
        R r = new R();
        r.setCode(200);
        r.setMessage("Login successful");
        r.setSuccess(true);
        r.setType("success");
        r.setData(account);

        // 当 accountService.login 方法被调用时，返回我们预设的 R 对象
        when(accountService.login(any(Account.class), any())).thenReturn(r);

        // 模拟一个 POST 请求到 /account/login 路径
        mockMvc.perform(post("/account/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(account)))
                .andExpect(status().isOk())  // 验证 HTTP 状态码是否为 200
                .andExpect((ResultMatcher) content().json(objectMapper.writeValueAsString(r)));  // 验证返回的内容是否与我们预设的 R 对象相同
    }

    @Test
    void logout() throws Exception {
        mockMvc.perform(post("/account/logout"))
                .andExpect(status().isOk());
    }

    @Test
    void register() throws Exception {
        Account account = new Account();
        // Set the properties of the account object as needed
        // account.setUserName("new username");
        // account.setPassword("new password");
        // account.setType(1); // for example, if type is needed

        when(accountService.register(any())).thenReturn(null);
        mockMvc.perform(post("/account/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(account)))
                .andExpect(status().isOk());
    }

    @Test
    void update() throws Exception {
        Account account = new Account();
        // Set the properties of the account object as needed
        // account.setId(1L);
        // account.setUserName("new username");
        // account.setPassword("new password");
        // ...

        when(accountService.update(any())).thenReturn(null);
        mockMvc.perform(put("/account/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(account)))
                .andExpect(status().isOk());
    }
}