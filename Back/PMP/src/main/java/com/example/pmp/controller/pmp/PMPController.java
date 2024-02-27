package com.example.pmp.controller.pmp;


import com.example.pmp.pojo.pmp.E85AutoPMP;
import com.example.pmp.service.pmp.E85AutoPMPService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Dandan
 * @date 2023/3/28 14:53
 **/
@RestController
@RequestMapping("/PMP")
@Api(tags = "PMP报表查询接口")
public class PMPController {

    @Autowired
    private E85AutoPMPService E85AutoPMPService;


    @GetMapping("/E85/QueryAllProduct")
    @CrossOrigin
    @ApiOperation("查询所有专案")
    public List<String> QueryE85Config() {
        return E85AutoPMPService.QueryConfig();
    }

    @GetMapping("/E85/QueryAllLineType")
    @CrossOrigin
    @ApiOperation("查询所有线体类型")
    public List<String> QueryE85LineType(@RequestParam(value = "Config", required = false) String Config) {
        return E85AutoPMPService.QueryLineType(Config);
    }

    @GetMapping("/E85/QueryLineid")
    @CrossOrigin
    @ApiOperation("查询所有线体编号")
    public List<String> QueryE85Lineid(@RequestParam(value = "Config", required = false) String Config,
                                       @RequestParam(value = "Line_name", required = false) String Line_name) {
        return E85AutoPMPService.QueryLineid(Config, Line_name);
    }

    @GetMapping("/E85/QueryStationName")
    @CrossOrigin
    @ApiOperation("查询所有站点名")
    public List<String> QueryE85StationName(@RequestParam(value = "Config", required = false) String Config,
                                            @RequestParam(value = "Line_name", required = false) String Line_name,
                                            @RequestParam(value = "Line_number", required = false) String Line_number) {
        return E85AutoPMPService.QueryStationName(Config, Line_name, Line_number);
    }

    @GetMapping("/E85/QueryPMPData")
    @CrossOrigin
    @ApiOperation("查询 PMP")
    public List<E85AutoPMP> QueryE85AutoPMP(@RequestParam(value = "Config", required = false) String Config,
                                            @RequestParam(value = "Line_name", required = false) String Line_name,
                                            @RequestParam(value = "Line_number", required = false) String Line_number,
                                            @RequestParam(value = "Station_name", required = false) String Station_name) {
        return E85AutoPMPService.QueryE85AutoPMP(Config, Line_name, Line_number, Station_name);
    }

}
