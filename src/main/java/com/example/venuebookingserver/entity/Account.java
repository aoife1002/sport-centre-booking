package com.example.venuebookingserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.venuebookingserver.common.CommonConstant;
import lombok.Data;

@Data
@TableName("vb_account")
public class Account {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String userName;
    private String password;

    // 0 管理员 1 用户
    private Integer type;

    public boolean isAdmin(){
        return CommonConstant.ROLE_ADMIN.equals(type);
    }
    public boolean isUser(){
        return CommonConstant.ROLE_USER.equals(type);
    }
}


//M是指模型，V是视图，C是控制器
//MVC是一种设计模式，它将应用程序分为三个主要组成部分：模型、视图和控制器。
//模型（Model）是应用程序中用于处理应用程序数据逻辑的部分。
//视图（View）是应用程序中处理数据显示的部分。
//控制器（Controller）是应用程序中处理用户交互的部分。
//MVC模式的目的是将应用程序的不同方面分离，同时提供一种方法来将这些不同方面组合在一起。