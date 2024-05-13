package com.example.venuebookingserver.dao;

import com.example.venuebookingserver.entity.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class AccountMapperTest {

    @Mock
    private AccountMapper accountMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void queryAccount() {
        // Arrange
        String userName = "testUser";
        String password = "testPassword";
        Account expectedAccount = new Account();
        expectedAccount.setUserName(userName);
        expectedAccount.setPassword(password);

        when(accountMapper.queryAccount(userName, password)).thenReturn(expectedAccount);

        // Act
        Account actualAccount = accountMapper.queryAccount(userName, password);

        // Assert
        assertEquals(expectedAccount, actualAccount);
    }
}