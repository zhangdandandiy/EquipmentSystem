package com.example.pmp.pojo.smart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dandan
 * @date 2023/10/11 15:58
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Activation {

    private String lineType;
    private String lineId;
    private String Performance;
    private String Availability;

}
