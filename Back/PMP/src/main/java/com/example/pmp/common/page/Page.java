package com.example.pmp.common.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Dandan
 * @date 2023/6/2 11:29
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page<T> {

    // 当前页
    private Integer currentPage;

    // 首页
    private Integer firstPage;

    // 上一页
    private Integer prePage;

    // 下一页
    private Integer nextPage;

    // 尾页
    private Integer lastPage;

    // 每页最大记录数
    private Integer pageSize;

    // 总记录数
    private Long totalCount;

    // 总页数
    private Integer pages;

    // 当前页实际记录数
    private Integer currentSize;

    // 当前页数据记录
    private List<T> list;

    @Override
    public String toString() {
        return "Page{" +
                "currentPage=" + currentPage +
                ", firstPage=" + firstPage +
                ", prePage=" + prePage +
                ", nextPage=" + nextPage +
                ", lastPage=" + lastPage +
                ", pageSize=" + pageSize +
                ", totalCount=" + totalCount +
                ", pages=" + pages +
                ", currentSize=" + currentSize +
                ", list=" + list +
                '}';
    }

}
