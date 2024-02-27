package com.example.pmp.pojo.smart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dandan
 * @date 2023/10/10 14:33
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Humiture {

    private String DeviceName;
    private String DeviceAddr;
    private String NodeId;
    private String Hum;
    private String Tem;
    private String Lng;
    private String Lat;
    private String IsAlarmData;
    private String Source;
    private String RecordTime;

}
