package com.example.pmp.mapper.correct;

import com.example.pmp.pojo.correct.CorrectTime;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Dandan
 * @date 2024/3/8 8:45
 **/

@Mapper
public interface CorrectTimeMapper {

    /**
     * 根据专案获取补正开始时间及结束时间
     *
     * @param Product
     * @return
     */
    public CorrectTime getCorrectTimeByProduct(@Param("Product") String Product);

    /**
     * 根据专案更新补正开始时间和结束时间
     *
     * @param correctTime
     * @return
     */
    public int updateCorrectTime(CorrectTime correctTime);

}
