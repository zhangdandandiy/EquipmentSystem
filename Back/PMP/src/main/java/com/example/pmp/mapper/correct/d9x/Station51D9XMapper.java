package com.example.pmp.mapper.correct.d9x;

import com.example.pmp.pojo.correct.d9x.Station51D9X;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/1/19 8:55
 **/
@Mapper
public interface Station51D9XMapper {

    /**
     * 根据开始时间和结束时间筛选需要补正的数据集合
     * 从创建好的视图里捞取数据
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public List<Station51D9X> getStation51ListByTime(@Param("startTime") String startTime, @Param("endTime") String endTime);

    /**
     * 根据SN查询时间范围内的Station51数据
     * 注意要从补正表里查询数据
     *
     * @param startTime
     * @param endTime
     * @param Barcode
     * @return
     */
    public Station51D9X getStation51BySN(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("Barcode") String Barcode);

    /**
     * 插入补正后的数据
     *
     * @param station51
     * @return
     */
    public int insertStation51(Station51D9X station51);

    /**
     * 根据开始时间和结束时间筛选范围内第五站所有的条码
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public List<String> getStation51SNList(@Param("startTime") String startTime, @Param("endTime") String endTime);

    /**
     * 更新补正后的数据 ，主要更新 3DSCAN_FAI2 字段
     *
     * @param station51
     * @return
     */
    public int updateStation51(Station51D9X station51);

}
