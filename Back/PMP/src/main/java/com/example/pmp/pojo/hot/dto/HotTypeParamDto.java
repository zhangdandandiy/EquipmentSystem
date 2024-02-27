package com.example.pmp.pojo.hot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dandan
 * @date 2024/1/13 9:29
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotTypeParamDto {

    private String ProjectName;
    private String LineType;
    private String LineName;
    private String ModuleID;
    private int ErrorCode;
    private String CameraID;
    private String StartTime;
    private String EndTime;

}
