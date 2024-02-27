package com.example.pmp.pojo.fox;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 采集测试的结果
 *
 * @author Dandan
 * @date 2023/8/24 1935
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class results {

    /**
     * 测试的下限
     */
    private String lower_limit;

    /**
     * 测试的完整参数密钥。“parametric_key” 由“test”、“sub_test”和“sub_sub_test” 串联构成
     */
    private String parametric_key;

    /**
     * 测试的优先级与参数键有关
     */
    private String priority;

    /**
     * 测试结果 (“PASS/FAIL”(通过/未通过))
     */
    private String result;

    /**
     * 测试名称的第三级
     */
    private String sub_sub_test;

    /**
     * 测试名称的第⼆级
     */
    private String sub_test;

    /**
     * 测试名称的第⼀级
     */
    private String test;

    /**
     * 度量单位
     */
    private String units;

    /**
     * 测试的上限
     */
    private String upper_limit;

    /**
     * 测试的上限
     */
    private String value;

}
