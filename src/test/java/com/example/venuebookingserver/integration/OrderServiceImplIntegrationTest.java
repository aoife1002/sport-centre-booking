package com.example.venuebookingserver.integration;

import com.example.venuebookingserver.entity.Account;
import com.example.venuebookingserver.entity.Order;
import com.example.venuebookingserver.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.sql.Timestamp;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderServiceImplIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private MockHttpSession mockHttpSession;

    @BeforeEach
    public void setUp() {
        Account account = new Account();
        account.setId(1L);
        account.setType(1);
        account.setUserName("test");
        account.setPassword("test");

        mockHttpSession = new MockHttpSession();
        mockHttpSession.setAttribute("accountInfo",account);
    }

    @Test
    public void testAddOrder() throws Exception {
        Order order = new Order();
        // Set the properties of the order object as per your requirements

        mockMvc.perform(MockMvcRequestBuilders.post("/order/addOrder")
                        .session(mockHttpSession)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(order)))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetOrder() throws Exception {
        Long orderId = 1L; // Provide an orderId value

        mockMvc.perform(MockMvcRequestBuilders.get("/order/getOrders", orderId)
                        .session(mockHttpSession))
                .andExpect(status().isOk());
    }

    @Test
    public void testCancelOrder() throws Exception {
        Order order = new Order();
        order.setId(1L);
        // Set the other properties of the order object as per your requirements

        mockMvc.perform(MockMvcRequestBuilders.post("/order/cancelOrder")
                        .session(mockHttpSession)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(order)))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteOrderById() throws Exception {
        Order order = new Order();
        order.setId(1L);
        // Set the other properties of the order object as per your requirements

        mockMvc.perform(MockMvcRequestBuilders.post("/order/cancelOrder")
                        .session(mockHttpSession)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(order)))
                .andExpect(status().isOk());
    }
}
