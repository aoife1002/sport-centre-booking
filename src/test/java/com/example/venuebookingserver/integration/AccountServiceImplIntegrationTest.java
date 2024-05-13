package com.example.venuebookingserver.integration;

import com.example.venuebookingserver.entity.Account;
import com.example.venuebookingserver.service.AccountService;
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
public class AccountServiceImplIntegrationTest {

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
    public void testLogin() throws Exception {
        Account account = new Account();
        account.setUserName("test");
        account.setPassword("test");

        mockMvc.perform(MockMvcRequestBuilders.post("/account/login")
                        .session(mockHttpSession)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(account)))
                .andExpect(status().isOk());
    }

    @Test
    public void testLogout() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/account/logout")
                        .session(mockHttpSession))
                .andExpect(status().isOk());
    }

    @Test
    public void testRegister() throws Exception {
        Account account = new Account();
        account.setUserName("testRegister");
        account.setPassword("testRegister");
        account.setType(1);

        mockMvc.perform(MockMvcRequestBuilders.post("/account/register")
                        .session(mockHttpSession)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(account)))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdate() throws Exception {
        Account account = new Account();
        account.setId(1L);
        account.setUserName("testUpdate");
        account.setPassword("testUpdate");
        account.setType(1);

        mockMvc.perform(MockMvcRequestBuilders.post("/account/update")
                        .session(mockHttpSession)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(account)))
                .andExpect(status().isOk());
    }
}
