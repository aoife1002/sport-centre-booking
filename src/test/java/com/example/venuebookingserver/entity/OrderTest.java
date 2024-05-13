package com.example.venuebookingserver.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderTest {

    private Order order;

    @BeforeEach
    void setUp() {
        order = new Order();
    }

    @Test
    void testId() {
        Long id = 1L;
        order.setId(id);
        assertEquals(id, order.getId());
    }

    @Test
    void testAccountId() {
        Long accountId = 1L;
        order.setAccountId(accountId);
        assertEquals(accountId, order.getAccountId());
    }

    @Test
    void testActivityId() {
        Long activityId = 1L;
        order.setActivityId(activityId);
        assertEquals(activityId, order.getActivityId());
    }

    @Test
    void testStatus() {
        Integer status = 1;
        order.setStatus(status);
        assertEquals(status, order.getStatus());
    }
}