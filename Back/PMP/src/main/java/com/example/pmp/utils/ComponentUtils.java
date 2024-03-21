package com.example.pmp.utils;

import com.example.pmp.pojo.component.ComponentFAI;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @author Dandan
 * @date 2024/1/16 13:02
 **/
public class ComponentUtils {

    public static ComponentFAI getFAIData(List<BigDecimal> dataList) {
        ComponentFAI componentFAI = new ComponentFAI();

        List<BigDecimal> sortDataList = dataList.stream()
                .sorted()
                .collect(Collectors.toList());

        // 计算 第一分位数 25百分位数 下四分位数 Q1
        BigDecimal Q1 = calculateQuartile(sortDataList, 0.25);
        // 计算 第二分位数 50百分位数 中位数 Q2
        // BigDecimal Q2 = calculateQuartile(sortDataList, 0.5);
        // 计算 第三分位数 75百分位数 上四分位数 Q3
        BigDecimal Q3 = calculateQuartile(sortDataList, 0.75);
        // 中位数
        BigDecimal medianData = getDataListMedian(sortDataList);
        // 四分位差 IQR = Q3 - Q1
        BigDecimal IQR = Q3.subtract(Q1);
        // 上界 Q3 + 1.5 · IQR
        BigDecimal upper = Q3.add(IQR.multiply(BigDecimal.valueOf(1.5)));
        // 下界 Q1 - 1.5 · IQR
        BigDecimal lower = Q1.subtract(IQR.multiply(BigDecimal.valueOf(1.5)));

        componentFAI.setMin(lower);
        componentFAI.setLowerQuartile(Q1);
        componentFAI.setMedium(medianData);
        componentFAI.setUpperQuartile(Q3);
        componentFAI.setMax(upper);
        componentFAI.setIQR(IQR);
        return componentFAI;
    }

    /**
     * 计算百分位数
     *
     * @param dataList
     * @param percentile
     * @return
     */
    private static BigDecimal calculateQuartile(List<BigDecimal> dataList, double percentile) {
        int size = dataList.size();
        double index = size * percentile;
        BigDecimal quartile;
        if (index % 1 == 0) {
            int lowerIndex = (int) index - 1;
            int upperIndex = (int) index;
            BigDecimal lowerValue = dataList.get(lowerIndex);
            BigDecimal upperValue = dataList.get(upperIndex);
            quartile = lowerValue.add(upperValue).divide(new BigDecimal(2));
        } else {
            quartile = dataList.get((int) index);
        }
        return quartile;
    }

    public static BigDecimal generateRandomBigDecimal(double min, double max) {
        Random random = new Random();
        double randomDouble = min + (max - min) * random.nextDouble();
        BigDecimal randomBigDecimal = BigDecimal.valueOf(randomDouble).setScale(2, BigDecimal.ROUND_HALF_UP);
        return randomBigDecimal;
    }

    public static BigDecimal generateRandomBigDecimal0(double min, double max) {
        Random random = new Random();
        double randomDouble = min + (max - min) * random.nextDouble();
        BigDecimal randomBigDecimal = BigDecimal.valueOf(randomDouble).setScale(0, BigDecimal.ROUND_HALF_UP);
        return randomBigDecimal;
    }

    /**
     * 将 string 集合转为 Decimal 集合
     *
     * @param stringList
     * @return
     */
    public static List<BigDecimal> StringChangeDecimalList(List<String> stringList) {
        List<BigDecimal> decimalList = new ArrayList<>();

        for (String str : stringList) {
            BigDecimal decimal;

            if (str == null || str.isEmpty()) {
                decimal = BigDecimal.ZERO;
                decimalList.add(decimal);
                // 跳过本次循环，继续下一次循环
                continue;
            }

            try {
                decimal = new BigDecimal(str);
            } catch (NumberFormatException e) {
                decimal = BigDecimal.ZERO;
            }

            decimalList.add(decimal);
        }
        return decimalList;
    }

    /**
     * 获取键值对
     *
     * @param dataList
     * @param <T>
     * @return
     */
    public static <T> LinkedHashMap<String, List<String>> getFAIDataMap(List<T> dataList) {
        LinkedHashMap<String, List<String>> map = new LinkedHashMap<>();
        if (dataList.size() > 0) {
            for (T object : dataList) {
                Field[] fields = object.getClass().getDeclaredFields();

                for (Field field : fields) {
                    field.setAccessible(true);
                    String fieldName = field.getName();
                    try {
                        if (map.containsKey(fieldName)) {
                            map.get(fieldName).add((String) field.get(object));
                        } else {
                            List<String> values = new ArrayList<>();
                            values.add((String) field.get(object));
                            map.put(fieldName, values);
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return map;
    }

    /**
     * 获取排序后数据的中位数
     *
     * @param dataList
     * @return
     */
    public static BigDecimal getDataListMedian(List<BigDecimal> dataList) {
        // 获取中位数
        BigDecimal median;
        int size = dataList.size();
        if (size % 2 == 0) {
            // 偶数个元素，取中间两个元素的平均值
            BigDecimal midIndex1 = dataList.get(size / 2 - 1);
            BigDecimal midIndex2 = dataList.get(size / 2);
            median = midIndex1.add(midIndex2).divide(new BigDecimal(2));
        } else {
            // 奇数个元素，直接取中间的元素
            median = dataList.get(size / 2);
        }
        return median;
    }

    /**
     * 获取 double 类型数据最近整数
     *
     * @param number
     * @return
     */
    public static int getNearDouble(double number) {
        // 最近整数（四舍五入）
        return (int) Math.round(number);
    }

    /**
     * 获取 BigDecimal 类型数据最近整数
     * 四舍五入
     *
     * @param number
     * @return
     */
    public static int getNearInt(BigDecimal number) {
        // 最近整数（四舍五入）
        return number.setScale(0, RoundingMode.HALF_UP).intValue();
    }

    /**
     * 判断一个 BigDecimal 类型数据是否是整数
     * true 是整数
     * false 不是整数
     *
     * @param number
     * @return
     */
    public static boolean isIntegerBigDecimal(BigDecimal number) {
        BigDecimal integerPart = number.setScale(0, BigDecimal.ROUND_DOWN);
        BigDecimal fractionalPart = number.subtract(integerPart).stripTrailingZeros();
        return fractionalPart.compareTo(BigDecimal.ZERO) == 0;
    }

    /**
     * 判断一个 double 类型数据是否是整数
     * true 是整数
     * false 不是整数
     *
     * @param number
     * @return
     */
    public static boolean isIntegerDouble(double number) {
        return (long) number == number;
    }

    /**
     * 将字符串转为小数
     *
     * @param str
     * @return
     */
    public static BigDecimal StringChangeBigDecimal(String str) {
        BigDecimal decimal = null;
        if (str == null || str.isEmpty()) {
            decimal = BigDecimal.ZERO;
        } else {
            try {
                decimal = new BigDecimal(str);
            } catch (NumberFormatException e) {
            }
        }

        return decimal;
    }

}
