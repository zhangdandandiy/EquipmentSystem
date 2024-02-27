package com.example.pmp.mapper.correct;

import com.example.pmp.pojo.correct.CorrectStatus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/1/5 19:04
 **/
@Mapper
public interface CorrectStatusMapper {

    /**
     * 根据专案查询需要补正站点的列表
     *
     * @return
     */
    public List<CorrectStatus> getCorrectStatusList(@Param("pid") String pid);

    /**
     * 根据站点名更新站点补正状态
     *
     * @param correctStatus
     * @return
     */
    public int updateCorrectStatusByName(CorrectStatus correctStatus);

    /**
     * 更新某个专案所有站点的补正状态
     *
     * @return
     */
    public int updateCorrectStatus(@Param("pid") String pid);

}
