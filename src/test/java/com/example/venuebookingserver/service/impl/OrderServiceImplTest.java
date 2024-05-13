package com.example.venuebookingserver.service.impl;

import com.example.venuebookingserver.entity.Account;
import com.example.venuebookingserver.entity.Order;
import com.example.venuebookingserver.service.OrderService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;

@SpringBootTest
class OrderServiceImplTest {
    @Autowired
    OrderService orderService;

    static MockHttpSession mockHttpSession;

    @BeforeAll
    public static void setUp() {

        Account account = new Account();
        account.setId(1L);
        account.setType(1);
        account.setUserName("test");
        account.setPassword("test");

        mockHttpSession = new MockHttpSession();
        mockHttpSession.setAttribute("accountInfo",account);
    }

    @Test
    public void testAddOrder() {
        Order order = new Order();
        order.setActivityId(1L);
        order.setAccountId(10L);
        order.setStatus(1);
        orderService.addOrder(order, mockHttpSession);
    }

    @Test
    public void testCancelOrder() {
        Order order = new Order();
        order.setActivityId(1L);
        order.setAccountId(10L);
        order.setStatus(1);
        orderService.cancelOrder(order, mockHttpSession);
    }

    @Test
    public void testGetOrders() {
        orderService.getOrders(mockHttpSession);
    }


    @Test
    public void testCheckInOrder() {
        Order order = new Order();
        order.setActivityId(1L);
        order.setAccountId(10L);
        order.setStatus(1);
        orderService.checkInOrder(order,mockHttpSession);
    }
}