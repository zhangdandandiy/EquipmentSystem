package com.example.pmp.pojo.sense;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dandan
 * @date 2023/10/17 15:27
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SenseDataX3047 {

    @JsonProperty("FAI9-1")
    private String FAI9_1;

    @JsonProperty("FAI9-2")
    private String FAI9_2;

    @JsonProperty("FAI9-3")
    private String FAI9_3;

    @JsonProperty("FAI9-4")
    private String FAI9_4;

    @JsonProperty("FAI9-5")
    private String FAI9_5;

    @JsonProperty("FAI9-6")
    private String FAI9_6;

    @JsonProperty("FAI9-7")
    private String FAI9_7;

    @JsonProperty("FAI9-8")
    private String FAI9_8;

    @JsonProperty("FAI12")
    private String FAI12;

}
