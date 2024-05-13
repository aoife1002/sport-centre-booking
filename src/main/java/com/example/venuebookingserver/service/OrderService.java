package com.example.venuebookingserver.service;

import com.example.venuebookingserver.common.R;
import com.example.venuebookingserver.entity.Order;

import javax.servlet.http.HttpSession;

public interface OrderService {
    R addOrder(Order order, HttpSession session);

    R cancelOrder(Order order, HttpSession session);

    R getOrders(HttpSession session);

    R checkInOrder(Order order, HttpSession session);

}
