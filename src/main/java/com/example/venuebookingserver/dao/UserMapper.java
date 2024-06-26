package com.example.venuebookingserver.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.venuebookingserver.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
