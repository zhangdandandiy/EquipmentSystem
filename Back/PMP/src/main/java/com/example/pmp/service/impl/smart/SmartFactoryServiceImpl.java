package com.example.pmp.service.impl.smart;

import com.example.pmp.mapper.smart.SmartFactoryMapper;
import com.example.pmp.pojo.smart.*;
import com.example.pmp.pojo.smart.dto.ActivationDto;
import com.example.pmp.service.smart.SmartFactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Dandan
 * @date 2023/10/10 13:27
 **/

@Service
public class SmartFactoryServiceImpl implements SmartFactoryService {

    @Autowired
    private SmartFactoryMapper smartFactoryMapper;

    @Override
    public List<LifeControl> searchLifeControlList(LifeControl lifeControl) {
        return smartFactoryMapper.searchLifeControlList(lifeControl);
    }

    @Override
    public List<GlueInfo> searchGlueInfoList(String lineId) {
        return smartFactoryMapper.searchGlueInfoList(lineId);
    }

    @Override
    public List<DownTime> searchDownTimeList(String lineId, String lineType) {
        return smartFactoryMapper.searchDownTimeList(lineId, lineType);
    }

    @Override
    public Humiture searchHumiture() {
        return smartFactoryMapper.searchHumiture();
    }

    @Override
    public InputOutput searchInputOutput(String lineType, String lineId) {
        return smartFactoryMapper.searchInputOutput(lineType, lineId);
    }

    @Override
    public List<YieldRank> searchYieldRank(String lineType) {
        return smartFactoryMapper.searchYieldRank(lineType);
    }

    @Override
    public List<MachineYield> searchMachineYield(String lineType, String lineId) {
        return smartFactoryMapper.searchMachineYield(lineType, lineId);
    }

    @Override
    public Activation searchActivation(ActivationDto activation) {
        return smartFactoryMapper.searchActivation(activation);
    }
}
