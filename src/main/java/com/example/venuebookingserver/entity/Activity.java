package com.example.venuebookingserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.File;
import java.sql.Timestamp;

@Data
@TableName("vb_activity")
public class Activity {
    @TableId(type = IdType.AUTO)
    private Long id;
    // 1 羽毛球 2 健身房 3 篮球
    private Integer type;
    // 1 按场次 2 按人数
    private Integer activityType;
    private Integer capacity;
    private Timestamp startTime;
    private Timestamp endTime;



    @TableField(exist = false)
    private Boolean isFull;


}
