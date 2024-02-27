package com.example.pmp.mapper.equipment;

import com.example.pmp.pojo.equipment.EquipmentMaintenance;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Dandan
 * @date 2023/5/9 20:27
 **/
@Mapper
@Repository
public interface EquipmentMaintenanceMapper {

    /**
     * 保存文件
     *
     * @param equipmentMaintenance
     * @return
     */
    int saveEquipmentMaintenanceFile(EquipmentMaintenance equipmentMaintenance);

    /**
     * 查询文件列表
     *
     * @param product
     * @param machine
     * @param maintenance_file_flag
     * @param maintenance_file_name
     * @return
     */
    List<EquipmentMaintenance> searchEquipmentMaintenanceFile(
            @Param("product") String product
            , @Param("remark") String machine
            , @Param("maintenance_file_flag") String maintenance_file_flag
            , @Param("maintenance_file_name") String maintenance_file_name);

    /**
     * 通过id删除文件
     *
     * @param id
     * @return
     */
    int deteteEquipmentMaintenanceFileById(Long id);

    /**
     * 通过id查询文件
     *
     * @param id
     * @return
     */
    EquipmentMaintenance searchEquipmentMaintenanceFileById(@Param("id") Long id);

    /**
     * 查询文件通过文件名
     *
     * @param maintenance_file_name
     * @return
     */
    EquipmentMaintenance searchEquipmentMaintenanceFileByFileName(@Param("maintenance_file_name") String maintenance_file_name);

    /**
     * 更新文件log
     *
     * @param equipmentMaintenance
     * @return
     */
    int updateEquipmentMaintenanceFileByFileName(EquipmentMaintenance equipmentMaintenance);

}
