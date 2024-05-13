package com.example.venuebookingserver.dao;

import com.example.venuebookingserver.entity.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class OrderMapperTest {

    @Mock
    private OrderMapper orderMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void selectOrderList() {
        // Arrange
        Long accountInfoId = 1L;
        Order order1 = new Order();
        order1.setId(1L);
        // Set other properties of the order as needed
        // order1.setActivityId(1L);
        // order1.setUserId(1L);
        // ...

        Order order2 = new Order();
        order2.setId(2L);
        // Set other properties of the order as needed
        // order2.setActivityId(2L);
        // order2.setUserId(1L);
        // ...

        List<Order> expectedOrders = Arrays.asList(order1, order2);

        when(orderMapper.selectOrderList(accountInfoId)).thenReturn(expectedOrders);

        // Act
        List<Order> actualOrders = orderMapper.selectOrderList(accountInfoId);

        // Assert
        assertEquals(expectedOrders, actualOrders);
    }
}