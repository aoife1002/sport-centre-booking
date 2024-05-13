package com.example.venuebookingserver.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
    }

    @Test
    void testId() {
        Long id = 1L;
        user.setId(id);
        assertEquals(id, user.getId());
    }

    @Test
    void testAccountId() {
        Long accountId = 1L;
        user.setAccountId(accountId);
        assertEquals(accountId, user.getAccountId());
    }

    @Test
    void testName() {
        String name = "Test User";
        user.setName(name);
        assertEquals(name, user.getName());
    }

    @Test
    void testAge() {
        Integer age = 25;
        user.setAge(age);
        assertEquals(age, user.getAge());
    }

    @Test
    void testEmail() {
        String email = "test@example.com";
        user.setEmail(email);
        assertEquals(email, user.getEmail());
    }
}