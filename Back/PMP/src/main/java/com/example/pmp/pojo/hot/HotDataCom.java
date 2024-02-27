package com.example.pmp.pojo.hot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Dandan
 * @date 2024/1/17 14:15
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotDataCom {

    private List<HotData> hotDataList;

    private BigDecimal minValue;

    private BigDecimal maxValue;

}
