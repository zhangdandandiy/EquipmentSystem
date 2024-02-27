package com.example.pmp.service.impl.correct;

import com.example.pmp.mapper.correct.CorrectStatusMapper;
import com.example.pmp.pojo.correct.CorrectStatus;
import com.example.pmp.service.correct.CorrectStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/1/8 10:21
 **/

@Service
public class CorrectStatusServiceImpl implements CorrectStatusService {

    @Autowired
    private CorrectStatusMapper correctStatusMapper;

    @Override
    public List<CorrectStatus> getCorrectStatusList() {
        return correctStatusMapper.getCorrectStatusList("D9X");
    }
}
