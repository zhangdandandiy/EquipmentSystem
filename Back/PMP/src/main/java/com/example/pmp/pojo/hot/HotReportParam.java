package com.example.pmp.pojo.hot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Dandan
 * @date 2024/3/20 16:20
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotReportParam extends HotReport{

    private BigDecimal PositionX;

    private BigDecimal PositionY;

}
