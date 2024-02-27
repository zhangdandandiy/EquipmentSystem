package com.example.pmp.service.impl.correct;

import com.example.pmp.mapper.correct.CorrectPersonMapper;
import com.example.pmp.service.correct.CorrectPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/1/20 10:28
 **/

@Service
public class CorrectPersonServiceImpl implements CorrectPersonService {

    @Autowired
    private CorrectPersonMapper correctPersonMapper;

    /**
     * 根据专案名称查询专案相关负责人
     *
     * @param project
     * @return
     */
    @Override
    public List<String> selectCorrectPersonListByProject(String project) {
        return correctPersonMapper.selectCorrectPersonListByProject(project);
    }

}
