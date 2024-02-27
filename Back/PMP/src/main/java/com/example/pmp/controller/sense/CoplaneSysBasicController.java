package com.example.pmp.controller.sense;

import com.example.pmp.common.BaseController;
import com.example.pmp.common.lang.AjaxResult;
import com.example.pmp.pojo.sense.CoplaneSysBasic;
import com.example.pmp.service.sense.CoplaneSysBasicService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Dandan
 * @date 2023/11/24 15:25
 **/

@Api(tags = "共面度基础维护相关接口")
@RestController
@RequestMapping("/coplane")
public class CoplaneSysBasicController extends BaseController {

    @Autowired
    private CoplaneSysBasicService coplaneSysBasicService;

    /**
     * 查询共面度检测基础维护数据列表
     */
    @GetMapping("/list")
    public AjaxResult list(CoplaneSysBasic CoplaneSysBasic) {
        return success(coplaneSysBasicService.selectCoplaneSysBasicList(CoplaneSysBasic));
    }

    /**
     * 获取共面度检测基础维护数据详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(coplaneSysBasicService.selectCoplaneSysBasicById(id));
    }

    /**
     * 新增共面度检测基础维护数据
     */
    @PostMapping("/add")
    public AjaxResult add(@RequestBody CoplaneSysBasic CoplaneSysBasic) {
        return toAjax(coplaneSysBasicService.insertCoplaneSysBasic(CoplaneSysBasic));
    }

    /**
     * 修改共面度检测基础维护数据
     */
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody CoplaneSysBasic CoplaneSysBasic) {
        return toAjax(coplaneSysBasicService.updateCoplaneSysBasic(CoplaneSysBasic));
    }

    /**
     * 删除共面度检测基础维护数据
     */
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(coplaneSysBasicService.deleteCoplaneSysBasicByIds(ids));
    }

}
