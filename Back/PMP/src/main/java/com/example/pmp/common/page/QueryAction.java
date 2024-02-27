package com.example.pmp.common.page;

import java.util.List;

/**
 * @author Dandan
 * @date 2023/6/2 11:30
 **/

// 表示抽象查询的行为，该查询将获得一个List集合
public interface QueryAction<T> {
    public List<T> executeQuery();
}
