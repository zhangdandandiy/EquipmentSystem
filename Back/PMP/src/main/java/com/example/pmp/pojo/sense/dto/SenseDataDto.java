package com.example.pmp.pojo.sense.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dandan
 * @date 2023/7/13 9:46
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SenseDataDto {

    /**
     * 专案
     */
    private String Product;

    /**
     * 线体类型
     */
    private String LineType;

    /**
     * 线体编号
     */
    private String LineID;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;

}
