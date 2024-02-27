package com.example.pmp.mapper.equipment;

import com.example.pmp.pojo.equipment.EquipmentRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Dandan
 * @date 2023/5/9 13:00
 **/
@Mapper
public interface EquipmentRecordMapper {

    /**
     * 保存文件
     *
     * @param equipmentRecord
     * @return
     */
    int saveEquipmentRecordFile(EquipmentRecord equipmentRecord);

    /**
     * 查询文件列表
     *
     * @param product
     * @param line
     * @param record_file_name
     * @return
     */
    List<EquipmentRecord> searchEquipmentRecordFile(
            @Param("product") String product
            , @Param("remark") String line
            , @Param("record_file_name") String record_file_name);

    /**
     * 通过id删除文件
     *
     * @param id
     * @return
     */
    int deteteEquipmentRecordFileById(Long id);

    /**
     * 通过id查询文件
     *
     * @param id
     * @return
     */
    EquipmentRecord searchEquipmentRecordFileById(@Param("id") Long id);

    /**
     * 查询文件通过文件名
     *
     * @param record_file_name
     * @return
     */
    EquipmentRecord searchEquipmentRecordFileByFileName(@Param("record_file_name") String record_file_name);

    /**
     * 更新文件log
     *
     * @param equipmentRecord
     * @return
     */
    int updateEquipmentRecordFileByFileName(EquipmentRecord equipmentRecord);

    /**
     * 查找所有文件列表
     *
     * @param product
     * @param keyword
     * @return
     */
    List<EquipmentRecord> searchEquipmentFileList(
            @Param("product") String product
            , @Param("remark") String keyword);

}
