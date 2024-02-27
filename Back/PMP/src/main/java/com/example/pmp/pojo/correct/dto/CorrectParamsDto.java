package com.example.pmp.pojo.correct.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dandan
 * @date 2024/1/12 8:18
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CorrectParamsDto {

    /**
     * 专案
     */
    private String Project;
    /**
     * 线体类型
     */
    private String LineType;
    /**
     * 线体编号
     */
    private String LineName;
    /**
     * 模组编号
     */
    private String EquName;
    /**
     * 站点编号
     */
    private String Station;

}
