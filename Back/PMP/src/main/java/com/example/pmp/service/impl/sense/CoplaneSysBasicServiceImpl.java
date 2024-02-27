package com.example.pmp.service.impl.sense;

import com.example.pmp.mapper.sense.CoplaneSysBasicMapper;
import com.example.pmp.pojo.sense.CoplaneSysBasic;
import com.example.pmp.service.sense.CoplaneSysBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Dandan
 * @date 2023/11/24 15:19
 **/

@Service
public class CoplaneSysBasicServiceImpl implements CoplaneSysBasicService {

    @Autowired
    private CoplaneSysBasicMapper coplaneSysBasicMapper;

    /**
     * 查询共面度检测基础维护数据
     *
     * @param id 共面度检测基础维护数据主键
     * @return 共面度检测基础维护数据
     */
    @Override
    public CoplaneSysBasic selectCoplaneSysBasicById(Long id) {
        return coplaneSysBasicMapper.selectCoplaneSysBasicById(id);
    }

    /**
     * 查询共面度检测基础维护数据列表
     *
     * @param CoplaneSysBasic 共面度检测基础维护数据
     * @return 共面度检测基础维护数据
     */
    @Override
    public List<CoplaneSysBasic> selectCoplaneSysBasicList(CoplaneSysBasic CoplaneSysBasic) {
        return coplaneSysBasicMapper.selectCoplaneSysBasicList(CoplaneSysBasic);
    }

    /**
     * 新增共面度检测基础维护数据
     *
     * @param CoplaneSysBasic 共面度检测基础维护数据
     * @return 结果
     */
    @Override
    public int insertCoplaneSysBasic(CoplaneSysBasic CoplaneSysBasic) {
        return coplaneSysBasicMapper.insertCoplaneSysBasic(CoplaneSysBasic);
    }

    /**
     * 修改共面度检测基础维护数据
     *
     * @param CoplaneSysBasic 共面度检测基础维护数据
     * @return 结果
     */
    @Override
    public int updateCoplaneSysBasic(CoplaneSysBasic CoplaneSysBasic) {
        return coplaneSysBasicMapper.updateCoplaneSysBasic(CoplaneSysBasic);
    }

    /**
     * 批量删除共面度检测基础维护数据
     *
     * @param ids 需要删除的共面度检测基础维护数据主键
     * @return 结果
     */
    @Override
    public int deleteCoplaneSysBasicByIds(Long[] ids) {
        return coplaneSysBasicMapper.deleteCoplaneSysBasicByIds(ids);
    }

    /**
     * 删除共面度检测基础维护数据信息
     *
     * @param id 共面度检测基础维护数据主键
     * @return 结果
     */
    @Override
    public int deleteCoplaneSysBasicById(Long id) {
        return coplaneSysBasicMapper.deleteCoplaneSysBasicById(id);
    }

}
