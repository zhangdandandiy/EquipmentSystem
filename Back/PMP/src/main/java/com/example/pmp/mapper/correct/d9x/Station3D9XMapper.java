package com.example.pmp.mapper.correct.d9x;

import com.example.pmp.pojo.correct.d9x.Station3D9X;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/1/18 14:29
 **/
@Mapper
public interface Station3D9XMapper {

    /**
     * 根据开始时间和结束时间筛选需要补正的数据集合
     * 从创建好的视图里捞取数据
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public List<Station3D9X> getStation3ListByTime(@Param("startTime") String startTime, @Param("endTime") String endTime);

    /**
     * 根据SN查询时间范围内的Station3数据
     * 注意要从补正表里查询数据
     *
     * @param startTime
     * @param endTime
     * @param Barcode
     * @return
     */
    public Station3D9X getStation3BySN(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("Barcode") String Barcode);

    /**
     * 批量插入补正后的数据
     *
     * @param station3List
     * @return
     */
    public int batchInsertStation3(List<Station3D9X> station3List);

    /**
     * 插入补正后的数据
     *
     * @param station3
     * @return
     */
    public int insertStation3(Station3D9X station3);

    /**
     * 根据开始时间和结束时间筛选范围内第三站所有的条码
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public List<String> getStation3SNList(@Param("startTime") String startTime, @Param("endTime") String endTime);

}
