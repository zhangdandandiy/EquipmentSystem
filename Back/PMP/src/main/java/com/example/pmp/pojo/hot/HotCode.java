package com.example.pmp.pojo.hot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dandan
 * @date 2024/1/6 8:51
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotCode {

    private Long ID;
    private String Name;
    private String FaceCode;
    private String NGCode;
    private String NGName;
    private String NGId;
    private String NGInfo;

}
