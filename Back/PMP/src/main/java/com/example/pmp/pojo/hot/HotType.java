package com.example.pmp.pojo.hot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Dandan
 * @date 2024/1/6 9:13
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotType {

    private String ProjectName;
    private String LineType;
    private String LineName;
    private String ModuleID;
    private String CameraID;
    private String Direction;
    private int ErrorCode;
    private String NGName;
    private int ErrorNum;
    private BigDecimal PositionX;
    private BigDecimal PositionY;
    private String TestTime;

}
