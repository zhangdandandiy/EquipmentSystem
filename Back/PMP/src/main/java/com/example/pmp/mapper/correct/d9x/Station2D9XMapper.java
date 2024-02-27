package com.example.pmp.mapper.correct.d9x;

import com.example.pmp.pojo.correct.d9x.Station2D9X;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/1/18 13:37
 **/

@Mapper
public interface Station2D9XMapper {

    /**
     * 根据开始时间和结束时间筛选需要补正的数据集合
     * 从创建好的视图里捞取数据
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public List<Station2D9X> getStation2ListByTime(@Param("startTime") String startTime, @Param("endTime") String endTime);

    /**
     * 根据SN查询时间范围内的Station2数据
     * 注意要从补正表里查询数据
     *
     * @param startTime
     * @param endTime
     * @param Barcode
     * @return
     */
    public Station2D9X getStation2BySN(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("Barcode") String Barcode);

    /**
     * 批量插入补正后的数据
     *
     * @param station2List
     * @return
     */
    public int batchInsertStation2(List<Station2D9X> station2List);

    /**
     * 插入补正后的数据
     *
     * @param station2
     * @return
     */
    public int insertStation2(Station2D9X station2);

    /**
     * 根据开始时间和结束时间筛选范围内第二站所有的条码
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public List<String> getStation2SNList(@Param("startTime") String startTime, @Param("endTime") String endTime);

}
