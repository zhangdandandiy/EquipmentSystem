package com.example.pmp.mapper.correct.d9x;

import com.example.pmp.pojo.correct.d9x.Station52D9X;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/1/19 13:31
 **/
@Mapper
public interface Station52D9XMapper {

    /**
     * 根据开始时间和结束时间筛选需要补正的数据集合
     * 从创建好的视图里捞取数据
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public List<Station52D9X> getStation52ListByTime(@Param("startTime") String startTime, @Param("endTime") String endTime);

    /**
     * 根据SN查询时间范围内的Station52数据
     * 注意要从补正表里查询数据
     *
     * @param startTime
     * @param endTime
     * @param Barcode
     * @return
     */
    public Station52D9X getStation52BySN(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("Barcode") String Barcode);

    /**
     * 插入补正后的数据
     *
     * @param station52
     * @return
     */
    public int insertStation52(Station52D9X station52);

    /**
     * 根据开始时间和结束时间筛选范围内第五站所有的条码
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public List<String> getStation52SNList(@Param("startTime") String startTime, @Param("endTime") String endTime);

}
