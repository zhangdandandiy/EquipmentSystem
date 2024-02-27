package com.example.pmp.mapper.hot;

import com.example.pmp.pojo.hot.HotNGFace;
import com.example.pmp.pojo.hot.HotNGRate;
import com.example.pmp.pojo.hot.dto.HotNGFaceParamDto;
import com.example.pmp.pojo.hot.dto.HotNGRateParamDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/2/21 10:43
 **/

@Mapper
public interface HotNGRateMapper {

    public List<HotNGRate> getHotNGRate(HotNGRateParamDto hotNGRateParamDto);

    public List<HotNGFace> getHotNGFace(HotNGFaceParamDto hotNGFaceParamDto);

}
