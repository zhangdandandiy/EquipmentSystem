package com.example.pmp.mapper.correct;

import com.example.pmp.pojo.correct.CorrectPerson;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/1/20 8:50
 **/

@Mapper
public interface CorrectPersonMapper {

    /**
     * 查询补正专案负责人
     *
     * @param id 补正专案负责人，用于发企业微信通知主键
     * @return 补正专案负责人，用于发企业微信通知
     */
    public CorrectPerson selectCorrectPersonById(Long id);

    /**
     * 查询补正专案负责人
     *
     * @param correctPerson 补正专案负责人，用于发企业微信通知
     * @return 补正专案负责人，用于发企业微信通知集合
     */
    public List<CorrectPerson> selectCorrectPersonList(CorrectPerson correctPerson);

    /**
     * 根据专案名称查询专案相关负责人
     *
     * @param project
     * @return
     */
    public List<String> selectCorrectPersonListByProject(@Param("project") String project);

}
