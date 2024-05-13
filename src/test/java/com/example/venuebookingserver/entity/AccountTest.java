package com.example.venuebookingserver.entity;

import com.example.venuebookingserver.common.CommonConstant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AccountTest {

    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account();
    }

    @Test
    void isAdmin() {
        account.setType(CommonConstant.ROLE_ADMIN);
        assertTrue(account.isAdmin());
        assertFalse(account.isUser());
    }

    @Test
    void isUser() {
        account.setType(CommonConstant.ROLE_USER);
        assertTrue(account.isUser());
        assertFalse(account.isAdmin());
    }
}