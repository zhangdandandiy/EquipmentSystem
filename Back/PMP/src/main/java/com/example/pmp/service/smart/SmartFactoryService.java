package com.example.pmp.service.smart;

import com.example.pmp.pojo.smart.*;
import com.example.pmp.pojo.smart.dto.ActivationDto;

import java.util.List;

/**
 * @author Dandan
 * @date 2023/10/10 13:27
 **/
public interface SmartFactoryService {

    /**
     * 根据线体类型和线体编号查询裁切刀信息列表
     *
     * @param lifeControl
     * @return
     */
    List<LifeControl> searchLifeControlList(LifeControl lifeControl);

    /**
     * 根据线体编号查询胶水信息
     *
     * @param lineId
     * @return
     */
    List<GlueInfo> searchGlueInfoList(String lineId);

    /**
     * 根据线体类型和线体编号查询停机信息
     *
     * @param lineId
     * @param lineType
     * @return
     */
    List<DownTime> searchDownTimeList(String lineId, String lineType);

    /**
     * 查询温湿度信息
     *
     * @return
     */
    Humiture searchHumiture();

    /**
     * 根据线体类型和线体编号查询投入产出信息
     *
     * @param lineType
     * @param lineId
     * @return
     */
    InputOutput searchInputOutput(String lineType, String lineId);

    /**
     * 根据线体类型查询良率信息
     *
     * @param lineType
     * @return
     */
    List<YieldRank> searchYieldRank(String lineType);

    /**
     * 根据线体类型和线体编号查询模组良率
     *
     * @param lineType
     * @param lineId
     * @return
     */
    List<MachineYield> searchMachineYield(String lineType, String lineId);

    /**
     * 获取时间稼动率和性能稼动率
     *
     * @param activation
     * @return
     */
    Activation searchActivation(ActivationDto activation);

}
