package com.example.venuebookingserver.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.venuebookingserver.entity.Account;
import com.example.venuebookingserver.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AccountMapper extends BaseMapper<Account> {


    @Select("select * from vb_account where user_name = #{userName} and password = #{password} ")
    Account queryAccount(@Param("userName")String userName, @Param("password")String password);

}
