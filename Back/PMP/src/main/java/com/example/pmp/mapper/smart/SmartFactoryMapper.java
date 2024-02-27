package com.example.pmp.mapper.smart;

import com.example.pmp.pojo.smart.*;
import com.example.pmp.pojo.smart.dto.ActivationDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Dandan
 * @date 2023/10/10 13:21
 **/

@Mapper
public interface SmartFactoryMapper {

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
    List<GlueInfo> searchGlueInfoList(@Param("lineId") String lineId);

    /**
     * 根据线体类型和线体编号查询停机信息
     *
     * @param lineId
     * @param lineType
     * @return
     */
    List<DownTime> searchDownTimeList(@Param("lineId") String lineId,
                                      @Param("lineType") String lineType);

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
    InputOutput searchInputOutput(@Param("lineType") String lineType, @Param("lineId") String lineId);

    /**
     * 根据线体类型查询良率信息
     *
     * @param lineType
     * @return
     */
    List<YieldRank> searchYieldRank(@Param("lineType") String lineType);

    /**
     * 根据线体类型和线体编号查询模组良率
     *
     * @param lineType
     * @param lineId
     * @return
     */
    List<MachineYield> searchMachineYield(@Param("lineType") String lineType, @Param("lineId") String lineId);

    /**
     * 获取时间稼动率和性能稼动率
     *
     * @param activation
     * @return
     */
    Activation searchActivation(ActivationDto activation);

}
