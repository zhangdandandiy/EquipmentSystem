package com.example.pmp.mapper.correct.d4y;

import com.example.pmp.pojo.correct.d4y.Station1D4Y;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/2/3 14:53
 **/

@Mapper
public interface Station1D4YMapper {

    /**
     * 根据开始时间和结束时间筛选需要补正的数据集合
     * 从创建好的视图里捞取数据
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public List<Station1D4Y> getStation1ListByTime(@Param("startTime") String startTime, @Param("endTime") String endTime);

    /**
     * 根据SN查询时间范围内的Station1数据
     * 注意要从补正表里查询数据
     *
     * @param startTime
     * @param endTime
     * @param Barcode
     * @return
     */
    public Station1D4Y getStation1BySN(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("Barcode") String Barcode);

    /**
     * 插入补正后的数据
     *
     * @param station1
     * @return
     */
    public int insertStation1(Station1D4Y station1);

    /**
     * 根据开始时间和结束时间筛选范围内第一站所有的条码
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public List<String> getStation1SNList(@Param("startTime") String startTime, @Param("endTime") String endTime);

}
