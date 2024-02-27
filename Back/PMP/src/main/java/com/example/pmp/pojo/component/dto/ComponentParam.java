package com.example.pmp.pojo.component.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dandan
 * @date 2024/1/16 10:50
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComponentParam {

    private String type;
    private String startTime;
    private String endTime;

}
