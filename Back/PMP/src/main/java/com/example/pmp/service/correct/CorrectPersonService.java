package com.example.pmp.service.correct;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/1/20 10:24
 **/
public interface CorrectPersonService {

    /**
     * 根据专案名称查询专案相关负责人
     *
     * @param project
     * @return
     */
    public List<String> selectCorrectPersonListByProject(String project);

}
