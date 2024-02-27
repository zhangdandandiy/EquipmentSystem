package com.example.pmp.service.correct;

import com.example.pmp.pojo.correct.CorrectStatus;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/1/5 19:08
 **/
public interface CorrectStatusService {

    /**
     * 查询需要补正站点的列表
     *
     * @return
     */
    public List<CorrectStatus> getCorrectStatusList();

}
