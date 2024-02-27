package com.example.pmp.pojo.iot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dandan
 * @date 2023/8/24 19:16
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class temperature {
    private String autoId;
    private String EquipmentName;
    private String Temperature;
    private String Humidity;
    private String Time;
}
