package com.example.venuebookingserver.controller;

import com.example.venuebookingserver.entity.Order;
import com.example.venuebookingserver.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class OrderControllerTest {

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    private MockMvc mockMvc;



    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void getOrder() throws Exception {
        when(orderService.getOrders(any())).thenReturn(null);
        mockMvc.perform(get("/order/getOrder"));

    }
    @Test
    void addOrder() throws Exception {
        Order order = new Order();
        when(orderService.addOrder(any(), any())).thenReturn(null);
        mockMvc.perform(post("/order/addOrder")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(order)))
                .andExpect(status().isOk());
    }
    @Test
    void cancelOrder() throws Exception {
        Order order = new Order();
        when(orderService.cancelOrder(any(), any())).thenReturn(null);
        mockMvc.perform(post("/order/cancelOrder")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(order)))
                .andExpect(status().isOk());
    }
    @Test
    void checkInOrder() throws Exception {
        Order order = new Order();
        when(orderService.checkInOrder(any(), any())).thenReturn(null);
        mockMvc.perform(post("/order/checkInOrder")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(order)))
                .andExpect(status().isOk());
    }




}