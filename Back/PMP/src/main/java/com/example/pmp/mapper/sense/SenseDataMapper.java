package com.example.pmp.mapper.sense;

import com.example.pmp.pojo.sense.*;
import com.example.pmp.pojo.sense.dto.SenseDataDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Dandan
 * @date 2023/7/3 8:22
 **/
@Mapper
@Repository
public interface SenseDataMapper {

    public List<SenseDataD8X> searchD8XAvgRealSenseData(@Param("senseDataDto") SenseDataDto senseDataDto);

    public List<SenseDataD8X> searchX3047AvgRealSenseData(@Param("senseDataDto") SenseDataDto senseDataDto);

    public List<SenseDataD8X> searchX2757AvgRealSenseData(@Param("senseDataDto") SenseDataDto senseDataDto);

    public List<SenseDataD9X> searchD9XAvgRealSenseData(@Param("senseDataDto") SenseDataDto senseDataDto);

    public List<SenseDataD4Y> searchD4YAvgRealSenseData(@Param("senseDataDto") SenseDataDto senseDataDto);


    public List<SenseDataD8X> getD8XAllPins(@Param("senseDataDto") SenseDataDto senseDataDto);

    public List<SenseDataX2757> getX2757AllPins(@Param("senseDataDto") SenseDataDto senseDataDto);

    public List<String> getX2987AllPins(@Param("senseDataDto") SenseDataDto senseDataDto);

    public List<SenseDataX3047> getX3047AllPins(@Param("senseDataDto") SenseDataDto senseDataDto);

    public List<SenseDataD9X> getSenseDataD9XPins(@Param("senseDataDto") SenseDataDto senseDataDto);

    public List<SenseDataD4Y> getSenseDataD4YPins(@Param("senseDataDto") SenseDataDto senseDataDto);

}
