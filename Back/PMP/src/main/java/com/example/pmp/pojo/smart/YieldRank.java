package com.example.pmp.pojo.smart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dandan
 * @date 2023/10/10 15:06
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class YieldRank {

    private String lineType;
    private String lineId;
    private String yield;

}
