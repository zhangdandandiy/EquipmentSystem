package com.example.pmp.pojo.fox;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 执⾏测试的测试站的项⽬
 *
 * @author Dandan
 * @date 2023/8/24 1959
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class testStationAttributes {

    /**
     * 测试的限制版本
     */
    private String limits_version;

    /**
     * 测试软件的名称
     */
    private String software_name;

    /**
     * 测试的软件版本
     */
    private String software_version;

    /**
     * 这是由⼯⼚、⽣产线和测试站类型组成的串联字段。具体格式如下：<⼯⼚代码>_<⽣产线名>_<序列号>_<测试站类型
     */
    private String station_id;

    /**
     * 测试中所⽤⼯具/夹具的标识符
     */
    private String fixture_id;

    /**
     * 测试中所⽤测试头的标
     * 识符
     */
    private String head_id;

}
