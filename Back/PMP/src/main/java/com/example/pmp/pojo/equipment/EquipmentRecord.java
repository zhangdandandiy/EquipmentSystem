package com.example.pmp.pojo.equipment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Dandan
 * @date 2023/5/8 8:19
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentRecord {
    private int id;
    private String product;
    private String remark;
    private String record_file_name;
    private String record_file_type;
    private String record_file_path;
    private Long record_file_size;
    private Date record_file_upload_time;
}
