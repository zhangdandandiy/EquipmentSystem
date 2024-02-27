package com.example.pmp.pojo.component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Dandan
 * @date 2024/1/16 11:06
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComponentFAI {

    /**
     * FAI 的名称
     */
    private String name;

    /**
     * 下界值 = Q1 - 1.5 · IQR
     */
    private BigDecimal min;

    /**
     * 上四分位数Q3 第三四分位数 75百分位数
     */
    private BigDecimal lowerQuartile;

    /**
     * 第二四分位数Q2 50百分位数 中位数
     */
    private BigDecimal medium;

    /**
     * 下四分位数Q1 第一四分位数 25百分位数
     */
    private BigDecimal upperQuartile;

    /**
     * 上界 = Q3 + 1.5 · IQR
     */
    private BigDecimal max;

    /**
     * 四分位差 IQR = Q3 - Q1
     */
    private BigDecimal IQR;

}
