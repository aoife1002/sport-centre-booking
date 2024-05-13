package com.example.venuebookingserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("vb_order")
public class Order {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long accountId;
    private Long activityId;
    // 1 已预定 2 进场 3 已取消
    private Integer status;

    @TableField(exist = false)
    private Integer type;

    @TableField(exist = false)
    private Integer activityType;

    @TableField(exist = false)
    private Integer capacity;

    @TableField(exist = false)
    private String startTime;

    @TableField(exist = false)
    private String endTime;
}
