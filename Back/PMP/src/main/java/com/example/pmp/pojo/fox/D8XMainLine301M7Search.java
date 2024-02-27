package com.example.pmp.pojo.fox;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dandan
 * @date 2023/11/1 8:36
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class D8XMainLine301M7Search {

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

    @JsonProperty("AirLeak_Data")
    private String AirLeak_Data;

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

    @JsonProperty("AirLeak_Up")
    private String AirLeak_Up;

    @JsonProperty("AirLeak_Target")
    private String AirLeak_Target;

    @JsonProperty("AirLeak_Down")
    private String AirLeak_Down;

}
