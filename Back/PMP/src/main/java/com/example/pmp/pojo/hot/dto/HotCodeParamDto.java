package com.example.pmp.pojo.hot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dandan
 * @date 2024/1/25 8:10
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotCodeParamDto {

    private String ProjectName;
    private String LineType;
    private String LineName;
    private String ModuleID;
    private String Direction;
    private String StartTime;
    private String EndTime;

}
