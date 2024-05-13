package com.example.venuebookingserver.common;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommonConstantTest {

    @Test
    void testRoleAdmin() {
        assertEquals(0, CommonConstant.ROLE_ADMIN);
    }

    @Test
    void testRoleUser() {
        assertEquals(1, CommonConstant.ROLE_USER);
    }

    @Test
    void testOrderStatusReserve() {
        assertEquals(0, CommonConstant.ORDER_STATUS_RESERVE);
    }

    @Test
    void testOrderStatusCheckIn() {
        assertEquals(1, CommonConstant.ORDER_STATUS_CHECK_IN);
    }

    @Test
    void testOrderStatusCancel() {
        assertEquals(2, CommonConstant.ORDER_STATUS_CANCEL);
    }

    @Test
    void testActivityTypeVenue() {
        assertEquals(1, CommonConstant.ACTIVITY_TYPE_VENUE);
    }

    @Test
    void testActivityTypePeople() {
        assertEquals(2, CommonConstant.ACTIVITY_TYPE_PEOPLE);
    }
}