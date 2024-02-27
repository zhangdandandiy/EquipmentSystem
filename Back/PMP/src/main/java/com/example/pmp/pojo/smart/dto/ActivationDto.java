package com.example.pmp.pojo.smart.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dandan
 * @date 2023/10/11 16:09
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivationDto {

    private String lineType;
    private String lineId;
    private String machineId_B;

}
