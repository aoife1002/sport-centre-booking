package com.example.venuebookingserver.dao;

import com.example.venuebookingserver.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class UserMapperTest {

    @Mock
    private UserMapper userMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getUserById() {
        // Arrange
        Long id = 1L;
        User expectedUser = new User();
        expectedUser.setId(id);
        // Set other properties of the user as needed
        // expectedUser.setName("Test User");
        // expectedUser.setEmail("testuser@example.com");
        // ...

        when(userMapper.selectById(id)).thenReturn(expectedUser);

        // Act
        User actualUser = userMapper.selectById(id);

        // Assert
        assertEquals(expectedUser, actualUser);
    }
}