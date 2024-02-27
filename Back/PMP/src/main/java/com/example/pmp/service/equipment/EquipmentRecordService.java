package com.example.pmp.service.equipment;

import com.example.pmp.pojo.equipment.EquipmentRecord;

import java.util.List;

/**
 * @author Dandan
 * @date 2023/5/9 13:28
 **/
public interface EquipmentRecordService {

    /**
     * 上传文件至服务器
     *
     * @param equipmentRecord
     * @return
     */
    int insertEquipmentRecordFile(EquipmentRecord equipmentRecord);

    /**
     * 查询文件列表
     *
     * @param product
     * @param remark
     * @param record_file_name
     * @return
     */
    List<EquipmentRecord> searchEquipmentRecordFile(String product, String remark, String record_file_name);

    /**
     * 通过id删除文件
     *
     * @param id
     * @return
     */
    void deleteEquipmentRecordFileById(Long id);

    /**
     * 通过id查询文件
     *
     * @param id
     * @return
     */
    EquipmentRecord searchEquipmentRecordFileById(Long id);

    /**
     * 查询文件通过文件名
     *
     * @param record_file_name
     * @return
     */
    EquipmentRecord searchEquipmentRecordFileByFileName(String record_file_name);

    /**
     * 更新文件log
     *
     * @param equipmentRecord
     * @return
     */
    int updateEquipmentRecordFileByFileName(EquipmentRecord equipmentRecord);

    List<EquipmentRecord> searchEquipmentFileList(String product, String remark);

}
