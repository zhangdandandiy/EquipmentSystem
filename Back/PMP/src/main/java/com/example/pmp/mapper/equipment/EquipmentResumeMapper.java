package com.example.pmp.mapper.equipment;

import com.example.pmp.pojo.equipment.EquipmentResume;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Dandan
 * @date 2023/10/10 9:22
 **/

@Mapper
public interface EquipmentResumeMapper {

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
    List<EquipmentResume> searchEquimentResume(EquipmentResume equipmentResume);

    /**
     * 查询设备履历列表总条数
     *
     * @param equipmentResume
     * @return
     */
    int countEquimentResume(EquipmentResume equipmentResume);

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
