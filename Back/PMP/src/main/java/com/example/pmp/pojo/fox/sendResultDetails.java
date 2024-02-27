package com.example.pmp.pojo.fox;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ⽤于分配包装数据的 SN 列表的 JSON 标签
 *
 * @author Dandan
 * @date 2023/8/24 1933
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class sendResultDetails {

    /**
     * 制造⼯⼚的 Apple ⼯⼚代码
     */
    private String site;

    /**
     * 执⾏测试的测试站类型
     */
    private String station_type;

    /**
     * Apple 产品代码
     */
    private String product;

}
