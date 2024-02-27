package com.example.pmp.pojo.fox;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 受测设备的特征集合
 *
 * @author Dandan
 * @date 2023/8/24 1938
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class testAttributes {

    /**
     * 测试结果
     */
    private String test_result;

    /**
     * 成品的序列号
     */
    private String unit_serial_number;

    /**
     * 测试开始时的时间戳
     */
    private String uut_start;

    /**
     * 测试结束时的时间戳
     */
    private String uut_stop;

}
