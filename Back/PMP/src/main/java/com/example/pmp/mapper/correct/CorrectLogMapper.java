package com.example.pmp.mapper.correct;

import com.example.pmp.pojo.correct.CorrectLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/1/9 18:16
 **/
@Mapper
public interface CorrectLogMapper {

    /**
     * 新增补正日志记录
     *
     * @param correctLog 补正日志记录
     * @return 结果
     */
    public int insertCorrectLog(CorrectLog correctLog);

    /**
     * 查询补正日志记录
     *
     * @param Id 补正日志记录主键
     * @return 补正日志记录
     */
    public CorrectLog selectCorrectLogById(Long Id);

    /**
     * 查询补正日志记录列表
     *
     * @param correctLog 补正日志记录
     * @return 补正日志记录集合
     */
    public List<CorrectLog> selectCorrectLogList(CorrectLog correctLog);

    /**
     * 根据开始时间和结束时间查询补正日志集合
     *
     * @param StartTime
     * @param EndTime
     * @return
     */
    public List<CorrectLog> selectCorrectLogListByTime(@Param("Project") String Project, @Param("StartTime") String StartTime, @Param("EndTime") String EndTime);

}
