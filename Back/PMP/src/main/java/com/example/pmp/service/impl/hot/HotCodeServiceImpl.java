package com.example.pmp.service.impl.hot;

import com.example.pmp.mapper.hot.HotCodeMapper;
import com.example.pmp.pojo.hot.HotCode;
import com.example.pmp.pojo.hot.HotCodeKid;
import com.example.pmp.pojo.hot.dto.HotCodeParamDto;
import com.example.pmp.service.hot.HotCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/1/6 9:04
 **/
@Service
public class HotCodeServiceImpl implements HotCodeService {

    @Autowired
    private HotCodeMapper hotCodeMapper;

    /**
     * 根据参数查询所有不良信息
     *
     * @param hotCode
     * @return
     */
    @Override
    public List<HotCode> getHotCodeList(HotCode hotCode) {
        return hotCodeMapper.getHotCodeList(hotCode);
    }

    /**
     * 根据参数查询所有不良信息(新)
     *
     * @param hotCodeParamDto
     * @return
     */
    @Override
    public List<HotCode> getHotCodeListNew(HotCodeParamDto hotCodeParamDto){
        return hotCodeMapper.getHotCodeListNew(hotCodeParamDto);
    }

    /**
     * 查询所有不良名称&对应编号
     *
     * @return
     */
    @Override
    public List<HotCodeKid> getHotCodeKidList() {
        return hotCodeMapper.getHotCodeKidList();
    }

}
