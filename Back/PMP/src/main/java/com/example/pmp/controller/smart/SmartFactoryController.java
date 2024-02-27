package com.example.pmp.controller.smart;

import com.example.pmp.pojo.smart.*;
import com.example.pmp.pojo.smart.dto.ActivationDto;
import com.example.pmp.service.smart.SmartFactoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Dandan
 * @date 2023/10/10 13:29
 **/

@RestController
@RequestMapping("/lifeControl")
@Api(tags = "智能工厂信息化大屏相关接口")
public class SmartFactoryController {

    @Autowired
    private SmartFactoryService smartFactoryService;

    @ApiOperation("获取裁切刀信息列表")
    @PostMapping("/lifeList")
    public List<LifeControl> searchLifeControlList(@RequestBody LifeControl lifeControl) {
        return smartFactoryService.searchLifeControlList(lifeControl);
    }

    @ApiOperation("获取胶水信息列表")
    @GetMapping("/glueList")
    public List<GlueInfo> searchGlueInfoList(String lineId) {
        return smartFactoryService.searchGlueInfoList(lineId);
    }

    @ApiOperation("获取停机信息列表")
    @GetMapping("/downTimeList")
    public List<DownTime> searchDownTimeList(String lineId, String lineType) {
        return smartFactoryService.searchDownTimeList(lineId, lineType);
    }

    @ApiOperation("获取温湿度信息")
    @GetMapping("/humiture")
    public Humiture searchHumiture() {
        return smartFactoryService.searchHumiture();
    }

    @ApiOperation("获取投入产出信息")
    @GetMapping("/inputOutput")
    public InputOutput searchInputOutput(String lineType, String lineId) {
        return smartFactoryService.searchInputOutput(lineType, lineId);
    }

    @ApiOperation("获取良率信息列表")
    @GetMapping("/yieldRankList")
    public List<YieldRank> searchYieldRank(String lineType) {
        return smartFactoryService.searchYieldRank(lineType);
    }

    @ApiOperation("获取各机台良率列表")
    @GetMapping("/machineYieldList")
    public List<MachineYield> searchMachineYield(String lineType, String lineId) {
        return smartFactoryService.searchMachineYield(lineType, lineId);
    }

    @ApiOperation("获取时间稼动率和性能稼动率")
    @PostMapping("/activation")
    public Activation searchActivation(@RequestBody ActivationDto activation) {
        return smartFactoryService.searchActivation(activation);
    }

}
