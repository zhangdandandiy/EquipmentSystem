package com.example.pmp.pojo.fox;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dandan
 * @date 2023/11/1 8:32
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class D8XMainLine301M6Search {

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

    @JsonProperty("Open_Result")
    private String Open_Result;

    @JsonProperty("Short_Result")
    private String Short_Result;

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
