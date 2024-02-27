package com.example.pmp.mapper.correct.d4y;

import com.example.pmp.pojo.correct.d4y.Station4D4Y;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/2/3 14:54
 **/

@Mapper
public interface Station4D4YMapper {

    /**
     * 根据开始时间和结束时间筛选需要补正的数据集合
     * 从创建好的视图里捞取数据
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public List<Station4D4Y> getStation4ListByTime(@Param("startTime") String startTime, @Param("endTime") String endTime);

    /**
     * 根据SN查询时间范围内的Station4数据
     * 注意要从补正表里查询数据
     *
     * @param startTime
     * @param endTime
     * @param Barcode
     * @return
     */
    public Station4D4Y getStation4BySN(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("Barcode") String Barcode);

    /**
     * 插入补正后的数据
     *
     * @param Station4
     * @return
     */
    public int insertStation4(Station4D4Y Station4);

    /**
     * 根据开始时间和结束时间筛选范围内第四站所有的条码
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public List<String> getStation4SNList(@Param("startTime") String startTime, @Param("endTime") String endTime);

}
