package com.example.pmp.pojo.equipment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Dandan
 * @date 2023/5/8 8:22
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentStandard {
    private int id;
    private String product;
    private String remark;
    private String standard_file_name;
    private String standard_file_type;
    private String standard_file_path;
    private Long standard_file_size;
    private String standard_file_flag;
    private Date standard_file_upload_time;
}
