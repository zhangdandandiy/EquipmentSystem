package com.example.pmp.controller.correct;

import com.example.pmp.common.BaseController;
import com.example.pmp.common.lang.AjaxResult;
import com.example.pmp.service.correct.d4y.CorrectD4YService;
import com.example.pmp.service.correct.d9x.CorrectD9XService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dandan
 * @date 2024/1/18 12:55
 **/
@Api(tags = "补正相关接口")
@RestController
@RequestMapping("/correct")
public class CorrectController extends BaseController {

    @Autowired
    private CorrectD9XService correctD9XService;

    @Autowired
    private CorrectD4YService correctD4YService;

    @PostMapping("/d9x")
    @ApiOperation("D9X补正接口")
    public AjaxResult d9xCurrent() throws IllegalAccessException {
        correctD9XService.startCurrentData();
        return success();
    }

    @PostMapping("/d4y")
    @ApiOperation("D4Y补正接口")
    public AjaxResult d4yCurrent() throws IllegalAccessException {
        correctD4YService.startCurrentData();
        return success();
    }

}
