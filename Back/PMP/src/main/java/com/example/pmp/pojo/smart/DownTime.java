package com.example.pmp.pojo.smart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dandan
 * @date 2023/10/10 14:19
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DownTime {

    private String product;
    private String lineType;
    private String lineid;
    private String machineId;
    private String msg;
    private String code;
    private Long counttime;
    private String ymd;

}
