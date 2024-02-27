package com.example.pmp.pojo.hot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dandan
 * @date 2024/2/21 10:41
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotNGRate {

    private String ProjectName;
    private String LineType;
    private String LineName;
    private String ModuleID;
    private String Direction;
    private String NGNum;
    private String Output;
    private String NGRate;

}
