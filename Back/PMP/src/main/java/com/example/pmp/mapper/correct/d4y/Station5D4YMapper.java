package com.example.pmp.mapper.correct.d4y;

import com.example.pmp.pojo.correct.d4y.Station5D4Y;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/2/3 14:54
 **/
@Mapper
public interface Station5D4YMapper {

    /**
     * 根据开始时间和结束时间筛选需要补正的数据集合
     * 从创建好的视图里捞取数据
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public List<Station5D4Y> getStation5ListByTime(@Param("startTime") String startTime, @Param("endTime") String endTime);

    /**
     * 插入补正后的数据
     *
     * @param station5
     * @return
     */
    public int insertStation5(Station5D4Y station5);

    /**
     * 根据开始时间和结束时间筛选范围内第五站所有的条码
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public List<String> getStation5SNList(@Param("startTime") String startTime, @Param("endTime") String endTime);

}
