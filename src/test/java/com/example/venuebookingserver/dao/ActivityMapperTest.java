package com.example.venuebookingserver.dao;

import com.example.venuebookingserver.entity.Activity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ActivityMapperTest {

    @Mock
    private ActivityMapper activityMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getActivityById() {
        // Arrange
        Long id = 1L;
        Activity expectedActivity = new Activity();
        expectedActivity.setId(id);
        // Set other properties of the activity as needed
        // expectedActivity.setName("Test Activity");
        // expectedActivity.setDescription("This is a test activity");
        // ...

        when(activityMapper.selectById(id)).thenReturn(expectedActivity);

        // Act
        Activity actualActivity = activityMapper.selectById(id);

        // Assert
        assertEquals(expectedActivity, actualActivity);
    }
}