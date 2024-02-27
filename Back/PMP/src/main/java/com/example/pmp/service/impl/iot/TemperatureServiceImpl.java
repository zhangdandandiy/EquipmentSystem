package com.example.pmp.service.impl.iot;

import com.example.pmp.mapper.iot.TemperatureMapper;
import com.example.pmp.pojo.iot.temperature;
import com.example.pmp.service.iot.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Dandan
 * @date 2023/8/24 19:21
 **/
@Service
public class TemperatureServiceImpl implements TemperatureService {

    @Autowired
    private TemperatureMapper temperatureMapper;

    @Override
    public List<temperature> selectAllTemperature() {
        return temperatureMapper.selectAllTemperature();
    }
}
