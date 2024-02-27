package com.example.pmp.pojo.station.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dandan
 * @date 2023/6/29 14:26
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CaseInfoSearchListDto {

    /**
     * 专案
     */
    private String product;

    /**
     * 线体类型
     */
    private String lineType;

    /**
     * 线体编号
     */
    private String lineId;

    /**
     * 模组
     */
    private String module;

    /**
     * 班别
     */
    private String shift;

    /**
     * 日期 (y-m-d)
     */
    private String date;

}
