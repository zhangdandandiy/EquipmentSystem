package com.example.pmp.pojo.correct;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dandan
 * @date 2024/1/5 14:35
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Specification {

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
    /**
     * 要补的字段名称
     */
    private String ItemKey;
    /**
     * 要补的字段上限
     */
    private double Upper;
    /**
     * 要补的字段下限
     */
    private double Lower;
    /**
     * 字段的单位
     */
    private String Units;
    /**
     * 要补的字段的随机下限
     */
    private double RandomL;
    /**
     * 要补的字段的随机上限
     */
    private double RandomU;
    /**
     * 要补的字段的目标良率下限
     */
    private double TargetYieldL;
    /**
     * 要补的字段的目标良率上限
     */
    private double TargetYieldU;
    /**
     * 要补的字段的实际良率
     */
    private double ActualYield;

}
