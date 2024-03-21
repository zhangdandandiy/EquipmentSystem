package com.example.pmp.controller.hot;

import com.example.pmp.common.BaseController;
import com.example.pmp.common.lang.AjaxResult;
import com.example.pmp.pojo.hot.HotReportParam;
import com.example.pmp.pojo.hot.dto.HotTypeParamDto;
import com.example.pmp.service.hot.HotTypeService;
import com.example.pmp.service.hot.MThermodynamicchartTService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dandan
 * @date 2024/1/6 10:08
 **/
@Api(tags = "热力图数据相关接口")
@RestController
@RequestMapping("/hot/data")
public class HotTypeController extends BaseController {

    @Autowired
    private HotTypeService hotTypeService;

    @Autowired
    private MThermodynamicchartTService mThermodynamicchartTService;

    @ApiOperation("获取热力图数据")
    @PostMapping("/get")
    public AjaxResult getHotDataList(@RequestBody HotTypeParamDto hotTypeParamDto) {
        return success(hotTypeService.getHotDataList(hotTypeParamDto));
    }

    @ApiOperation("获取热力图报表数据")
    @PostMapping("/report")
    public AjaxResult getHotReportData(@RequestBody HotReportParam hotReport) {
        return success(hotTypeService.getHotReportData(hotReport));
    }

    @ApiOperation("插入测试数据")
    @PostMapping("/insert")
    public AjaxResult insertData() {
        return toAjax(mThermodynamicchartTService.insertMThermodynamicchartT());
    }

}
