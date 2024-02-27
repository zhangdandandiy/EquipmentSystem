package com.example.pmp.controller.hot;

import com.example.pmp.common.BaseController;
import com.example.pmp.common.lang.AjaxResult;
import com.example.pmp.pojo.hot.HotImage;
import com.example.pmp.service.hot.HotImageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Dandan
 * @date 2024/1/29 13:43
 **/
@Api(tags = "热力图图片资源相关接口")
@RestController
@RequestMapping("/hot/image")

public class HotImageController extends BaseController {

    @Autowired
    private HotImageService hotImageService;

    /**
     * 查询热力图图片资源
     *
     * @param id 热力图图片资源主键
     * @return 热力图图片资源
     */
    @ApiOperation("查询热力图图片资源")
    @GetMapping("/get")
    public AjaxResult selectHotImageById(Long id) {
        return success(hotImageService.selectHotImageById(id));
    }

    /**
     * 查询热力图图片资源列表
     *
     * @param HotImage 热力图图片资源
     * @return 热力图图片资源集合
     */
    // @ApiOperation("查询热力图图片资源列表")
    @PostMapping("/list")
    public AjaxResult selectHotImageList(@RequestBody HotImage hotImage) {
        return success(hotImageService.selectHotImageList(hotImage));
    }

    @ApiOperation("查询热力图图片资源列表")
    @PostMapping("/imageList")
    public AjaxResult selectHotImageURLList(@RequestBody HotImage hotImage) {
        return success(hotImageService.selectHotImageURLList(hotImage));
    }

}
