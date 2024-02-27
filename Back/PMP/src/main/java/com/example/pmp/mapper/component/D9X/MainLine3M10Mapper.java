package com.example.pmp.mapper.component.D9X;

import com.example.pmp.pojo.component.D9X.MainLine3M10TPX;
import com.example.pmp.pojo.component.D9X.MainLine3M10TPY;
import com.example.pmp.pojo.component.D9X.MainLine3M10TPZ;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/1/16 9:35
 **/

@Mapper
public interface MainLine3M10Mapper {

    /**
     * 根据时间筛选 MainLine3M10TPZ 数据集合
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public List<MainLine3M10TPZ> getMainLine3M10TPZList(@Param("startTime") String startTime, @Param("endTime") String endTime);

    /**
     * 根据时间筛选 MainLine3M10TPX 数据集合
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public List<MainLine3M10TPX> getMainLine3M10TPXList(@Param("startTime") String startTime, @Param("endTime") String endTime);

    /**
     * 根据时间筛选 MainLine3M10TPY 数据集合
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public List<MainLine3M10TPY> getMainLine3M10TPYList(@Param("startTime") String startTime, @Param("endTime") String endTime);

    /**
     * 根据时间筛选 MainLine3M10 BarCode 条码数据集合
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public List<String> getMainLine3M10BarcodeList(@Param("startTime") String startTime, @Param("endTime") String endTime);

}
