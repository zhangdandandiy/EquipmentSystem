package com.example.pmp.controller.sap;

import com.example.pmp.common.lang.AjaxResult;
import com.example.pmp.pojo.sap.SapLot;
import com.example.pmp.service.sap.SapLotService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Dandan
 * @date 2023/10/27 9:35
 **/

@RestController
@RequestMapping("/sap")
@Api(tags = "SAP相关接口")
public class SapLotController {

    @Autowired
    private SapLotService sapLotService;

    @GetMapping("/list")
    @ApiOperation("/获取sap列表数据")
    public AjaxResult searchSapLotList(String pid, String status) {
        AjaxResult ajaxResult = AjaxResult.success();
        List<SapLot> sapLotList = sapLotService.searchSapLotList(pid, status);
        ajaxResult.put("sapList", sapLotList);
        return ajaxResult;
    }

}
