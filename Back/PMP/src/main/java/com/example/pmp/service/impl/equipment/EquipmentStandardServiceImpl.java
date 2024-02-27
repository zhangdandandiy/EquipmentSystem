package com.example.pmp.service.impl.equipment;

import com.example.pmp.mapper.equipment.EquipmentStandardMapper;
import com.example.pmp.pojo.equipment.EquipmentStandard;
import com.example.pmp.service.equipment.EquipmentStandardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Dandan
 * @date 2023/5/9 20:04
 **/
@Slf4j
@Service
public class EquipmentStandardServiceImpl implements EquipmentStandardService {
    @Autowired
    private EquipmentStandardMapper equipmentStandardMapper;

    @Value("${file.save-path-standard-file}")
    private String savePath;

    /**
     * 上传文件至服务器
     *
     * @param equipmentStandard
     * @return
     */
    @Override
    public int insertEquipmentStandardFile(EquipmentStandard equipmentStandard) {
        return equipmentStandardMapper.saveEquipmentStandardFile(equipmentStandard);
    }

    /**
     * 查询文件列表
     *
     * @param product
     * @param remark
     * @param standard_file_flag
     * @param standard_file_name
     * @return
     */
    @Override
    public List<EquipmentStandard> searchEquipmentStandardFile(String product, String remark, String standard_file_flag, String standard_file_name) {
        return equipmentStandardMapper.searchEquipmentStandardFile(product, remark, standard_file_flag, standard_file_name);
    }

    /**
     * 通过id删除文件
     *
     * @param id
     * @return
     */
    @Override
    public void deleteEquipmentStandardFileById(Long id) {
        equipmentStandardMapper.deteteEquipmentStandardFileById(id);
    }

    /**
     * 通过id查询文件
     *
     * @param id
     * @return
     */
    @Override
    public EquipmentStandard searchEquipmentStandardFileById(Long id) {
        return equipmentStandardMapper.searchEquipmentStandardFileById(id);
    }

    /**
     * 查询文件通过文件名
     *
     * @param standard_file_name
     * @return
     */
    @Override
    public EquipmentStandard searchEquipmentStandardFileByFileName(String standard_file_name) {
        return equipmentStandardMapper.searchEquipmentStandardFileByFileName(standard_file_name);
    }

    /**
     * 更新文件log
     *
     * @param equipmentStandard
     * @return
     */
    @Override
    public int updateEquipmentStandardFileByFileName(EquipmentStandard equipmentStandard) {
        return equipmentStandardMapper.updateEquipmentStandardFileByFileName(equipmentStandard);
    }

}
