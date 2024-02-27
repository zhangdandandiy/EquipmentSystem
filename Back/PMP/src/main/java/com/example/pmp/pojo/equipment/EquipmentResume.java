package com.example.pmp.pojo.equipment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Dandan
 * @date 2023/10/10 9:01
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentResume {

    private Long id;
    private String product;
    private String materialCode;
    private String machineNumber;
    private String equipmentName;
    private String stationName;
    private String faultReason;
    private String maintenancePerson;
    private String recorder;
    private String remark;
    private Date recordDate;

    private int startIndex;
    private int pageNum;
    private int pageSize;

}
