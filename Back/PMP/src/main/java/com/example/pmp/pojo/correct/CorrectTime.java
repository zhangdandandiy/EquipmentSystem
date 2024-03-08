package com.example.pmp.pojo.correct;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Dandan
 * @date 2024/3/8 8:42
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CorrectTime {

    private String id;
    private String Product;
    private String StartTime;
    private String EndTime;
    private Date UpdateTime;

}
