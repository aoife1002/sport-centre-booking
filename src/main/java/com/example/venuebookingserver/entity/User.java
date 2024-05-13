package com.example.venuebookingserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.beans.Transient;

@Data
@TableName("vb_user")
public class User {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long accountId;
    private String name;
    private Integer age;
    private String email;
}
