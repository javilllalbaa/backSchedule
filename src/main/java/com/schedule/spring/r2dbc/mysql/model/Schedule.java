package com.schedule.spring.r2dbc.mysql.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Schedule {

    @Id
    private int id;
    private String name;
    private String description;
    private int duration_minutes;
    private String color_hex_code;

}
