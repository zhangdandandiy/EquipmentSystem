package com.example.pmp.controller.component;

import com.example.pmp.common.BaseController;
import com.example.pmp.common.lang.AjaxResult;
import com.example.pmp.pojo.component.dto.ComponentParam;
import com.example.pmp.service.component.ComponentD4YService;
import com.example.pmp.service.component.ComponentD9XService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dandan
 * @date 2024/1/16 11:21
 **/

@Api(tags = "零件尺寸数据相关接口")
@RestController
@RequestMapping("/part")
public class ComponentController extends BaseController {

    @Autowired
    private ComponentD9XService componentD9XService;

    @Autowired
    private ComponentD4YService componentD4YService;

    @PostMapping("/d9x/data")
    @ApiOperation("D9X零件尺寸数据获取")
    public AjaxResult getD9XComponent(@RequestBody ComponentParam componentParam) {
        return success(componentD9XService.selectComponentFAIData(componentParam));
    }

    @PostMapping("/d4y/data")
    @ApiOperation("D4Y零件尺寸数据获取")
    public AjaxResult getD4YComponent(@RequestBody ComponentParam componentParam) {
        return success(componentD4YService.selectComponentFAIData(componentParam));
    }


}
