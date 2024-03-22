package com.example.pmp.service.sense;

import com.example.pmp.pojo.sense.SenseDataD4Y;
import com.example.pmp.pojo.sense.SenseDataD8X;
import com.example.pmp.pojo.sense.SenseDataD9X;
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

    public List<SenseDataD8X> searchD8XAvgRealSenseData(SenseDataDto senseDataDto);

    public List<SenseDataD8X> searchX3047AvgRealSenseData(SenseDataDto senseDataDto);

    public List<SenseDataD8X> searchX2757AvgRealSenseData(SenseDataDto senseDataDto);

    public List<SenseDataD9X> searchD9XAvgRealSenseData(SenseDataDto senseDataDto);

    public List<SenseDataD4Y> searchD4YAvgRealSenseData(SenseDataDto senseDataDto);


    public HashMap<String, Set<BigDecimal>> getD8XAllPins(SenseDataDto senseDataDto);

    public HashMap<String, Set<BigDecimal>> getX2757AllPins(SenseDataDto senseDataDto);

    public HashMap<String, Set<BigDecimal>> getX2987AllPins(SenseDataDto senseDataDto);

    public HashMap<String, Set<BigDecimal>> getX3047AllPins(SenseDataDto senseDataDto);

    public HashMap<String, Set<BigDecimal>> getD9XAllPins(SenseDataDto senseDataDto);

    public HashMap<String, Set<BigDecimal>> getD4YAllPins(SenseDataDto senseDataDto);

}
