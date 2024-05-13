package com.example.venuebookingserver.controller;

import com.example.venuebookingserver.entity.Activity;
import com.example.venuebookingserver.service.ActivityService;
import com.example.venuebookingserver.vo.ActivityQuery;
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

class ActivityControllerTest {

    @Mock
    private ActivityService activityService;

    @InjectMocks
    private ActivityController activityController;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(activityController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void getActivity() throws Exception {
        ActivityQuery activityQuery = new ActivityQuery();
        // Set the properties of the activityQuery object as needed
        // activityQuery.setType("some type");
        // activityQuery.setStartTime("some start time");
        // ...

        when(activityService.getActivity(any())).thenReturn(null);
        mockMvc.perform(post("/activity/list")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(activityQuery)))
                .andExpect(status().isOk());
    }

    @Test
    void deleteActivityById() throws Exception {
        Long id = 1L; // Set the ID of the activity to delete

        when(activityService.deleteActivityById(any())).thenReturn(null);
        mockMvc.perform(delete("/activity/{id}", id)) // Include the ID in the URL
                .andExpect(status().isOk());
    }

    @Test
    void addActivity() throws Exception {
        Activity activity = new Activity();
        // Set the properties of the activity object as needed
        // activity.setType("some type");
        // activity.setActivityType("some activity type");
        // ...

        when(activityService.addActivity(any())).thenReturn(null);
        mockMvc.perform(post("/activity/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(activity)))
                .andExpect(status().isOk());
    }

    @Test
    void updateActivity() throws Exception {
        Activity activity = new Activity();
        // Set the properties of the activity object as needed
        // activity.setId(1L);
        // activity.setType("some type");
        // activity.setActivityType("some activity type");
        // ...

        when(activityService.updateActivity(any())).thenReturn(null);
        mockMvc.perform(put("/activity/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(activity)))
                .andExpect(status().isOk());
    }
}


