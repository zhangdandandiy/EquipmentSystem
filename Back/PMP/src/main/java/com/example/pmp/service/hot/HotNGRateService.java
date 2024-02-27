package com.example.pmp.service.hot;

import com.example.pmp.pojo.hot.HotNGFace;
import com.example.pmp.pojo.hot.HotNGRate;
import com.example.pmp.pojo.hot.dto.HotNGFaceParamDto;
import com.example.pmp.pojo.hot.dto.HotNGRateParamDto;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/2/21 10:53
 **/
public interface HotNGRateService {

    public List<HotNGRate> getHotNGRate(HotNGRateParamDto hotNGRateParamDto);

    public List<HotNGFace> getHotNGFace(HotNGFaceParamDto hotNGFaceParamDto);

}
