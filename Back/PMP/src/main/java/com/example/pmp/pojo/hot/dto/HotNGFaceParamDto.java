package com.example.pmp.pojo.hot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dandan
 * @date 2024/2/21 12:55
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotNGFaceParamDto {

    private String pid;
    private String lineType;
    private String lineId;
    private String face;
    private String starttime;
    private String endtime;

}
