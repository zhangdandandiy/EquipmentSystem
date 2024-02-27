package com.example.pmp.service.equipment;

import com.example.pmp.pojo.equipment.EquipmentResume;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @author Dandan
 * @date 2023/10/10 11:02
 **/
public interface EquipmentResumeService {

    /**
     * 新增设备履历信息
     *
     * @param equipmentResume
     * @return
     */
    int saveEquipmentResume(EquipmentResume equipmentResume);

    /**
     * 查询设备履历列表
     *
     * @param equipmentResume
     * @return
     */
    Map<String, Object> searchEquimentResume(EquipmentResume equipmentResume);

    /**
     * 通过Id删除履历列表
     *
     * @param id
     * @return
     */
    int deleteEquimentResumeById(Long id);

    /**
     * 通过Id查询履历列表
     *
     * @param id
     * @return
     */
    EquipmentResume searchEquipmentResumeById(@Param("id") Long id);

    /**
     * 根据Id更新履历信息
     *
     * @param equipmentResume
     * @return
     */
    int updateEquipmentResumeById(EquipmentResume equipmentResume);

}
