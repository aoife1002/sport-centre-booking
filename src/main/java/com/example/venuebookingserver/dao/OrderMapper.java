package com.example.venuebookingserver.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.venuebookingserver.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {
    List<Order> selectOrderList(Long accountInfoId);
}
