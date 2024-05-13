package com.example.venuebookingserver.vo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ActivityQuery {
    private Integer type;

    private Timestamp startTime;

    private Timestamp endTime;

    private Boolean showAll;
}
