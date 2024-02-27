package com.example.pmp.mapper.correct.d9x;

import com.example.pmp.pojo.correct.d9x.Station42D9X;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/1/19 8:14
 **/

@Mapper
public interface Station42D9XMapper {

    /**
     * 根据开始时间和结束时间筛选需要补正的数据集合
     * 从创建好的视图里捞取数据
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public List<Station42D9X> getStation42ListByTime(@Param("startTime") String startTime, @Param("endTime") String endTime);

    /**
     * 根据SN查询时间范围内的Station42数据
     * 注意要从补正表里查询数据
     *
     * @param startTime
     * @param endTime
     * @param Barcode
     * @return
     */
    public Station42D9X getStation42BySN(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("Barcode") String Barcode);

    /**
     * 批量插入补正后的数据
     *
     * @param station42List
     * @return
     */
    public int batchInsertStation42(List<Station42D9X> station42List);

    /**
     * 插入补正后的数据
     *
     * @param station42
     * @return
     */
    public int insertStation42(Station42D9X station42);

    /**
     * 根据开始时间和结束时间筛选范围内第四站所有的条码
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public List<String> getStation42SNList(@Param("startTime") String startTime, @Param("endTime") String endTime);

}
