package com.example.pmp.mapper.correct.d9x;

import com.example.pmp.pojo.correct.d9x.Station41D9X;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/1/18 19:15
 **/
@Mapper
public interface Station41D9XMapper {

    /**
     * 根据开始时间和结束时间筛选需要补正的数据集合
     * 从创建好的视图里捞取数据
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public List<Station41D9X> getStation41ListByTime(@Param("startTime") String startTime, @Param("endTime") String endTime);

    /**
     * 根据SN查询时间范围内的Station41数据
     * 注意要从补正表里查询数据
     *
     * @param startTime
     * @param endTime
     * @param Barcode
     * @return
     */
    public Station41D9X getStation41BySN(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("Barcode") String Barcode);

    /**
     * 批量插入补正后的数据
     *
     * @param station41List
     * @return
     */
    public int batchInsertStation41(List<Station41D9X> station41List);

    /**
     * 插入补正后的数据
     *
     * @param station41
     * @return
     */
    public int insertStation41(Station41D9X station41);

    /**
     * 根据开始时间和结束时间筛选范围内第四站所有的条码
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public List<String> getStation41SNList(@Param("startTime") String startTime, @Param("endTime") String endTime);

}
