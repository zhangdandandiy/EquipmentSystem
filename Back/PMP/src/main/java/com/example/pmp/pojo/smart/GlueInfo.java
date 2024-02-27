package com.example.pmp.pojo.smart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dandan
 * @date 2023/10/10 13:49
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GlueInfo {

    private String LineName;
    private String GlueMachineName;
    private String Barcode;
    private String Line_StartHour;
    private String status;
    private String TimeOutWarehouse;
    private String Line_StartTime;

}
