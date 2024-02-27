package com.example.pmp.service.hot;

import com.example.pmp.pojo.hot.dto.HotTypeParamDto;

import java.util.Map;

/**
 * @author Dandan
 * @date 2024/1/6 9:52
 **/
public interface HotTypeService {

    public Map<String, Map<String, Object>> getHotDataList(HotTypeParamDto hotTypeParamDto);

}
