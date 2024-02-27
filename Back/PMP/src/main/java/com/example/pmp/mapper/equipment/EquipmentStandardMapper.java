package com.example.pmp.mapper.equipment;

import com.example.pmp.pojo.equipment.EquipmentStandard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Dandan
 * @date 2023/5/9 19:51
 **/
@Mapper
public interface EquipmentStandardMapper {

    /**
     * 保存文件
     *
     * @param equipmentStandard
     * @return
     */
    int saveEquipmentStandardFile(EquipmentStandard equipmentStandard);

    /**
     * 查询文件列表
     *
     * @param product
     * @param machine
     * @param standard_file_flag
     * @param standard_file_name
     * @return
     */
    List<EquipmentStandard> searchEquipmentStandardFile(
            @Param("product") String product
            , @Param("remark") String machine
            , @Param("standard_file_flag") String standard_file_flag
            , @Param("standard_file_name") String standard_file_name);

    /**
     * 通过id删除文件
     *
     * @param id
     * @return
     */
    int deteteEquipmentStandardFileById(Long id);

    /**
     * 通过id查询文件
     *
     * @param id
     * @return
     */
    EquipmentStandard searchEquipmentStandardFileById(@Param("id") Long id);

    /**
     * 查询文件通过文件名
     *
     * @param standard_file_name
     * @return
     */
    EquipmentStandard searchEquipmentStandardFileByFileName(@Param("standard_file_name") String standard_file_name);

    /**
     * 更新文件log
     *
     * @param equipmentStandard
     * @return
     */
    int updateEquipmentStandardFileByFileName(EquipmentStandard equipmentStandard);

}
