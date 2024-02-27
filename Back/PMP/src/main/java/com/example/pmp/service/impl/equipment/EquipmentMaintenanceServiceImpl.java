package com.example.pmp.service.impl.equipment;

import com.example.pmp.mapper.equipment.EquipmentMaintenanceMapper;
import com.example.pmp.pojo.equipment.EquipmentMaintenance;
import com.example.pmp.service.equipment.EquipmentMaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Dandan
 * @date 2023/5/9 20:34
 **/
@Service
public class EquipmentMaintenanceServiceImpl implements EquipmentMaintenanceService {

    @Autowired
    private EquipmentMaintenanceMapper equipmentMaintenanceMapper;

    @Value("${file.save-path-maintenance-file}")
    private String savePath;

    /**
     * 上传文件至服务器
     *
     * @param equipmentMaintenance
     * @return
     */
    @Override
    public int insertEquipmentMaintenanceFile(EquipmentMaintenance equipmentMaintenance) {
        return equipmentMaintenanceMapper.saveEquipmentMaintenanceFile(equipmentMaintenance);
    }

    /**
     * 查询文件列表
     *
     * @param product
     * @param remark
     * @param maintenance_file_name
     * @param maintenance_file_flag
     * @return
     */
    @Override
    public List<EquipmentMaintenance> searchEquipmentMaintenanceFile(String product, String remark, String maintenance_file_name, String maintenance_file_flag) {
        return equipmentMaintenanceMapper.searchEquipmentMaintenanceFile(product, remark, maintenance_file_name, maintenance_file_flag);
    }

    /**
     * 通过id删除文件
     *
     * @param id
     * @return
     */
    @Override
    public void deleteEquipmentMaintenanceFileById(Long id) {
        equipmentMaintenanceMapper.deteteEquipmentMaintenanceFileById(id);
    }

    /**
     * 通过id查询文件
     *
     * @param id
     * @return
     */
    @Override
    public EquipmentMaintenance searchEquipmentMaintenanceFileById(Long id) {
        return equipmentMaintenanceMapper.searchEquipmentMaintenanceFileById(id);
    }

    /**
     * 查询文件通过文件名
     *
     * @param maintenance_file_name
     * @return
     */
    @Override
    public EquipmentMaintenance searchEquipmentMaintenanceFileByFileName(String maintenance_file_name) {
        return equipmentMaintenanceMapper.searchEquipmentMaintenanceFileByFileName(maintenance_file_name);
    }

    /**
     * 更新文件log
     *
     * @param equipmentMaintenance
     * @return
     */
    @Override
    public int updateEquipmentMaintenanceFileByFileName(EquipmentMaintenance equipmentMaintenance) {
        return equipmentMaintenanceMapper.updateEquipmentMaintenanceFileByFileName(equipmentMaintenance);
    }

}
