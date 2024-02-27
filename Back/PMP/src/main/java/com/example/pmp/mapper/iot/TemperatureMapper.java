package com.example.pmp.mapper.iot;

import com.example.pmp.pojo.iot.temperature;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Dandan
 * @date 2023/8/24 19:18
 **/
@Mapper
public interface TemperatureMapper {

    List<temperature> selectAllTemperature();

}
