package com.example.pmp.pojo.hot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Dandan
 * @date 2024/2/21 10:44
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotNGRateParamDto {

    private String pid;
    private String lineType;
    private String lineId;
    private String starttime;
    private String endtime;

}
