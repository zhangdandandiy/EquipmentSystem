package com.example.pmp.service.hot;

import com.example.pmp.pojo.hot.HotReport;
import com.example.pmp.pojo.hot.HotReportParam;
import com.example.pmp.pojo.hot.MThermodynamicchartT;
import com.example.pmp.pojo.hot.dto.HotTypeParamDto;

import java.util.List;
import java.util.Map;

/**
 * @author Dandan
 * @date 2024/1/6 9:52
 **/
public interface HotTypeService {

    public Map<String, Map<String, Object>> getHotDataList(HotTypeParamDto hotTypeParamDto);

    /**
     * 根据参数获取热力图报表数据
     *
     * @param hotReport
     * @return
     */
    public List<MThermodynamicchartT> getHotReportData(HotReportParam hotReport);

}
