package com.example.pmp.utils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Dandan
 * @date 2024/1/29 8:15
 **/
public class SenseUtils {

    public static <T> HashMap<String, Set<BigDecimal>> getNeedCorrectMap(List<T> dataList) {
        HashMap<String, Set<BigDecimal>> map = new HashMap<>();
        for (T object : dataList) {
            Field[] fields = object.getClass().getDeclaredFields();

            for (Field field : fields) {
                field.setAccessible(true);
                String fieldName = field.getName();
                try {
                    if (map.containsKey(fieldName)) {
                        map.get(fieldName).add(convertToBigDecimal(field.get(object)));
                    } else {
                        Set<BigDecimal> values = new HashSet<>();
                        values.add(convertToBigDecimal(field.get(object)));
                        map.put(fieldName, values);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return map;
    }

    /**
     * List<String> 转为 Set<BigDecimal>
     *
     * @param inputList
     * @return
     */
    public static Set<BigDecimal> convertToBigDecimalSet(List<String> inputList) {
        Set<BigDecimal> result = new HashSet<>();

        for (String value : inputList) {
            try {
                BigDecimal number = new BigDecimal(value);
                result.add(number);
            } catch (NumberFormatException e) {
                // 处理无法转换为 BigDecimal 的情况
                e.printStackTrace();
            }
        }

        return result;
    }

    /**
     * X2757前缀 "3D_"
     *
     * @param originalMap
     * @return
     */
    public static HashMap<String, Set<BigDecimal>> addPrefixToKeys(HashMap<String, Set<BigDecimal>> originalMap) {
        HashMap<String, Set<BigDecimal>> modifiedMap = new HashMap<>();
        for (String key : originalMap.keySet()) {
            String modifiedKey = "3D_" + key;
            modifiedMap.put(modifiedKey, originalMap.get(key));
        }
        return modifiedMap;
    }

    /**
     * X3047
     *
     * @param originalMap
     * @return
     */
    public static HashMap<String, Set<BigDecimal>> changeKeys(HashMap<String, Set<BigDecimal>> originalMap) {
        HashMap<String, Set<BigDecimal>> modifiedMap = new HashMap<>();
        for (String key : originalMap.keySet()) {
            String modifiedKey = "";
            if (key.contains("_")) {
                modifiedKey = key.replace("_", "-");
                modifiedMap.put(modifiedKey, originalMap.get(key));
            } else {
                modifiedMap.put(key, originalMap.get(key));
            }
        }
        return modifiedMap;
    }

    public static BigDecimal convertToBigDecimal(Object object) {
        BigDecimal result = null;
        if (object != null) {
            try {
                result = new BigDecimal(object.toString());
            } catch (NumberFormatException e) {
                // 处理无法转换为 BigDecimal 的情况
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 将字符串转为小数
     *
     * @param str
     * @return
     */
    public static BigDecimal StringChangeBigDecimal(String str) {
        BigDecimal decimal = null;
        try {
            decimal = new BigDecimal(str);
        } catch (NumberFormatException e) {
        }
        return decimal;
    }

}
