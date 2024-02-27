package com.example.pmp.mapper.component.D4Y;

import com.example.pmp.pojo.component.D4Y.D4YMainLine3M10TPX;
import com.example.pmp.pojo.component.D4Y.D4YMainLine3M10TPY;
import com.example.pmp.pojo.component.D4Y.D4YMainLine3M10TPZ;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/2/22 10:33
 **/

@Mapper
public interface D4YMainLine3M10Mapper {

    /**
     * 根据时间筛选 D4YMainLine3M10TPZ 数据列表
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public List<D4YMainLine3M10TPZ> getD4YMainLine3M10TPZList(@Param("startTime") String startTime, @Param("endTime") String endTime);

    /**
     * 根据时间筛选 D4YMainLine3M10TPX FAI 数据集合
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public List<D4YMainLine3M10TPX> getD4YMainLine3M10TPXList(@Param("startTime") String startTime, @Param("endTime") String endTime);

    /**
     * 根据时间筛选 D4YMainLine3M10TPY FAI 数据集合
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public List<D4YMainLine3M10TPY> getD4YMainLine3M10TPYList(@Param("startTime") String startTime, @Param("endTime") String endTime);

    /**
     * 根据时间筛选 D4YMainLine3M10 条码数据集合
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public List<String> getD4YMainLine3M10BarcodeList(@Param("startTime") String startTime, @Param("endTime") String endTime);

}
