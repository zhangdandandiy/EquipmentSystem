package com.example.pmp.service.impl.hot;

import com.example.pmp.mapper.hot.HotNGRateMapper;
import com.example.pmp.pojo.hot.HotNGFace;
import com.example.pmp.pojo.hot.HotNGRate;
import com.example.pmp.pojo.hot.dto.HotNGFaceParamDto;
import com.example.pmp.pojo.hot.dto.HotNGRateParamDto;
import com.example.pmp.service.hot.HotNGRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/2/21 10:53
 **/

@Service
public class HotNGRateServiceImpl implements HotNGRateService {

    @Autowired
    private HotNGRateMapper hotNGRateMapper;


    @Override
    public List<HotNGRate> getHotNGRate(HotNGRateParamDto hotNGRateParamDto) {
        return hotNGRateMapper.getHotNGRate(hotNGRateParamDto);
    }

    @Override
    public List<HotNGFace> getHotNGFace(HotNGFaceParamDto hotNGFaceParamDto) {
        return hotNGRateMapper.getHotNGFace(hotNGFaceParamDto);
    }

}
