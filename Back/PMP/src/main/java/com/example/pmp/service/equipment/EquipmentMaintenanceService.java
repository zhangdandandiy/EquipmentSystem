package com.example.pmp.service.equipment;

import com.example.pmp.pojo.equipment.EquipmentMaintenance;

import java.util.List;

/**
 * @author Dandan
 * @date 2023/5/9 20:30
 **/
public interface EquipmentMaintenanceService {

    /**
     * 上传文件至服务器
     *
     * @param equipmentMaintenance
     * @return
     */
    int insertEquipmentMaintenanceFile(EquipmentMaintenance equipmentMaintenance);

    /**
     * 查询文件列表
     *
     * @param product
     * @param remark
     * @param maintenance_file_flag
     * @param maintenance_file_name
     * @return
     */
    List<EquipmentMaintenance> searchEquipmentMaintenanceFile(String product, String remark, String maintenance_file_flag, String maintenance_file_name);

    /**
     * 删除文件通过id
     *
     * @param id
     */
    void deleteEquipmentMaintenanceFileById(Long id);

    /**
     * 查询文件通过id
     *
     * @param id
     * @return
     */
    EquipmentMaintenance searchEquipmentMaintenanceFileById(Long id);

    /**
     * 查询文件通过文件名
     *
     * @param maintenance_file_name
     * @return
     */
    EquipmentMaintenance searchEquipmentMaintenanceFileByFileName(String maintenance_file_name);

    /**
     * 更新文件log
     *
     * @param equipmentMaintenance
     * @return
     */
    int updateEquipmentMaintenanceFileByFileName(EquipmentMaintenance equipmentMaintenance);

}
