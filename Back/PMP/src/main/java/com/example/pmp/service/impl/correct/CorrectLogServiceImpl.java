package com.example.pmp.service.impl.correct;

import com.example.pmp.mapper.correct.CorrectLogMapper;
import com.example.pmp.pojo.correct.CorrectLog;
import com.example.pmp.service.correct.CorrectLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/1/20 10:25
 **/

@Service
public class CorrectLogServiceImpl implements CorrectLogService {

    @Autowired
    private CorrectLogMapper correctLogMapper;

    /**
     * 根据时间和专案获取补正日志集合
     *
     * @param project
     * @param startTime
     * @param endTime
     * @return
     */
    @Override
    public List<CorrectLog> selectCorrectLogListByTime(String project, String startTime, String endTime) {
        return correctLogMapper.selectCorrectLogListByTime(project, startTime, endTime);
    }

}
