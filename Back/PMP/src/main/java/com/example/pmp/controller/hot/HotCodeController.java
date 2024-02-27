package com.example.pmp.controller.hot;

import com.example.pmp.common.BaseController;
import com.example.pmp.common.lang.AjaxResult;
import com.example.pmp.pojo.hot.HotCode;
import com.example.pmp.pojo.hot.dto.HotCodeParamDto;
import com.example.pmp.service.hot.HotCodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Dandan
 * @date 2024/1/6 9:06
 **/

@Api(tags = "热力图故障类型相关接口")
@RestController
@RequestMapping("/hot/code")
public class HotCodeController extends BaseController {

    @Autowired
    private HotCodeService hotCodeService;

    @ApiOperation("获取故障类型数据列表")
    @PostMapping("/list")
    public AjaxResult getHotCodeList(@RequestBody HotCode hotCode) {
        return success(hotCodeService.getHotCodeList(hotCode));
    }

    @ApiOperation("获取故障类型数据列表(新)")
    @PostMapping("/list/new")
    public AjaxResult getHotCodeListNew(@RequestBody HotCodeParamDto hotCodeParamDto) {
        return success(hotCodeService.getHotCodeListNew(hotCodeParamDto));
    }

    @ApiOperation("根据编号获取故障名称")
    @GetMapping("/name")
    public AjaxResult getHotCodeRemarkList() {
        return success(hotCodeService.getHotCodeKidList());
    }

}
