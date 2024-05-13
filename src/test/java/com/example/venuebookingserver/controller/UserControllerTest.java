package com.example.venuebookingserver.controller;

import com.example.venuebookingserver.entity.User;
import com.example.venuebookingserver.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void getUserInfo() throws Exception {
        when(userService.getUserInfo(any())).thenReturn(null);
        mockMvc.perform(get("/user/getUserInfo"))
                .andExpect(status().isOk());
    }

    @Test
    void updateUserInfo() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setName("Test User");
        user.setEmail("testuser@example.com");

        when(userService.updateUserInfo(any(User.class), any())).thenReturn(null);

        mockMvc.perform(put("/user/updateUserInfo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk());
    }

    @Test
    void addUserInfo() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setName("Test User");
        user.setEmail("testuser@example.com");

        when(userService.addUserInfo(any(User.class))).thenReturn(null);

        mockMvc.perform(post("/user/addUserInfo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk());
    }
    @Test
    void getUser() throws Exception {
        Long accountId = 1L;
        when(userService.getUser(accountId)).thenReturn(null);
        mockMvc.perform(get("/user/getDetails/{accountId}", accountId))
                .andExpect(status().isOk());
    }
}