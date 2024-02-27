package com.example.pmp.controller.sense;

import com.example.pmp.common.BaseController;
import com.example.pmp.common.lang.AjaxResult;
import com.example.pmp.pojo.sense.SenseDataD8X;
import com.example.pmp.pojo.sense.dto.SenseDataDto;
import com.example.pmp.service.sense.SenseDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @author Dandan
 * @date 2023/7/10 13:25
 **/

@RestController
@RequestMapping("/sense")
@Api(tags = "共面度检测数据获取")
public class SenseDataController extends BaseController {

    @Autowired
    private SenseDataService senseDataService;

    @ApiOperation("查询分页检测数据")
    @GetMapping("/realData")
    public AjaxResult searchSenseRealData() {
        return success();
    }


    @ApiOperation("查询去重检测数据")
    @PostMapping("/senseData")
    public AjaxResult getAllData(@RequestBody SenseDataDto senseDataDto) {
        AjaxResult ajaxResult = AjaxResult.success();
        String Product = senseDataDto.getProduct();
        HashMap<String, Set<BigDecimal>> distinctData = null;
        switch (Product) {
            case "D8X":
                distinctData = senseDataService.getD8XAllPins(senseDataDto);
                break;
            case "X2757":
                distinctData = senseDataService.getX2757AllPins(senseDataDto);
                break;
            case "X2987":
                distinctData = senseDataService.getX2987AllPins(senseDataDto);
                break;
            case "X3047":
                distinctData = senseDataService.getX3047AllPins(senseDataDto);
                break;
        }
        ajaxResult.put("senseList", distinctData);
        return ajaxResult;
    }


    @ApiOperation("查询检测数据的平均值")
    @PostMapping("/senseAvgData")
    public AjaxResult searchAvgRealSenseData(@RequestBody SenseDataDto senseDataDto) {
        AjaxResult ajaxResult = AjaxResult.success();
        String Product = senseDataDto.getProduct();
        List<SenseDataD8X> senseAvgList = new ArrayList<>();
        switch (Product) {
            case "D8X":
                senseAvgList = senseDataService.searchD8XAvgRealSenseData(senseDataDto);
                break;
            case "X3047":
                senseAvgList = senseDataService.searchX3047AvgRealSenseData(senseDataDto);
                break;
            case "X2757":
                senseAvgList = senseDataService.searchX2757AvgRealSenseData(senseDataDto);
                break;
        }
        ajaxResult.put("senseAvgList", senseAvgList);
        return ajaxResult;
    }

}
