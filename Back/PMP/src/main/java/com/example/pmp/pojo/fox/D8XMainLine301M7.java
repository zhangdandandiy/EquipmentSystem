package com.example.pmp.pojo.fox;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Dandan
 * @date 2023/10/14 10:01
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class D8XMainLine301M7 {

    private Long items;

    private String Testpcid;

    private Date Collecttime;

    private String FileName;

    private String Barcode;

    private String AirLeak_Data;

    private String TestResult;

    private Date TestTime;

    private String ModuleID;

    private String LineID;

    private String LineType;

    private String ProjectID;

    private String AirLeak_Up;

    private String AirLeak_Target;

    private String AirLeak_Down;

}
