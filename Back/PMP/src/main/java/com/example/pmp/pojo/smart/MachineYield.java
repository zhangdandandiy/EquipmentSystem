package com.example.pmp.pojo.smart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dandan
 * @date 2023/10/10 15:18
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MachineYield {

    private String lineType;
    private String lineId;
    private String machineId;
    private String WIP;
    private String NG_Rate;
    private String Yield;
    private String planYield;
    private String machine_Name;

}
