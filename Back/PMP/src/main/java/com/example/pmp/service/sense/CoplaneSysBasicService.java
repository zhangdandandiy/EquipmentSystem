package com.example.pmp.service.sense;

import com.example.pmp.pojo.sense.CoplaneSysBasic;

import java.util.List;

/**
 * @author Dandan
 * @date 2023/11/24 15:18
 **/
public interface CoplaneSysBasicService {

    /**
     * 查询共面度检测基础维护数据
     *
     * @param id 共面度检测基础维护数据主键
     * @return 共面度检测基础维护数据
     */
    public CoplaneSysBasic selectCoplaneSysBasicById(Long id);

    /**
     * 查询共面度检测基础维护数据列表
     *
     * @param CoplaneSysBasic 共面度检测基础维护数据
     * @return 共面度检测基础维护数据集合
     */
    public List<CoplaneSysBasic> selectCoplaneSysBasicList(CoplaneSysBasic CoplaneSysBasic);

    /**
     * 新增共面度检测基础维护数据
     *
     * @param CoplaneSysBasic 共面度检测基础维护数据
     * @return 结果
     */
    public int insertCoplaneSysBasic(CoplaneSysBasic CoplaneSysBasic);

    /**
     * 修改共面度检测基础维护数据
     *
     * @param CoplaneSysBasic 共面度检测基础维护数据
     * @return 结果
     */
    public int updateCoplaneSysBasic(CoplaneSysBasic CoplaneSysBasic);

    /**
     * 批量删除共面度检测基础维护数据
     *
     * @param ids 需要删除的共面度检测基础维护数据主键集合
     * @return 结果
     */
    public int deleteCoplaneSysBasicByIds(Long[] ids);

    /**
     * 删除共面度检测基础维护数据信息
     *
     * @param id 共面度检测基础维护数据主键
     * @return 结果
     */
    public int deleteCoplaneSysBasicById(Long id);

}
