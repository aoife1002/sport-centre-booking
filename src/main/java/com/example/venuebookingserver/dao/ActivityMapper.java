package com.example.venuebookingserver.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.venuebookingserver.entity.Activity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ActivityMapper extends BaseMapper<Activity> {
}
