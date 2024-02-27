package com.example.pmp.pojo.station;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 检测项信息
 *
 * @author Dandan
 * @date 2023/6/29 13:25
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SenseInfo {

    /**
     * 检测项名称
     */
    private String senseName;

    /**
     * 检测项投入
     */
    private String senseInput;

    /**
     * 检测项产出
     */
    private String senseOutput;

    /**
     * 检测项 NG
     */
    private String senseNG;

}
