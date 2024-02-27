package com.example.pmp.service.impl.equipment;

import com.example.pmp.mapper.equipment.EquipmentResumeMapper;
import com.example.pmp.pojo.equipment.EquipmentResume;
import com.example.pmp.service.equipment.EquipmentResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author Dandan
 * @date 2023/10/10 11:02
 **/

@Service
public class EquipmentResumeServiceImpl implements EquipmentResumeService {

    @Autowired
    private EquipmentResumeMapper equipmentResumeMapper;

    @Override
    public int saveEquipmentResume(EquipmentResume equipmentResume) {
        return equipmentResumeMapper.saveEquipmentResume(equipmentResume);
    }

    @Override
    public LinkedHashMap<String, Object> searchEquimentResume(EquipmentResume equipmentResume) {
        int pageNum = equipmentResume.getPageNum();
        int pageSize = equipmentResume.getPageSize();

        int startIndex = (pageNum - 1) * pageSize + 1;

        equipmentResume.setStartIndex(startIndex);
        List<EquipmentResume> list = equipmentResumeMapper.searchEquimentResume(equipmentResume);
        int count = equipmentResumeMapper.countEquimentResume(equipmentResume);
        int pageCount = (count + pageSize - 1) / pageSize;
        LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("currentPage", pageNum);
        resultMap.put("pageSize", pageSize);
        resultMap.put("totalCount", count);
        resultMap.put("pageCount", pageCount);
        resultMap.put("list", list);
        return resultMap;
    }

    @Override
    public int deleteEquimentResumeById(Long id) {
        return equipmentResumeMapper.deleteEquimentResumeById(id);
    }

    @Override
    public EquipmentResume searchEquipmentResumeById(Long id) {
        return equipmentResumeMapper.searchEquipmentResumeById(id);
    }

    @Override
    public int updateEquipmentResumeById(EquipmentResume equipmentResume) {
        return equipmentResumeMapper.updateEquipmentResumeById(equipmentResume);
    }
}
