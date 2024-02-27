package com.example.pmp.pojo.correct.d9x;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dandan
 * @date 2024/1/18 9:56
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Station1D9X {

    private String Barcode;
    // 注意：D9X Station1 的这个字段需要处理
    private String LASER_ETCH_BARCODE;
    private String Barcode_Result;
    private String TestResult;
    private String TestTime;
    private String ModuleID;
    private String LineID;
    private String LineType;
    private String rn;

}
