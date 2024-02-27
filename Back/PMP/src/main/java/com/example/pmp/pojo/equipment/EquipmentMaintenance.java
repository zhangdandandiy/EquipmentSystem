package com.example.pmp.pojo.equipment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Dandan
 * @date 2023/5/8 8:16
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentMaintenance {
    private int id;
    private String product;
    private String remark;
    private String maintenance_file_name;
    private String maintenance_file_type;
    private String maintenance_file_path;
    private Long maintenance_file_size;
    private String maintenance_file_flag;
    private Date maintenance_file_upload_time;
}
