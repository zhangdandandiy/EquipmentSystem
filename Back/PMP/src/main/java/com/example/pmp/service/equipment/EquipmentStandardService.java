package com.example.pmp.service.equipment;

import com.example.pmp.pojo.equipment.EquipmentStandard;

import java.util.List;

/**
 * @author Dandan
 * @date 2023/5/9 20:02
 **/
public interface EquipmentStandardService {

    /**
     * 上传文件至服务器
     *
     * @param equipmentStandard
     * @return
     */
    int insertEquipmentStandardFile(EquipmentStandard equipmentStandard);

    /**
     * 查询文件列表
     *
     * @param product
     * @param remark
     * @param standard_file_flag
     * @param standard_file_name
     * @return
     */
    List<EquipmentStandard> searchEquipmentStandardFile(String product, String remark, String standard_file_flag, String standard_file_name);

    /**
     * 删除文件通过id
     *
     * @param id
     */
    void deleteEquipmentStandardFileById(Long id);

    /**
     * 查询文件通过id
     *
     * @param id
     * @return
     */
    EquipmentStandard searchEquipmentStandardFileById(Long id);

    /**
     * 查询文件通过文件名
     *
     * @param standard_file_name
     * @return
     */
    EquipmentStandard searchEquipmentStandardFileByFileName(String standard_file_name);

    /**
     * 更新文件log
     *
     * @param equipmentStandard
     * @return
     */
    int updateEquipmentStandardFileByFileName(EquipmentStandard equipmentStandard);


}
