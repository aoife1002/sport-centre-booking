package com.example.venuebookingserver.integration;

import com.example.venuebookingserver.entity.Account;
import com.example.venuebookingserver.entity.User;
import com.example.venuebookingserver.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserServiceImplIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private MockHttpSession mockHttpSession;

    @BeforeEach
    public void setUp() {
        Account account = new Account();
        account.setId(1L);
        account.setType(1);
        account.setUserName("test");
        account.setPassword("test");

        mockHttpSession = new MockHttpSession();
        mockHttpSession.setAttribute("accountInfo",account);
    }

    @Test
    public void testGetUserInfo() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/getUserInfo")
                        .session(mockHttpSession))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateUserInfo() throws Exception {
        User user = new User();
        user.setEmail("test@163.com");
        user.setAge(1);
        user.setName("test");
        user.setAccountId(1L);

        mockMvc.perform(MockMvcRequestBuilders.put("/user/updateUserInfo")
                        .session(mockHttpSession)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk());
    }

    @Test
    public void testAddUserInfo() throws Exception {
        User user = new User();
        user.setAccountId(1787139641558102019L);
        user.setAge(1);
        user.setEmail("test");
        user.setName("test");

        mockMvc.perform(MockMvcRequestBuilders.post("/user/addUserInfo")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk()); // 修改预期的状态码为200（HTTP的OK状态）
    }

    @Test
    public void testGetUser() throws Exception {
        Long accountId = 1L; // 提供一个accountId的值
        mockMvc.perform(MockMvcRequestBuilders.get("/user/getDetails/{accountId}", accountId)
                        .session(mockHttpSession))
                .andExpect(status().isOk());
    }
}
