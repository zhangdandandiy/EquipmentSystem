package com.example.pmp.pojo.smart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dandan
 * @date 2023/10/10 14:57
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputOutput {

    private String lineType;
    private String lineId;
    private String machineId;
    private String WIP;
    private String Input;
    private String planInput;
    private String Output;
    private String planOutput;
    private String theoryRestTime;
    private String planProdctionTime;
    private String Yield;
    private String planYield;
    private String Efficiency;
    private String planEfficiency;
    private String OEE;
    private String planOEE;

}
