package com.example.pmp.service.correct;

import com.example.pmp.pojo.correct.CorrectLog;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/1/20 10:23
 **/
public interface CorrectLogService {

    /**
     * 根据专案名称查询专案相关负责人
     *
     * @param project
     * @return
     */
    public List<CorrectLog> selectCorrectLogListByTime(String project, String startTime, String endTime,String CreateTime);

}
