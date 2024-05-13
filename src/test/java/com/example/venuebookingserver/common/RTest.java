package com.example.venuebookingserver.common;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RTest {

    @Test
    void testSuccess() {
        String message = "Success";
        R r = R.success(message);
        assertEquals(200, r.getCode());
        assertEquals(message, r.getMessage());
        assertTrue(r.getSuccess());
        assertEquals("success", r.getType());
        assertNull(r.getData());
    }

    @Test
    void testSuccessWithData() {
        String message = "Success";
        String data = "Data";
        R r = R.success(message, data);
        assertEquals(200, r.getCode());
        assertEquals(message, r.getMessage());
        assertTrue(r.getSuccess());
        assertEquals("success", r.getType());
        assertEquals(data, r.getData());
    }

    @Test
    void testWarning() {
        String message = "Warning";
        R r = R.warning(message);
        assertEquals(200, r.getCode());
        assertEquals(message, r.getMessage());
        assertFalse(r.getSuccess());
        assertEquals("warning", r.getType());
        assertNull(r.getData());
    }

    @Test
    void testError() {
        String message = "Error";
        R r = R.error(message);
        assertEquals(200, r.getCode());
        assertEquals(message, r.getMessage());
        assertFalse(r.getSuccess());
        assertEquals("error", r.getType());
        assertNull(r.getData());
    }

    @Test
    void testFatal() {
        String message = "Fatal";
        R r = R.fatal(message);
        assertEquals(500, r.getCode());
        assertEquals(message, r.getMessage());
        assertFalse(r.getSuccess());
        assertEquals("error", r.getType());
        assertNull(r.getData());
    }
}