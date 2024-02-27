package com.example.pmp.pojo.sense;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dandan
 * @date 2023/10/19 15:24
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SenseDataX2757 {

    @JsonProperty("FAI9_1")
    private String FAI9_1;

    @JsonProperty("FAI9_2")
    private String FAI9_2;

    @JsonProperty("FAI9_3")
    private String FAI9_3;

    @JsonProperty("FAI9_4")
    private String FAI9_4;

    @JsonProperty("FAI9_5")
    private String FAI9_5;

    @JsonProperty("FAI9_6")
    private String FAI9_6;

    @JsonProperty("FAI9_7")
    private String FAI9_7;

    @JsonProperty("FAI9_8")
    private String FAI9_8;

    @JsonProperty("FAI12")
    private String FAI12;

}
