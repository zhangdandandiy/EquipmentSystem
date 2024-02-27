package com.example.pmp.service.sense;

import com.example.pmp.pojo.sense.SenseDataD8X;
import com.example.pmp.pojo.sense.dto.SenseDataDto;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @author Dandan
 * @date 2023/7/10 13:21
 **/
public interface SenseDataService {

    List<SenseDataD8X> searchD8XAvgRealSenseData(SenseDataDto senseDataDto);

    List<SenseDataD8X> searchX3047AvgRealSenseData(SenseDataDto senseDataDto);

    List<SenseDataD8X> searchX2757AvgRealSenseData(SenseDataDto senseDataDto);

    HashMap<String, Set<BigDecimal>> getD8XAllPins(SenseDataDto senseDataDto);

    HashMap<String, Set<BigDecimal>> getX2757AllPins(SenseDataDto senseDataDto);

    HashMap<String, Set<BigDecimal>> getX2987AllPins(SenseDataDto senseDataDto);

    HashMap<String, Set<BigDecimal>> getX3047AllPins(SenseDataDto senseDataDto);

}
