package com.example.venuebookingserver.integration;

import com.example.venuebookingserver.entity.Account;
import com.example.venuebookingserver.entity.Activity;
import com.example.venuebookingserver.service.ActivityService;
import com.example.venuebookingserver.vo.ActivityQuery;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.sql.Timestamp;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ActivityServiceImplIntegrationTest {

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
    public void testAddActivity() throws Exception {
        Activity activity = new Activity();
        activity.setActivityType(1);
        activity.setStartTime(new Timestamp(System.currentTimeMillis()));
        activity.setEndTime(new Timestamp(System.currentTimeMillis()));

        mockMvc.perform(MockMvcRequestBuilders.post("/activity/add")
                        .session(mockHttpSession)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(activity)))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetActivity() throws Exception {
        ActivityQuery param = new ActivityQuery();
        param.setType(1);
        param.setEndTime(new Timestamp(System.currentTimeMillis()));
        param.setStartTime(new Timestamp(System.currentTimeMillis()));

        mockMvc.perform(MockMvcRequestBuilders.post("/activity/list")
                        .session(mockHttpSession)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(param)))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateActivity() throws Exception {
        Activity activity = new Activity();
        activity.setId(1L);
        activity.setActivityType(1);
        activity.setStartTime(new Timestamp(System.currentTimeMillis()));
        activity.setEndTime(new Timestamp(System.currentTimeMillis()));

        mockMvc.perform(MockMvcRequestBuilders.put("/activity/update")
                        .session(mockHttpSession)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(activity)))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteActivityById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/activity/{id}", 1L)
                        .session(mockHttpSession))
                .andExpect(status().isOk());
    }
}