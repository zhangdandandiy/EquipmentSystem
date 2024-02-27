package com.example.pmp.pojo.fox;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dandan
 * @date 2023/11/1 8:27
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class D8XMainLine301M5Search {

    @JsonProperty("items")
    private String items;

    @JsonProperty("Testpcid")
    private String Testpcid;

    @JsonProperty("Collecttime")
    private String Collecttime;

    @JsonProperty("FileName")
    private String FileName;

    @JsonProperty("Barcode")
    private String Barcode;

    @JsonProperty("Barcode_Level")
    private String Barcode_Level;

    @JsonProperty("Barcode_Result")
    private String Barcode_Result;

    @JsonProperty("TestResult")
    private String TestResult;

    @JsonProperty("TestTime")
    private String TestTime;

    @JsonProperty("ModuleID")
    private String ModuleID;

    @JsonProperty("LineID")
    private String LineID;

    @JsonProperty("LineType")
    private String LineType;

    @JsonProperty("ProjectID")
    private String ProjectID;

}
