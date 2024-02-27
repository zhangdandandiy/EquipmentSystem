package com.example.pmp.pojo.correct;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Dandan
 * @date 2024/1/5 19:01
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CorrectStatus {

    private int id;
    private String pid;
    private String lid;
    private String module;
    private String station;
    private String name;
    private int sort;
    private int complete;
    private int flag;
    private Date updateTime;

}
