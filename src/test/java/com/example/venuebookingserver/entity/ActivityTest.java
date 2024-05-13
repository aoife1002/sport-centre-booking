package com.example.venuebookingserver.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ActivityTest {

    private Activity activity;

    @BeforeEach
    void setUp() {
        activity = new Activity();
    }

    @Test
    void testId() {
        Long id = 1L;
        activity.setId(id);
        assertEquals(id, activity.getId());
    }

    @Test
    void testType() {
        Integer type = 1;
        activity.setType(type);
        assertEquals(type, activity.getType());
    }

    @Test
    void testActivityType() {
        Integer activityType = 1;
        activity.setActivityType(activityType);
        assertEquals(activityType, activity.getActivityType());
    }

    @Test
    void testCapacity() {
        Integer capacity = 50;
        activity.setCapacity(capacity);
        assertEquals(capacity, activity.getCapacity());
    }

    @Test
    void testStartTime() {
        Timestamp startTime = new Timestamp(System.currentTimeMillis());
        activity.setStartTime(startTime);
        assertEquals(startTime, activity.getStartTime());
    }

    @Test
    void testEndTime() {
        Timestamp endTime = new Timestamp(System.currentTimeMillis());
        activity.setEndTime(endTime);
        assertEquals(endTime, activity.getEndTime());
    }

    @Test
    void testIsFull() {
        activity.setIsFull(true);
        assertTrue(activity.getIsFull());
    }
}