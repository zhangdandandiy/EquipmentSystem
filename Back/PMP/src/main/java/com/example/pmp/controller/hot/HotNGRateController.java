package com.example.pmp.controller.hot;

import com.example.pmp.common.BaseController;
import com.example.pmp.common.lang.AjaxResult;
import com.example.pmp.pojo.hot.dto.HotNGFaceParamDto;
import com.example.pmp.pojo.hot.dto.HotNGRateParamDto;
import com.example.pmp.service.hot.HotNGRateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dandan
 * @date 2024/2/21 10:54
 **/

@Api(tags = "热力图的不良占比")
@RestController
@RequestMapping("/hot/face")
public class HotNGRateController extends BaseController {

    @Autowired
    private HotNGRateService hotNGRateService;

    @ApiOperation("查询热力图不良占比")
    @PostMapping("/ng")
    public AjaxResult getHotNGRate(@RequestBody HotNGRateParamDto hotNGRateParamDto) {
        return success(hotNGRateService.getHotNGRate(hotNGRateParamDto));
    }

    @ApiOperation("查询热力图面的不良占比")
    @PostMapping("/info")
    public AjaxResult getHotNGInfo(@RequestBody HotNGFaceParamDto hotNGFaceParamDto) {
        return success(hotNGRateService.getHotNGFace(hotNGFaceParamDto));
    }

}
