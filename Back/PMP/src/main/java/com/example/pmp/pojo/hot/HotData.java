package com.example.pmp.pojo.hot;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Dandan
 * @date 2024/1/6 9:23
 **/
@Data
@NoArgsConstructor
public class HotData {

    private String direction;
    private BigDecimal xAxis;
    private BigDecimal yAxis;
    private BigDecimal count;
    private BigDecimal sum;
    private BigDecimal percentage;

    public HotData(String direction, BigDecimal xAxis, BigDecimal yAxis, BigDecimal count, BigDecimal sum, BigDecimal percentage) {
        this.direction = direction;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.count = count;
        this.sum = sum;
        this.percentage = percentage;
    }
}
