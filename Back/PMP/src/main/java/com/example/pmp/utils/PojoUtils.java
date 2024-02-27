package com.example.pmp.utils;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * 实体类相关工具类
 *
 * @author Dandan
 * @date 2023/6/5 8:50
 **/
public class PojoUtils {

    /**
     * 判断是否需要更新实体类属性
     *
     * @param newValue
     * @param updater
     */
    public static void updateIfNotNull(Object newValue, Consumer<Object> updater) {
        Optional.ofNullable(newValue).ifPresent(updater);
    }

}
