package com.example.pmp.pojo.station;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 案件信息
 * 专案-线体类型-线体编号-模组
 *
 * @author Dandan
 * @date 2023/6/29 11:06
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CaseInfo {

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

    /**
     * 线体投入
     */
    private String moduleInput;

    /**
     * 线体产出
     */
    private String moduleOutput;

    /**
     * 线体 NG
     */
    private String moduleNG;


    /**
     * 站点列表
     */
    private List<StationInfo> stationList;

}
