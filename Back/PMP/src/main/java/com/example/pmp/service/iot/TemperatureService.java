package com.example.pmp.service.iot;

import com.example.pmp.pojo.iot.temperature;

import java.util.List;

/**
 * @author Dandan
 * @date 2023/8/24 19:20
 **/
public interface TemperatureService {

    List<temperature> selectAllTemperature();

}
