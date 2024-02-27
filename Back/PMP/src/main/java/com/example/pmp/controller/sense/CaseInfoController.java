package com.example.pmp.controller.sense;

import com.example.pmp.common.lang.AjaxResult;
import com.example.pmp.service.station.CaseInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Dandan
 * @date 2023/6/29 13:54
 **/

@RestController
@RequestMapping("/station")
@Api(tags = "站点检测项信息接口")
public class CaseInfoController {

    @Autowired
    private CaseInfoService caseInfoService;

    @GetMapping("/product")
    @ApiOperation(value = "查询所有专案")
    public AjaxResult searchAllProducts() {
        AjaxResult ajaxResult = AjaxResult.success();
        List<String> products = caseInfoService.searchAllProduct();
        ajaxResult.put("data", products);
        return ajaxResult;
    }

    @GetMapping("/lineType")
    @ApiOperation(value = "根据专案查询所有线体类型")
    public AjaxResult searchAllLineTypes(@RequestParam(value = "product", required = false) String product) {
        AjaxResult ajaxResult = AjaxResult.success();
        List<String> lineTypes = caseInfoService.searchAllLineTypeByProduct(product);
        ajaxResult.put("data", lineTypes);
        return ajaxResult;
    }

    @GetMapping("/lineID")
    @ApiOperation(value = "根据专案和线体类型查询所有线体编号")
    public AjaxResult searchAllLineIDs(@RequestParam(value = "product", required = false) String product,
                                       @RequestParam(value = "lineType", required = false) String lineType) {
        AjaxResult ajaxResult = AjaxResult.success();
        List<String> lineIDs = caseInfoService.searchAllLineIdByLineType(product, lineType);
        ajaxResult.put("data", lineIDs);
        return ajaxResult;
    }

    @GetMapping("/module")
    @ApiOperation(value = "根据专案和线体类型和线体编号查询所有模组")
    public AjaxResult searchAllModules(@RequestParam(value = "product", required = false) String product,
                                       @RequestParam(value = "lineType", required = false) String lineType,
                                       @RequestParam(value = "lineID", required = false) String lineID) {
        AjaxResult ajaxResult = AjaxResult.success();
        List<String> modules = caseInfoService.searchAllModuleByLineId(product, lineType, lineID);
        ajaxResult.put("data", modules);
        return ajaxResult;
    }

    /**
     *     @PostMapping("/caseInfo")
     *
     *     @ApiOperation(value = "查询检测项信息")
     *     public AjaxResult searchCaseInfoList(@RequestBody CaseInfoSearchListDto searchListDto) {
     *         AjaxResult ajaxResult = AjaxResult.success();
     *         List<CaseInfo> caseInfo = caseInfoService.searchCaseInfoList(searchListDto);
     *         ajaxResult.put("data", caseInfo);
     *         return ajaxResult;
     *     }
     */

}
