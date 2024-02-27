package com.example.pmp.service.impl.sense;

import com.example.pmp.mapper.sense.SenseDataMapper;
import com.example.pmp.pojo.sense.SenseDataD8X;
import com.example.pmp.pojo.sense.SenseDataX2757;
import com.example.pmp.pojo.sense.SenseDataX3047;
import com.example.pmp.pojo.sense.dto.SenseDataDto;
import com.example.pmp.service.sense.SenseDataService;
import com.example.pmp.utils.SenseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

/**
 * @author Dandan
 * @date 2023/7/10 13:24
 **/
@Service
public class SenseDataServiceImpl implements SenseDataService {

    @Autowired
    private SenseDataMapper senseDataMapper;

    @Override
    public List<SenseDataD8X> searchD8XAvgRealSenseData(SenseDataDto senseDataDto) {
        return senseDataMapper.searchD8XAvgRealSenseData(senseDataDto);
    }

    @Override
    public List<SenseDataD8X> searchX3047AvgRealSenseData(SenseDataDto senseDataDto) {
        return senseDataMapper.searchX3047AvgRealSenseData(senseDataDto);
    }

    @Override
    public List<SenseDataD8X> searchX2757AvgRealSenseData(SenseDataDto senseDataDto) {
        return senseDataMapper.searchX2757AvgRealSenseData(senseDataDto);
    }

    @Override
    public HashMap<String, Set<BigDecimal>> getD8XAllPins(SenseDataDto senseDataDto) {
        List<SenseDataD8X> senseDataD8XList = senseDataMapper.getD8XAllPins(senseDataDto);
        return SenseUtils.getNeedCorrectMap(senseDataD8XList);
    }

    @Override
    public HashMap<String, Set<BigDecimal>> getX2757AllPins(SenseDataDto senseDataDto) {
        List<SenseDataX2757> senseDataX2757List = senseDataMapper.getX2757AllPins(senseDataDto);
        HashMap<String, Set<BigDecimal>> map = SenseUtils.getNeedCorrectMap(senseDataX2757List);
        return SenseUtils.addPrefixToKeys(map);
    }

    @Override
    public HashMap<String, Set<BigDecimal>> getX2987AllPins(SenseDataDto senseDataDto) {
        HashMap<String, Set<BigDecimal>> distinctData = new HashMap<>();
        distinctData.put("pin", SenseUtils.convertToBigDecimalSet(senseDataMapper.getX2987AllPins(senseDataDto)));
        return distinctData;
    }

    @Override
    public HashMap<String, Set<BigDecimal>> getX3047AllPins(SenseDataDto senseDataDto) {
        List<SenseDataX3047> senseDataX3047List = senseDataMapper.getX3047AllPins(senseDataDto);
        HashMap<String, Set<BigDecimal>> map = SenseUtils.getNeedCorrectMap(senseDataX3047List);
        return SenseUtils.changeKeys(map);
    }

}

