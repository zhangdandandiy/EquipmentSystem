package com.example.pmp.pojo.hot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Dandan
 * @date 2024/1/13 9:24
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotFace {

    private Long ID;
    private String LineID;
    private String FaceName;
    private BigDecimal XAxis;
    private BigDecimal YAxis;

}
