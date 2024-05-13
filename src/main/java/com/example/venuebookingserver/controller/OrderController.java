package com.example.venuebookingserver.controller;


import com.example.venuebookingserver.common.R;
import com.example.venuebookingserver.entity.Order;
import com.example.venuebookingserver.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RequestMapping("/order")
@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    /**
     * 添加订单
     * @param order 订单 （activityId,status）
     * @param session session
     * @return R
     */
    @ResponseBody
    @PostMapping("/addOrder")
    public R addOrder(@RequestBody Order order, HttpSession session) {
        return orderService.addOrder(order,session);
    }

    /**
     * 取消订单
     * @param order 订单 （id)
     * @param session session
     * @return R
     */
    @ResponseBody
    @PostMapping("/cancelOrder")
    public R cancelOrder(@RequestBody Order order,HttpSession session) {
        return orderService.cancelOrder(order,session);
    }

    /**
     * 签到订单
     * @param order 订单 （id)
     * @param session session
     * @return R
     */
    @ResponseBody
    @PostMapping("/checkInOrder")
    public R checkInOrder(@RequestBody Order order,HttpSession session) {
        return orderService.checkInOrder(order,session);
    }

    /**
     * 获取订单
     * @param session session
     * @return R
     */
    @ResponseBody
    @GetMapping("/getOrders")
    public R getOrders(HttpSession session) {
        return orderService.getOrders(session);
    }


}
