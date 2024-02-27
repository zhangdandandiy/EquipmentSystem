package com.example.pmp.mapper.hot;

import com.example.pmp.pojo.hot.HotType;
import com.example.pmp.pojo.hot.dto.HotTypeParamDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/1/6 9:22
 **/
@Mapper
public interface HotTypeMapper {

    /**
     * 根据参数查询热力图数据
     *
     * @param hotTypeParamDto
     * @return
     */
    public List<HotType> getHotTypeList(HotTypeParamDto hotTypeParamDto);

}
