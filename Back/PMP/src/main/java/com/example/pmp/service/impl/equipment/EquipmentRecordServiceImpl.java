package com.example.pmp.service.impl.equipment;

import com.example.pmp.mapper.equipment.EquipmentRecordMapper;
import com.example.pmp.pojo.equipment.EquipmentRecord;
import com.example.pmp.service.equipment.EquipmentRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Dandan
 * @date 2023/5/9 15:48
 **/
@Slf4j
@Service
public class EquipmentRecordServiceImpl implements EquipmentRecordService {

    @Autowired
    private EquipmentRecordMapper equipmentRecordMapper;

    @Value("${file.save-path-record-file}")
    private String savePath;

    /**
     * 上传文件至服务器
     *
     * @param equipmentRecord
     * @return
     */
    @Override
    public int insertEquipmentRecordFile(EquipmentRecord equipmentRecord) {
        return equipmentRecordMapper.saveEquipmentRecordFile(equipmentRecord);
    }

    /**
     * 查询文件列表
     *
     * @param product
     * @param remark
     * @param record_file_name
     * @return
     */
    @Override
    public List<EquipmentRecord> searchEquipmentRecordFile(String product, String remark, String record_file_name) {
        return equipmentRecordMapper.searchEquipmentRecordFile(product, remark, record_file_name);
    }

    /**
     * 通过id删除文件
     *
     * @param id
     * @return
     */
    @Override
    public void deleteEquipmentRecordFileById(Long id) {
        equipmentRecordMapper.deteteEquipmentRecordFileById(id);
    }

    /**
     * 通过id查询文件
     *
     * @param id
     * @return
     */
    @Override
    public EquipmentRecord searchEquipmentRecordFileById(Long id) {
        return equipmentRecordMapper.searchEquipmentRecordFileById(id);
    }

    /**
     * 查询文件通过文件名
     *
     * @param record_file_name
     * @return
     */
    @Override
    public EquipmentRecord searchEquipmentRecordFileByFileName(String record_file_name) {
        return equipmentRecordMapper.searchEquipmentRecordFileByFileName(record_file_name);
    }

    /**
     * 更新文件log
     *
     * @param equipmentRecord
     * @return
     */
    @Override
    public int updateEquipmentRecordFileByFileName(EquipmentRecord equipmentRecord) {
        return equipmentRecordMapper.updateEquipmentRecordFileByFileName(equipmentRecord);
    }

    @Override
    public List<EquipmentRecord> searchEquipmentFileList(String product, String remark) {
        return equipmentRecordMapper.searchEquipmentFileList(product, remark);
    }

}
