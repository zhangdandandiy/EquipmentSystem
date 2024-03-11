package com.example.pmp.utils;

import com.example.pmp.pojo.correct.CorrectLog;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author Dandan
 * @date 2024/1/3 14:16
 **/
public class CorrectUtils {

    /**
     * 发送企业微信消息
     * 注意要是消息体过长，超出限制，无法正常发送
     *
     * @param personList
     * @param correctLogList
     */
    public static void sendMessage(List<String> personList, List<CorrectLog> correctLogList) {
        String personStr = String.join(",", personList);

        StringBuilder totalMsg = new StringBuilder();
        int counter = 0;
        // 发送消息批次大小
        // 太长会截断，会发送不成功
        int batchSize = 10;

        if (correctLogList.size() > 0) {
            for (CorrectLog correctLog : correctLogList) {
                String Project = "专案：" + correctLog.getProject() + "\n";
                String itemKey = "FAI名称：" + correctLog.getItemKey() + "\n";
                String totalCount = "总数：" + correctLog.getDataCount() + "\n";
                String beforeGoodCount = "补之前良品数：" + correctLog.getBeforeGoodCount() + "\n";
                String beforeYield = "补之前良率：" + correctLog.getBeforeYield() + "\n";
                String afterGoodCount = "补之后良品数：" + correctLog.getAfterGoodCount() + "\n";
                String afterYield = "补之后良率：" + correctLog.getAfterYield() + "\n" + "\n";

                String singleMsg = Project + itemKey + totalCount + beforeGoodCount + beforeYield + afterGoodCount + afterYield;
                totalMsg.append(singleMsg);
                counter++;

                if (counter == batchSize) {
                    // 达到发送批量大小，发送消息并重置计数器
                    // 清空StringBuilder
                    sendBatchMessage(personStr, totalMsg.toString());
                    totalMsg.setLength(0);
                    counter = 0;
                }

                // 每隔 1 秒进行下一次循环(发送下一条消息)，防止有时候发送消息不全
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            // 发送剩余的消息
            if (totalMsg.length() > 0) {
                sendBatchMessage(personStr, totalMsg.toString());
            }
        } else {
            totalMsg.append("昨天没有数据，未补正");
            sendBatchMessage(personStr, totalMsg.toString());
        }
    }

    /**
     * 分批发送消息
     */
    public static void sendBatchMessage(String personStr, String totalMsg) {

        String url = "https://m.luxshare-ict.com/api/WorkWeChat/SendTextMessage";
        Integer SendApp = 2;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // 构建请求体
        String postData = String.format("{\"SendApp\":\"%s\",\"Account\":\"%s\",\"Password\":\"%s\",\"EmpCodes\":\"%s\",\"Content\":\"%s\"}", SendApp, "12213243", "7kcH8S0Bt&^buGtS", personStr, totalMsg);

        HttpEntity<String> entity = new HttpEntity<>(postData, headers);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity(url, entity, String.class);
    }

    /**
     * 根据传入的 字段 ，更改为正确的 字段
     */
    public static String getCurrentString(String str) {
        List<String> stringList = Arrays.asList(
                "CCD7_FAI31_1",
                "CCD7_FAI61_1",
                "CCD7_FAI31_2",
                "CCD7_FAI61_2",
                "CCD7_FAI57_1",
                "CCD7_FAI63_1",
                "CCD7_FAI57_2",
                "CCD7_FAI63_2"
        );

        if (!stringList.contains(str)) {
            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '_') {
                    count++;
                }
            }
            if (count > 1) {
                int lastIndex = str.lastIndexOf("_");
                if (lastIndex != -1) {
                    str = str.substring(0, lastIndex) + "-" + str.substring(lastIndex + 1);
                }
            }
            if (str.contains("Scan")) {
                str = "3D " + str;
            }
            if (str.contains("SCAN")) {
                str = "3D" + str;
            }
        }

        return str;
    }

    /**
     * 根据传入的 hashMap 和实体类，将 HashMap 转为 List 集合
     *
     * @param hashMap
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> getCurrentStationAfterSpecList(HashMap<String, List<Object>> hashMap, Class<T> clazz) {
        List<T> entityCorrectList = new ArrayList<>();
        List<String> keys = new ArrayList<>(hashMap.keySet());
        int size = 0;
        if (keys.size() > 0) {
            size = hashMap.get(keys.get(0)).size();
        }

        for (int i = 0; i < size; i++) {
            T entity = createNewEntity(clazz);
            for (String key : keys) {
                List<Object> values = hashMap.get(key);
                Object value = values.get(i);

                Optional<Method> setterMethod = getSetterMethod(clazz, key);

                setterMethod.ifPresent(method -> {
                    try {
                        method.invoke(entity, value);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new RuntimeException("没有这个键" + key);
                    }
                });
            }
            entityCorrectList.add(entity);
        }
        return entityCorrectList;
    }

    /**
     * 创建对象实例
     *
     * @param clazz
     * @param <T>
     * @return
     */
    private static <T> T createNewEntity(Class<T> clazz) {
        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException("创建对象实例失败");
        }
    }

    /**
     * 将需要补正的数据转成 HashMap
     * <p>
     * colunm1: [1.1,1.0,0.5]
     * colunm2: [0.7,0.4,0.3]
     * colunm3: [0.7,0.5,0.5]
     * colunm4: [0.9,0.2,0.3]
     * </p>
     *
     * @param dataList
     * @return
     */
    public static <T> HashMap<String, List<Object>> getNeedCorrectMap(List<T> dataList) {
        HashMap<String, List<Object>> map = new HashMap<>();
        for (T object : dataList) {
            Field[] fields = object.getClass().getDeclaredFields();

            for (Field field : fields) {
                field.setAccessible(true);
                String fieldName = field.getName();
                try {
                    if (map.containsKey(fieldName)) {
                        map.get(fieldName).add(field.get(object));
                    } else {
                        List<Object> values = new ArrayList<>();
                        values.add(field.get(object));
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
     * 判断实体类中是否有某个字段
     * true 有 false 无
     *
     * @param object
     * @param fieldName
     * @return
     */
    public static boolean hasField(Object object, String fieldName) {
        Class<?> clazz = object.getClass();
        try {
            // 去除 fieldName 中的空格
            // fieldName = fieldName.trim();
            // 获取类中指定名称的字段，包括私有字段
            clazz.getDeclaredField(fieldName);
            return true;
        } catch (NoSuchFieldException e) {
            // 如果字段不存在，则捕获异常，并返回 false
            return false;
        }
    }

    /**
     * 获取实体类中某个属性的值
     *
     * @param object
     * @param fieldName
     * @return
     * @throws IllegalAccessException
     */
    public static Object getFieldValue(Object object, String fieldName) throws IllegalAccessException {
        Class<?> clazz = object.getClass();
        try {
            // 获取类中指定名称的字段，包括私有字段
            Field field = clazz.getDeclaredField(fieldName);
            // 设置字段可访问（因为可能是私有字段）
            field.setAccessible(true);
            // 获取字段的值
            Object value = field.get(object);
            return value;
        } catch (NoSuchFieldException e) {
            // 如果字段不存在，则捕获异常，返回 null
            return null;
        }
    }

    /**
     * 给测试时间加上固定间隔
     *
     * @param inputTime
     * @param milliseconds
     * @return
     */
    public static String addMilliseconds(String inputTime, int milliseconds) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        try {
            Date date = dateFormat.parse(inputTime);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.MILLISECOND, milliseconds);
            return dateFormat.format(calendar.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取当前补正数据的开始时间
     *
     * @return
     */
    public static String getCurrentCorrectStartTime() {
        return getYesterdayTimeString(8);
    }

    /**
     * 获取当前补正数据的结束时间
     *
     * @return
     */
    public static String getCurrentCorrectEndTime() {
        return getTodayTimeString(8);
    }

    /**
     * 获取今天 D9X 日志的创建时间
     *
     * @return
     */
    public static String getCorrectLogD9XCreateTime() {
        return getTodayTimeString(21);
    }

    /**
     * 获取今天 D4Y 日志的创建时间
     *
     * @return
     */
    public static String getCorrectLogD4YCreateTime() {
        return getTodayTimeString(20);
    }

    /**
     * 获取昨天时间
     *
     * @param hour
     * @return
     */
    public static String getYesterdayTimeString(int hour) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime yesterdayMorningEight = LocalDateTime.of(now.toLocalDate().minusDays(1), LocalTime.of(hour, 0));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        return yesterdayMorningEight.format(formatter);
    }

    /**
     * 获取今天时间
     *
     * @param hour
     * @return
     */
    public static String getTodayTimeString(int hour) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime todayMorningEight = LocalDateTime.of(now.toLocalDate(), LocalTime.of(hour, 0));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        return todayMorningEight.format(formatter);
    }

    /**
     * 获取昨天时间
     *
     * @param hour
     * @return
     */
    public static Date getYesterdayTimeDate(int hour) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime yesterdayMorningEight = LocalDateTime.of(now.toLocalDate().minusDays(1), LocalTime.of(hour, 0));
        return Date.from(yesterdayMorningEight.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获取指定类的指定属性的setter方法
     *
     * @param clazz
     * @param propertyName
     * @return
     */
    public static Optional<Method> getSetterMethod(Class<?> clazz, String propertyName) {
        // 将属性名的首字母转为大写
        String capitalizedPropertyName = propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);

        try {
            // 获取setter方法
            return Optional.of(clazz.getMethod("set" + capitalizedPropertyName, clazz.getDeclaredField(propertyName).getType()));
        } catch (NoSuchMethodException | NoSuchFieldException e) {
            // 如果方法或字段不存在，返回空Optional
            return Optional.empty();
        }
    }

    /**
     * 在上下限范围内生成随机数
     *
     * @param lowerBound
     * @param upperBound
     * @return
     */
    public static Double RandomGenerate(double lowerBound, double upperBound) {
        Random random = new Random();
        double randomValue = lowerBound + (upperBound - lowerBound) * random.nextDouble();
        DecimalFormat decimalFormat = new DecimalFormat("#.0000");
        return Double.valueOf(decimalFormat.format(randomValue));
    }

    /**
     * 在上下限范围内生成随机数
     * 保留两位
     *
     * @param lowerBound
     * @param upperBound
     * @return
     */
    public static Double RandomGenerate2(double lowerBound, double upperBound) {
        Random random = new Random();
        double randomValue = lowerBound + (upperBound - lowerBound) * random.nextDouble();
        DecimalFormat decimalFormat = new DecimalFormat("#.000");
        return Double.valueOf(decimalFormat.format(randomValue));
    }

    /**
     * 在上下限范围内生成随机数
     *
     * @param lowerBound
     * @param upperBound
     * @return
     */
    public static int RandomGenerate(int lowerBound, int upperBound) {
        Random random = new Random();
        return random.nextInt(upperBound - lowerBound + 1) + lowerBound;
    }

    /**
     * 将一个 object 类型转为 double 类型
     *
     * @param object
     * @return
     */
    public static double convertDouble(Object object) {
        double doubleValue = -1000;
        if (object != null) {
            String stringValue = (String) object;
            if (!stringValue.isEmpty()) {
                try {
                    doubleValue = Double.parseDouble(stringValue);
                } catch (NumberFormatException e) {
                    System.out.println("字符串无法转换为 double 值");
                }
            }
        }
        return doubleValue;
    }

    /**
     * 用于生成 模板 类
     *
     * @param lowerBound
     * @param upperBound
     * @return
     */
    public static String convertString(double lowerBound, double upperBound) {
        Random random = new Random();
        double randomValue = lowerBound + (upperBound - lowerBound) * random.nextDouble();
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        return Double.valueOf(decimalFormat.format(randomValue)) + "0";
    }

    /**
     * 判断两个时间的年月日是否相同
     */
    public static boolean judgeTimeIsSame(String dateString1, String dateString2) {
        // 定义日期时间格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

        // 将字符串解析为 LocalDate 对象（只提取年月日部分）
        LocalDate date1 = LocalDate.parse(dateString1, formatter);
        LocalDate date2 = LocalDate.parse(dateString2, formatter);

        // 判断两个日期是否相同
        return date1.isEqual(date2);
    }

    /**
     * 将原始日期加一天
     *
     * @param oldTime
     * @return
     */
    public static String getCorrectTime(String oldTime) {
        // 定义日期时间格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        // 将字符串解析为 LocalDateTime 对象
        LocalDateTime inputDateTime = LocalDateTime.parse(oldTime, formatter);
        // 加一天
        LocalDateTime nextDay = inputDateTime.plusDays(1);

        // 将结果格式化为字符串
        return nextDay.format(formatter);
    }

    /**
     * 获取当前时间的字符串
     *
     * @return
     */
    public static String getCurrentTimeString() {
        // 获取当前时间
        Date currentDate = new Date();
        // 设置所需的日期格式
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        // 格式化当前时间并输出
        return dateFormat.format(currentDate);
    }

}
