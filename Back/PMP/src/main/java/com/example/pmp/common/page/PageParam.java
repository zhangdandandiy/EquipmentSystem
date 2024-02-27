package com.example.pmp.common.page;

import lombok.Data;

/**
 * @author Dandan
 * @date 2023/6/2 11:29
 **/

@Data
public class PageParam {

    // 请求页码，默认为1
    private Integer pageNum = 1;

    // 每页最大记录数，默认为10
    private Integer pageSize = 10;

}
