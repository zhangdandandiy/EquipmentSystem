package com.example.pmp.pojo.fox;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Dandan
 * @date 2023/10/14 9:59
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class D8XMainLine301M6 {

    private Long items;

    private String Testpcid;

    private Date Collecttime;

    private String FileName;

    private String Barcode;

    private String Open_Result;

    private String Short_Result;

    private String TestResult;

    private Date TestTime;

    private String ModuleID;

    private String LineID;

    private String LineType;

    private String ProjectID;

}
