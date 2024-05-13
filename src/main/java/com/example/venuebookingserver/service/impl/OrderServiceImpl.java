package com.example.venuebookingserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.venuebookingserver.common.CommonConstant;
import com.example.venuebookingserver.common.R;
import com.example.venuebookingserver.dao.ActivityMapper;
import com.example.venuebookingserver.dao.OrderMapper;
import com.example.venuebookingserver.dao.UserMapper;
import com.example.venuebookingserver.entity.Account;
import com.example.venuebookingserver.entity.Activity;
import com.example.venuebookingserver.entity.Order;
import com.example.venuebookingserver.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    ActivityMapper activityMapper;


    /**
     * 添加订单
     * @param order 订单
     * @param session session
     * @return R
     */
    @Override
    public R addOrder(@RequestBody Order order, HttpSession session) {
        Account accountInfo = (Account) session.getAttribute("accountInfo");
        if (Objects.isNull(accountInfo)) {
            return R.error("Not logged in");
        }
        if (Objects.isNull(accountInfo.getId())) {
            return R.error("accountId does not exist");
        }
        if (Objects.isNull(order.getActivityId())) {
            return R.error("Activity does not exist");
        }
        QueryWrapper<Activity> queryWrapperActivity = new QueryWrapper<>();
        queryWrapperActivity.eq("id", order.getActivityId());
        Activity activity = activityMapper.selectOne(queryWrapperActivity);
        if (activity == null) {
            return R.error("Activity does not exist");
        }

        synchronized (this) {
            // 查找订单 超过人数了就不能预定
            if (CommonConstant.ACTIVITY_TYPE_PEOPLE.equals(activity.getActivityType())) {
                QueryWrapper<Order> queryWrapperOrder = new QueryWrapper<>();
                queryWrapperOrder.eq("activity_id", order.getActivityId());
                queryWrapperOrder.ne("status", CommonConstant.ORDER_STATUS_CANCEL);
                Long count = orderMapper.selectCount(queryWrapperOrder);
                if (count >= activity.getCapacity()) {
                    return R.error("Activity is full");
                }
            }else if (CommonConstant.ACTIVITY_TYPE_VENUE.equals(activity.getActivityType())) {
                QueryWrapper<Order> queryWrapperOrder = new QueryWrapper<>();
                queryWrapperOrder.eq("activity_id", order.getActivityId());
                queryWrapperOrder.ne("status", CommonConstant.ORDER_STATUS_CANCEL);
                Long count = orderMapper.selectCount(queryWrapperOrder);
                if (count > 0) {
                    return R.error("Activity is full");
                }
            }
            QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("account_id", accountInfo.getId());
            queryWrapper.eq("activity_id", order.getActivityId());
            Order queryOrder = orderMapper.selectOne(queryWrapper);
            if (Objects.nonNull(queryOrder)) {
                return R.error("order is exist");
            }
            order.setAccountId(accountInfo.getId());
            if (orderMapper.insert(order) > 0) {
                return R.success("order added successfully");
            }
            return R.error("order added failed");
        }
    }

    /**
     * 取消订单
     * @param order 订单
     * @param session session  为什么下面还去检测用户信息，而不是根据getOrders里面拿到的订单信息（那里面都做了身份判断） 直接取消订单 ？ 为什么要重复检测一遍？
     *                因为害怕有人直接去调用cancelOrder接口
     * @return R
     */
    @Override
    public R cancelOrder(@RequestBody Order order, HttpSession session) {
        Account accountInfo = (Account) session.getAttribute("accountInfo");
        if (Objects.isNull(accountInfo)) {
            return R.error("Not logged in");
        }
        if (Objects.isNull(accountInfo.getType())) {
            return R.error("accountType is null");
        }
        order.setStatus(CommonConstant.ORDER_STATUS_CANCEL);
        if (accountInfo.isAdmin()) {
            if (orderMapper.updateById(order) > 0) {
                return R.success("cancel order successfully");
            }
        }else if (accountInfo.isUser()) {
            QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("account_id", accountInfo.getId());
            queryWrapper.eq("activity_id", order.getActivityId());
            queryWrapper.eq("id", order.getId());
            Order queryOrder = orderMapper.selectOne(queryWrapper);
            if (Objects.isNull(queryOrder)) {
                return R.error("order does not exist");
            }
            if (orderMapper.updateById(order) > 0) {
                return R.success("cancel order successfully");
            }
        }
        return R.error("cancel order failed");
    }

    /**
     * 获取订单
     * @param session session
     * @return R
     */
    @Override
    public R getOrders(HttpSession session) {
        Account accountInfo = (Account) session.getAttribute("accountInfo");
        if (Objects.isNull(accountInfo)) {
            return R.error("Not logged in");
        }
        if (Objects.isNull(accountInfo.getId())) {
            return R.error("User does not exist");
        }
        if (accountInfo.isAdmin()) {
            return R.success("select orders by admin",orderMapper.selectOrderList(null));
        }else if (accountInfo.isUser()) {
            Long accountInfoId = accountInfo.getId();
            return R.success("select orders by user",orderMapper.selectOrderList(accountInfoId));
        }

        return R.error("get orders failed");
    }

    /**
     * 检入订单
     * @param order 订单
     * @param session session 也是可以做校验的
     * @return R
     */
    @Override
    public R checkInOrder(@RequestBody Order order, HttpSession session) {
        order.setStatus(CommonConstant.ORDER_STATUS_CHECK_IN);
        //下面是魔法值
        //order.setStatus(0);
        Account accountInfo = (Account) session.getAttribute("accountInfo");
        if (Objects.isNull(accountInfo)) {
            return R.error("Not logged in");
        }
        if (Objects.isNull(accountInfo.getId())) {
            return R.error("User does not exist");
        }
        if (accountInfo.isAdmin()) {
            if (orderMapper.updateById(order) > 0) {
                return R.success("check in order successfully");
            }
        }else if (accountInfo.isUser()) {
            QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("account_id", accountInfo.getId());
            queryWrapper.eq("activity_id", order.getActivityId());
            queryWrapper.eq("id", order.getId());
            queryWrapper.eq("status", CommonConstant.ORDER_STATUS_RESERVE);
            Order queryOrder = orderMapper.selectOne(queryWrapper);
            if (Objects.isNull(queryOrder)) {
                return R.error("order does not exist or already check in");
            }
            if (orderMapper.updateById(order) > 0) {
                return R.success("cancel order successfully");
            }
        }

        return R.error("check in order failed");
    }
}
