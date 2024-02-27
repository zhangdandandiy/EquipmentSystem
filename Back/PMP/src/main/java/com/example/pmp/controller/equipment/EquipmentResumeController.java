package com.example.pmp.controller.equipment;

import com.example.pmp.pojo.equipment.EquipmentResume;
import com.example.pmp.service.equipment.EquipmentResumeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * @author Dandan
 * @date 2023/10/10 11:05
 **/
@RestController
@RequestMapping("/resume")
@Api(tags = "设备履历相关接口")
public class EquipmentResumeController {

    @Autowired
    private EquipmentResumeService equipmentResumeService;

    @ApiOperation("新增设备履历信息")
    @PostMapping("/add")
    public int add(@RequestBody EquipmentResume equipmentResume) {
        return equipmentResumeService.saveEquipmentResume(equipmentResume);
    }

    @ApiOperation("查询设备履历列表")
    @PostMapping("/list")
    public Map<String, Object> list(@RequestBody EquipmentResume equipmentResume) {
        return equipmentResumeService.searchEquimentResume(equipmentResume);
    }

    @ApiOperation("通过Id删除履历信息")
    @DeleteMapping("/delete")
    public int delete(Long id) {
        return equipmentResumeService.deleteEquimentResumeById(id);
    }

    @ApiOperation("通过Id查询履历信息")
    @GetMapping("/info")
    public EquipmentResume info(Long id) {
        return equipmentResumeService.searchEquipmentResumeById(id);
    }

    @ApiOperation("根据Id更新履历信息")
    @PostMapping("/alter")
    public int update(@RequestBody EquipmentResume equipmentResume) {
        return equipmentResumeService.updateEquipmentResumeById(equipmentResume);
    }

}
