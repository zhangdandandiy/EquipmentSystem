package com.example.pmp.pojo.sap;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dandan
 * @date 2023/10/27 9:20
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SapLot {

    @JsonProperty("ID")
    private Long ID;

    @JsonProperty("pid")
    private String pid;

    @JsonProperty("LHid")
    private String LHid;

    @JsonProperty("status")
    private String status;

    @JsonProperty("LHcolor")
    private String LHcolor;

    @JsonProperty("LHname")
    private String LHname;

    @JsonProperty("DownMin")
    private String DownMin;

    @JsonProperty("TopMax")
    private String TopMax;

    @JsonProperty("HourLH")
    private String HourLH;

    @JsonProperty("ZSL")
    private String ZSL;

    @JsonProperty("input")
    private String input;

    @JsonProperty("output")
    private String output;

    @JsonProperty("WIP")
    private String WIP;

    @JsonProperty("WIP(Hour)")
    private String WIPH;

}
