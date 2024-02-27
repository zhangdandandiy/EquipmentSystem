package com.example.pmp.service.hot;

import com.example.pmp.pojo.hot.HotCode;
import com.example.pmp.pojo.hot.HotCodeKid;
import com.example.pmp.pojo.hot.dto.HotCodeParamDto;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/1/6 9:04
 **/
public interface HotCodeService {

    /**
     * 根据参数查询所有不良信息
     *
     * @param hotCode
     * @return
     */
    public List<HotCode> getHotCodeList(HotCode hotCode);

    /**
     * 根据参数查询所有不良信息(新)
     *
     * @param hotCodeParamDto
     * @return
     */
    public List<HotCode> getHotCodeListNew(HotCodeParamDto hotCodeParamDto);

    /**
     * 查询所有不良名称 & 对应编号
     *
     * @return
     */
    public List<HotCodeKid> getHotCodeKidList();

}
