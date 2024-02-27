package com.example.pmp.mapper.sense;

import com.example.pmp.pojo.sense.SenseDataD8X;
import com.example.pmp.pojo.sense.SenseDataX2757;
import com.example.pmp.pojo.sense.SenseDataX3047;
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

    List<SenseDataD8X> searchD8XAvgRealSenseData(@Param("senseDataDto") SenseDataDto senseDataDto);

    List<SenseDataD8X> searchX3047AvgRealSenseData(@Param("senseDataDto") SenseDataDto senseDataDto);

    List<SenseDataD8X> searchX2757AvgRealSenseData(@Param("senseDataDto") SenseDataDto senseDataDto);

    List<SenseDataD8X> getD8XAllPins(@Param("senseDataDto") SenseDataDto senseDataDto);

    List<SenseDataX2757> getX2757AllPins(@Param("senseDataDto") SenseDataDto senseDataDto);

    List<String> getX2987AllPins(@Param("senseDataDto") SenseDataDto senseDataDto);

    List<SenseDataX3047> getX3047AllPins(@Param("senseDataDto") SenseDataDto senseDataDto);

}
