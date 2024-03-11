package com.example.pmp.service.impl.correct.d9x;

import com.example.pmp.mapper.correct.*;
import com.example.pmp.mapper.correct.d9x.*;
import com.example.pmp.pojo.correct.CorrectLog;
import com.example.pmp.pojo.correct.CorrectStatus;
import com.example.pmp.pojo.correct.CorrectTime;
import com.example.pmp.pojo.correct.Specification;
import com.example.pmp.pojo.correct.d9x.*;
import com.example.pmp.service.correct.d9x.CorrectD9XService;
import com.example.pmp.utils.CorrectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * @author Dandan
 * @date 2024/1/18 10:47
 **/

@Service
public class CorrectD9XServiceImpl implements CorrectD9XService {

    @Autowired
    private CorrectStatusMapper correctStatusMapper;

    @Autowired
    private CorrectTimeMapper correctTimeMapper;

    @Autowired
    private SpecificationMapper specificationMapper;

    @Autowired
    private Station1D9XMapper station1Mapper;

    @Autowired
    private Station2D9XMapper station2Mapper;

    @Autowired
    private Station3D9XMapper station3Mapper;

    @Autowired
    private Station41D9XMapper station41Mapper;

    @Autowired
    private Station42D9XMapper station42Mapper;

    @Autowired
    private Station51D9XMapper station51Mapper;

    @Autowired
    private Station52D9XMapper station52Mapper;

    @Autowired
    private CorrectLogMapper correctLogMapper;

    @Autowired
    private CorrectPersonMapper correctPersonMapper;

    /**
     * 设置开始时间
     */
    // String startTime = "2024-03-08 08:00:00.000";
    String startTime = CorrectUtils.getCurrentCorrectStartTime();
    /**
     * 设置结束时间
     */
    // String endTime = "2024-03-10 08:00:00.000";
    String endTime = CorrectUtils.getCurrentCorrectEndTime();
    /**
     * 设置日志的创建时间
     */
    String createTime = CorrectUtils.getCorrectLogD9XCreateTime();

    /**
     * 实际第一站中SN的数据集合
     */
    List<String> station1SNList = new ArrayList<>();
    /**
     * 补正后第四站中FAIL的码(第一版)
     */
    List<String> station41FailSNList = new ArrayList<>();
    /**
     * 补正后第四站中PASS的码(第一版)
     */
    List<String> station41PassNList = new ArrayList<>();
    /**
     * 补正后第四站中FAIL的码(第二版)
     */
    List<String> station42FailSNList = new ArrayList<>();
    /**
     * 补正后第四站中PASS的码(第二版)
     */
    List<String> station42PassNList = new ArrayList<>();

    /**
     * 补正数据
     */
    @Override
    public void startCurrentData() throws IllegalAccessException {
        // System.out.println("开始时间：" + startTime);
        // System.out.println("结束时间：" + endTime);
        // System.out.println("日志创建时间：" + createTime);
        startD9XCurrentData();
    }

    /**
     * 补正数据
     *
     * @param
     */
    @Transactional
    // D9X 每天 21 点执行
    @Scheduled(cron = "0 0 21 * * *")
    public void CurrentData() throws IllegalAccessException {
        // System.out.println("每天 21 点开始执行");
        startD9XCurrentData();
    }

    private void startD9XCurrentData() throws IllegalAccessException {
        String project = "D9X";
        Specification specification = new Specification();
        specification.setProject(project);
        // getCorrectTime(project);
        // 专案
        String pid = specification.getProject();
        // 查询所有需要补正的站点
        List<CorrectStatus> correctStatusList = getCorrectStatusList(pid);
        // 有几站循环几次
        for (CorrectStatus correctStatus : correctStatusList) {
            if (correctStatus.getComplete() == 0) {
                // 未完成
                if (Objects.equals(correctStatus.getName(), "STATION1")) {
                    // 补正第一站(良率100%)
                    currentStation1();
                } else if (Objects.equals(correctStatus.getName(), "STATION2")) {
                    // 补正第二站(良率100%)
                    currentStation2(correctStatus.getModule());
                } else if (Objects.equals(correctStatus.getName(), "STATION3")) {
                    // 补正第三站(良率100%)
                    currentStation3(specification, correctStatus.getModule(), correctStatus.getStation(), correctStatus.getLid());
                } else if (Objects.equals(correctStatus.getName(), "STATION41")) {
                    // 补正第四站(第一版)
                    currentStation41(specification, correctStatus.getModule(), correctStatus.getStation(), correctStatus.getLid());
                } else if (Objects.equals(correctStatus.getName(), "STATION42")) {
                    // 补正第四站(第二版)
                    currentStation42(specification, correctStatus.getModule(), correctStatus.getStation(), correctStatus.getLid());
                } else if (Objects.equals(correctStatus.getName(), "STATION51")) {
                    // 补正第五站(第一版)
                    currentStation51(specification, correctStatus.getModule(), correctStatus.getStation(), correctStatus.getLid());
                } else {
                    // 补正第五站(第二版)
                    currentStation52(specification, correctStatus.getModule(), correctStatus.getStation(), correctStatus.getLid());
                }
            }
            // 一个Station补正完了，更新状态
            correctStatus.setComplete(1);
            correctStatusMapper.updateCorrectStatusByName(correctStatus);
        }
        // 全部补正完，将所有的状态更新为0，以便后续再次补正
        correctStatusMapper.updateCorrectStatus(pid);
        // 补完之后，发送企业微信通知
        sendMessage(pid, startTime, endTime, createTime);
    }

    /**
     * 获取补正开始时间及结束时间
     */
    private void getCorrectTime(String Product) {
        CorrectTime correctTime = correctTimeMapper.getCorrectTimeByProduct(Product);
        if (!CorrectUtils.judgeTimeIsSame(CorrectUtils.getCurrentTimeString(), correctTime.getEndTime())) {
            // 不相等加一，并更新
            correctTime.setStartTime(CorrectUtils.getCorrectTime(correctTime.getStartTime()));
            correctTime.setEndTime(CorrectUtils.getCorrectTime(correctTime.getEndTime()));
            correctTimeMapper.updateCorrectTime(correctTime);
        }
        startTime = correctTime.getStartTime();
        endTime = correctTime.getEndTime();
    }


    /**
     * 发送企业微信消息
     */
    private void sendMessage(String project, String startTime, String endTime, String createTime) {

        // 根据专案获取负责人列表
        List<String> personList = correctPersonMapper.selectCorrectPersonListByProject(project);
        // 根据时间和专案获取补正日志集合
        List<CorrectLog> correctLogList = correctLogMapper.selectCorrectLogListByTime(project, startTime, endTime, createTime);

        CorrectUtils.sendMessage(personList, correctLogList);
    }

    /**
     * 补正第五站(第二版)
     */
    private void currentStation52(Specification specification, String module, String station, String lid) throws IllegalAccessException {
        List<String> station52SNList = station52Mapper.getStation52SNList(startTime, endTime);
        List<Station52D9X> station52List = station52Mapper.getStation52ListByTime(startTime, endTime);

        // 第五站应该先去掉第四站中没有的码
        station52List = station52List.stream().filter(station1 -> station42PassNList.contains(station1.getBarcode())).collect(Collectors.toList());
        station52SNList = station52SNList.stream().filter(s -> station42PassNList.contains(s)).collect(Collectors.toList());

        // 第五站应该先把第四站中FAIL的码去掉
        station52List = station52List.stream().filter(station1 -> !station42FailSNList.contains(station1.getBarcode())).collect(Collectors.toList());
        station52SNList = station52SNList.stream().filter(s -> !station42FailSNList.contains(s)).collect(Collectors.toList());

        if (station42PassNList.size() > station52SNList.size()) {
            // 跟第四站PASS的码数量不相同才将第四站PASS的码补到第五站
            for (String s : station42PassNList) {
                if (!station52SNList.contains(s)) {
                    Station52D9X station52 = Station52D9X.getTemplate();
                    station52.setBarcode(s);
                    // 测试时间设置
                    Station42D9X station4 = station42Mapper.getStation42BySN(startTime, endTime, s);
                    if (station4 != null) {
                        station52.setLineID(station4.getLineID());
                        station52.setLineType(station4.getLineType());
                        station52.setModuleID(module);
                        station52.setTestTime(CorrectUtils.addMilliseconds(station4.getTestTime(), 200));
                    }
                    station52List.add(station52);
                }
            }
        }

        specification.setStation(station);
        specification.setLineName(lid);
        // 获取第五站的需要补正的数据(hashMap)
        HashMap<String, List<Object>> station52Map = getNeedCorrectStationMap(station52List);
        // 获取第五站规格数据
        List<Specification> specification52List = getSpecificationList(specification);
        // 开始补正(hashMap)
        getCurrentAfterSpecHashMap(specification52List, station52Map);
        // 将hashMap转为List集合
        station52List = CorrectUtils.getCurrentStationAfterSpecList(station52Map, Station52D9X.class);
        // 将补正好的数据插入数据库(在插入之前还要做一件事，就是将规格内的数据的测试结果进行更正)，并插入到补正后的表里
        setStation52Result(station52List, specification52List);
    }

    /**
     * 设置第五站结果(第二版)
     */
    private void setStation52Result(List<Station52D9X> station52List, List<Specification> specification52List) throws IllegalAccessException {
        for (Station52D9X station5 : station52List) {
            String result = "FAIL";
            int goodCount = 0;
            for (Specification specification : specification52List) {
                String itemKey = specification.getItemKey();
                double upper = specification.getUpper();
                double lower = specification.getLower();
                if (CorrectUtils.hasField(station5, itemKey)) {
                    double value = CorrectUtils.convertDouble(CorrectUtils.getFieldValue(station5, itemKey));
                    if (value >= lower && value <= upper) {
                        goodCount++;
                    }
                }
            }

            if (goodCount == specification52List.size()) {
                result = "PASS";
            }
            station5.setTestResult(result);
            station52Mapper.insertStation52(station5);
        }
    }

    /**
     * 补正第五站(第一版)
     * 第五站中绝不可能出现第四站FAIL的码
     */
    private void currentStation51(Specification specification, String module, String station, String lid) throws IllegalAccessException {
        List<String> station51SNList = station51Mapper.getStation51SNList(startTime, endTime);
        List<Station51D9X> station51List = station51Mapper.getStation51ListByTime(startTime, endTime);

        // 第五站应该先去掉第四站PASS码中没有的码
        // 第四站PASS才能留到第五站
        station51List = station51List.stream().filter(station1 -> station41PassNList.contains(station1.getBarcode())).collect(Collectors.toList());
        station51SNList = station51SNList.stream().filter(s -> station41PassNList.contains(s)).collect(Collectors.toList());

        // 再去掉第四站中FAIL的码
        station51List = station51List.stream().filter(station1 -> !station41FailSNList.contains(station1.getBarcode())).collect(Collectors.toList());
        station51SNList = station51SNList.stream().filter(s -> !station41FailSNList.contains(s)).collect(Collectors.toList());

        if (station41PassNList.size() > station51SNList.size()) {
            // 跟第四站PASS的码数量不相同才将第四站PASS的码补到第五站
            for (String s : station41PassNList) {
                if (!station51SNList.contains(s)) {
                    Station51D9X station51 = Station51D9X.getTemplate();
                    station51.setBarcode(s);
                    // 测试时间设置
                    Station41D9X station4 = station41Mapper.getStation41BySN(startTime, endTime, s);
                    if (station4 != null) {
                        station51.setLineID(station4.getLineID());
                        station51.setLineType(station4.getLineType());
                        station51.setModuleID(module);
                        station51.setTestTime(CorrectUtils.addMilliseconds(station4.getTestTime(), 200));
                    }
                    station51List.add(station51);
                }
            }
        }

        specification.setStation(station);
        specification.setLineName(lid);
        // 获取第五站的需要补正的数据(hashMap)
        HashMap<String, List<Object>> station51Map = getNeedCorrectStationMap(station51List);
        // 获取第五站规格数据
        List<Specification> specification51List = getSpecificationList(specification);
        // 开始补正(hashMap)
        getCurrentAfterSpecHashMap(specification51List, station51Map);
        // 将hashMap转为List集合
        station51List = CorrectUtils.getCurrentStationAfterSpecList(station51Map, Station51D9X.class);
        // 将补正好的数据插入数据库(在插入之前还要做一件事，就是将规格内的数据的测试结果进行更正)，并插入到补正后的表里
        setStation51Result(station51List, specification51List);
    }

    /**
     * 设置第五站结果(第一版)
     */
    private void setStation51Result(List<Station51D9X> station51List, List<Specification> specification51List) throws IllegalAccessException {
        for (Station51D9X station5 : station51List) {
            String result = "FAIL";
            int goodCount = 0;
            for (Specification specification : specification51List) {
                String itemKey = specification.getItemKey();
                double upper = specification.getUpper();
                double lower = specification.getLower();
                if (CorrectUtils.hasField(station5, itemKey)) {
                    double value = CorrectUtils.convertDouble(CorrectUtils.getFieldValue(station5, itemKey));
                    if (value >= lower && value <= upper) {
                        goodCount++;
                    }
                }
            }

            if (goodCount == specification51List.size()) {
                result = "PASS";
            }
            station5.setTestResult(result);
            station51Mapper.insertStation51(station5);
        }
    }

    /**
     * 补正第四站(第二版)
     */
    private void currentStation42(Specification specification, String module, String station, String lid) throws IllegalAccessException {
        List<String> station42SNList = station42Mapper.getStation42SNList(startTime, endTime);
        List<Station42D9X> station42List = station42Mapper.getStation42ListByTime(startTime, endTime);

        // 应该先去除第一站中没有的码
        station42List = station42List.stream().filter(station1 -> station1SNList.contains(station1.getBarcode())).collect(Collectors.toList());
        station42SNList = station42SNList.stream().filter(s -> station1SNList.contains(s)).collect(Collectors.toList());

        if (station1SNList.size() > station42SNList.size()) {
            // 跟第一站码数量不相同才将第一站的码补到第四站
            for (String s : station1SNList) {
                if (!station42SNList.contains(s)) {
                    Station42D9X station42 = Station42D9X.getTemplate();
                    station42.setBarcode(s);
                    // 测试时间设置
                    Station3D9X station3 = station3Mapper.getStation3BySN(startTime, endTime, s);
                    if (station3 != null) {
                        station42.setLineID(station3.getLineID());
                        station42.setLineType(station3.getLineType());
                        station42.setModuleID(module);
                        station42.setTestTime(CorrectUtils.addMilliseconds(station3.getTestTime(), 200));
                    }
                    station42List.add(station42);
                }
            }
        }

        specification.setStation(station);
        specification.setLineName(lid);
        // 获取第四站的需要补正的数据(hashMap)
        HashMap<String, List<Object>> station42Map = getNeedCorrectStationMap(station42List);
        // 获取第四站规格数据
        List<Specification> specification42List = getSpecificationList(specification);
        // 开始补正(hashMap)
        getCurrentAfterSpecHashMap(specification42List, station42Map);
        // 将hashMap转为List集合
        station42List = CorrectUtils.getCurrentStationAfterSpecList(station42Map, Station42D9X.class);
        // 将补正好的数据插入数据库(在插入之前还要做一件事，就是将规格内的数据的测试结果进行更正)，并插入到补正后的表里
        setStation42Result(station42List, specification42List);
    }

    /**
     * 设置第四站结果(第二版)
     */
    private void setStation42Result(List<Station42D9X> station42List, List<Specification> specification42List) throws IllegalAccessException {
        for (Station42D9X station4 : station42List) {
            String result = "FAIL";
            String SN = station4.getBarcode();
            int goodCount = 0;
            for (Specification specification : specification42List) {
                String itemKey = specification.getItemKey();
                double upper = specification.getUpper();
                double lower = specification.getLower();
                if (CorrectUtils.hasField(station4, itemKey)) {
                    double value = CorrectUtils.convertDouble(CorrectUtils.getFieldValue(station4, itemKey));
                    if (value >= lower && value <= upper) {
                        goodCount++;
                    }
                }
            }

            if (goodCount == specification42List.size()) {
                result = "PASS";
            }
            station4.setTestResult(result);
            if (result.equals("PASS")) {
                station42PassNList.add(SN);
            } else {
                station42FailSNList.add(SN);
            }
            station42Mapper.insertStation42(station4);
        }
    }

    /**
     * 补正第四站(第一版)
     * 第四站的良率不是百分百，有 PASS FAIL
     * 补正后要记录 Station4 中 FAIL 的码的集合
     */
    private void currentStation41(Specification specification, String module, String station, String lid) throws IllegalAccessException {
        List<String> station41SNList = station41Mapper.getStation41SNList(startTime, endTime);
        List<Station41D9X> station41List = station41Mapper.getStation41ListByTime(startTime, endTime);

        // 应该先去除第一站中没有的码
        station41List = station41List.stream().filter(station1 -> station1SNList.contains(station1.getBarcode())).collect(Collectors.toList());
        station41SNList = station41SNList.stream().filter(s -> station1SNList.contains(s)).collect(Collectors.toList());

        if (station1SNList.size() > station41SNList.size()) {
            // 跟第一站码数量不相同才将第一站的码补到第四站
            for (String s : station1SNList) {
                if (!station41SNList.contains(s)) {
                    Station41D9X station41 = Station41D9X.getTemplate();
                    station41.setBarcode(s);
                    // 测试时间设置
                    Station3D9X station3 = station3Mapper.getStation3BySN(startTime, endTime, s);
                    if (station3 != null) {
                        station41.setLineID(station3.getLineID());
                        station41.setLineType(station3.getLineType());
                        station41.setModuleID(module);
                        station41.setTestTime(CorrectUtils.addMilliseconds(station3.getTestTime(), 200));
                    }
                    station41List.add(station41);
                }
            }
        }

        specification.setStation(station);
        specification.setLineName(lid);
        // 获取第三站的需要补正的数据(hashMap)
        HashMap<String, List<Object>> station41Map = getNeedCorrectStationMap(station41List);
        // 获取第三站规格数据
        List<Specification> specification41List = getSpecificationList(specification);
        // 开始补正(hashMap)
        getCurrentAfterSpecHashMap(specification41List, station41Map);
        // 将hashMap转为List集合
        station41List = CorrectUtils.getCurrentStationAfterSpecList(station41Map, Station41D9X.class);
        // 将补正好的数据插入数据库(在插入之前还要做一件事，就是将规格内的数据的测试结果进行更正)，并插入到补正后的表里
        setStation41Result(station41List, specification41List);
    }

    /**
     * 设置第四站结果(第一版)
     */
    private void setStation41Result(List<Station41D9X> station41List, List<Specification> specification41List) throws IllegalAccessException {
        for (Station41D9X station4 : station41List) {
            String result = "FAIL";
            String SN = station4.getBarcode();
            int goodCount = 0;
            for (Specification specification : specification41List) {
                String itemKey = specification.getItemKey();
                double upper = specification.getUpper();
                double lower = specification.getLower();
                if (CorrectUtils.hasField(station4, itemKey)) {
                    double value = CorrectUtils.convertDouble(CorrectUtils.getFieldValue(station4, itemKey));
                    if (value >= lower && value <= upper) {
                        goodCount++;
                    }
                }
            }
            if (goodCount == specification41List.size()) {
                result = "PASS";
            }
            station4.setTestResult(result);
            if (result.equals("PASS")) {
                station41PassNList.add(SN);
            } else {
                station41FailSNList.add(SN);
            }
            station41Mapper.insertStation41(station4);
        }
    }

    /**
     * 补正第三站
     * 第三站有规格，需要将数据补到合理位置后设置结果
     * 第三站的良率目标也是100%
     * 所以补完之后的数据应该全是PASS
     * 但要注意，实际情况是第二站有FAIL，会直接排掉，不会再到第三站测
     * 所以要根据第一站所有的码将第一站排掉的码补到第三站
     */
    private void currentStation3(Specification specification, String module, String station, String lid) {
        List<String> station3SNList = station3Mapper.getStation3SNList(startTime, endTime);
        List<Station3D9X> station3List = station3Mapper.getStation3ListByTime(startTime, endTime);

        // 应该先去除第一站中没有的码
        station3List = station3List.stream().filter(station1 -> station1SNList.contains(station1.getBarcode())).collect(Collectors.toList());
        station3SNList = station3SNList.stream().filter(s -> station1SNList.contains(s)).collect(Collectors.toList());

        if (station1SNList.size() > station3SNList.size()) {
            // 跟第一站码数量不相同才将第一站的码补到第三站
            for (String s : station1SNList) {
                if (!station3SNList.contains(s)) {
                    Station3D9X station3 = Station3D9X.getTemplate();
                    station3.setBarcode(s);
                    // 测试时间设置
                    Station2D9X station2 = station2Mapper.getStation2BySN(startTime, endTime, s);
                    if (station2 != null) {
                        station3.setLineID(station2.getLineID());
                        station3.setLineType(station2.getLineType());
                        station3.setModuleID(module);
                        station3.setTestTime(CorrectUtils.addMilliseconds(station2.getTestTime(), 200));
                    }
                    station3List.add(station3);
                }
            }
        }

        specification.setStation(station);
        specification.setLineName(lid);
        // 获取第三站的需要补正的数据(hashMap)
        HashMap<String, List<Object>> station3Map = getNeedCorrectStationMap(station3List);
        // 获取第三站规格数据
        List<Specification> specification3List = getSpecificationList(specification);
        // 开始补正(hashMap)
        getCurrentAfterSpecHashMap(specification3List, station3Map);
        // 将hashMap转为List集合
        station3List = CorrectUtils.getCurrentStationAfterSpecList(station3Map, Station3D9X.class);
        // 将补正好的数据插入数据库(在插入之前还要做一件事，就是将规格内的数据的测试结果进行更正)，并插入到补正后的表里
        setStation3Result(station3List);
    }

    /**
     * 设置第三站的结果
     * 第三站有规格
     * 良率为100%
     * 将所有的Fail改为Pass
     *
     * @param station3List
     */
    private void setStation3Result(List<Station3D9X> station3List) {
        // 还是要设置测试结果，虽然模版中设置了，但是原来的数据里可能存在FAIL
        station3List.stream().peek(station3D9X -> station3D9X.setTestResult("PASS")).forEach(station3Mapper::insertStation3);
    }

    /**
     * 补正 D9X 第二站
     * 第二站没有规格
     * OK	NG需要改成OK
     * OK	NG需要改成OK
     * PASS	FAIL改为PASS
     */
    private void currentStation2(String module) {
        List<String> station2SNList = station2Mapper.getStation2SNList(startTime, endTime);
        List<Station2D9X> station2List = station2Mapper.getStation2ListByTime(startTime, endTime);

        // 应该先去除第一站中没有的码
        station2List = station2List.stream().filter(station -> station1SNList.contains(station.getBarcode())).collect(Collectors.toList());
        station2SNList = station2SNList.stream().filter(s -> station1SNList.contains(s)).collect(Collectors.toList());

        if (station1SNList.size() > station2SNList.size()) {
            // 跟第一站码数量不相同才将第一站的码补到第二站
            for (String s : station1SNList) {
                if (!station2SNList.contains(s)) {
                    Station2D9X station2 = Station2D9X.getTemplate();
                    station2.setBarcode(s);
                    // 测试时间的设置
                    // 比上一站测试时间多 100ms/200ms，这一站存在的码，在上一站一定有
                    // 要在补正表里捞取
                    Station1D9X station1 = station1Mapper.getStation1BySN(startTime, endTime, s);
                    if (station1 != null) {
                        station2.setLineID(station1.getLineID());
                        station2.setLineType(station1.getLineType());
                        station2.setModuleID(module);
                        station2.setTestTime(CorrectUtils.addMilliseconds(station1.getTestTime(), 200));
                    }
                    station2List.add(station2);
                }
            }
        }
        // 将补正好的数据插入数据库
        setStation2Result(station2List);
    }

    /**
     * 设置第二站的结果
     * 第二站没有规格
     * OK	NG需要改成OK
     * OK	NG需要改成OK
     * PASS	FAIL改为PASS
     */
    private void setStation2Result(List<Station2D9X> station2List) {
        // peek()方法设置结果
        station2List.stream().peek(station2 -> {
            station2.setOpen_Result("OK");
            station2.setOS_HIPOT_Test("OK");
            station2.setTestResult("PASS");
        }).forEach(station2Mapper::insertStation2);
    }

    /**
     * 补正 D9X 第一站
     * 第一站没有规格
     * DEF 需要改成 C
     * NG 需要改成 OK
     * FAIL 改为 PASS
     */
    private void currentStation1() {
        // 第一站是最全的码
        // 过滤掉 ERROR \u0000 ????
        station1SNList = station1Mapper.getStation1SNList(startTime, endTime);
        List<Station1D9X> station1List = station1Mapper.getStation1ListByTime(startTime, endTime);
        // 将补正好的数据插入到数据库(将 DEF 需要改成 C，NG 需要改成 OK，FAIL 改为 PASS)
        setStation1Result(station1List);
    }

    /**
     * 设置第一站的结果
     * DEF 需要改成 C
     * NG 需要改成 OK
     * FAIL 改为 PASS
     *
     * @param station1List
     */
    private void setStation1Result(List<Station1D9X> station1List) {
        for (Station1D9X station1 : station1List) {
            station1.setTestResult("PASS");
            station1.setBarcode_Result("OK");
            if (station1.getLASER_ETCH_BARCODE().equals("D") || station1.getLASER_ETCH_BARCODE().equals("E") || station1.getLASER_ETCH_BARCODE().equals("F")) {
                station1.setLASER_ETCH_BARCODE("C");
            }
            station1Mapper.insertStation1(station1);
        }
    }

    /**
     * 查询所有补正站点的集合
     *
     * @return
     */
    private List<CorrectStatus> getCorrectStatusList(String pid) {
        return correctStatusMapper.getCorrectStatusList(pid);
    }

    /**
     * 获取需要补正的站点数据的 HashMap
     *
     * @return
     */
    private <T> HashMap<String, List<Object>> getNeedCorrectStationMap(List<T> dataList) {
        return CorrectUtils.getNeedCorrectMap(dataList);
    }

    /**
     * 获取规格集合
     *
     * @param specification
     * @return
     */
    private List<Specification> getSpecificationList(Specification specification) {
        List<Specification> specificationList = specificationMapper.getSpecList(specification);
        String oldStr = "-";
        String newStr = "_";
        String Str1 = "Scan";
        if (specification.getStation().equals("STATION4")) {
            for (Specification spec : specificationList) {
                String itemKey = spec.getItemKey();
                // 只有在字符串中包含 "-" 符号时才进行替换操作
                if (itemKey.contains(oldStr)) {
                    itemKey = itemKey.replace(oldStr, newStr);
                }
                spec.setItemKey(itemKey);
            }
        } else if (specification.getStation().equals("STATION5")) {
            for (Specification spec : specificationList) {
                String itemKey = spec.getItemKey();
                // 只有在字符串中包含 "-" 符号时才进行替换操作
                if (itemKey.contains(oldStr)) {
                    itemKey = itemKey.replace(oldStr, newStr);
                    // 如果字符串中包含Scan，还要再截掉 3D
                    if (itemKey.contains(Str1)) {
                        itemKey = itemKey.substring(3);
                    }
                }
                spec.setItemKey(itemKey);
            }
        }
        return specificationList;
    }

    /**
     * 根据传入的需要补正的数据和对应的规格数据开始补正
     * 根据规格数据创建线程池，每个规格相互独立
     *
     * @param specificationList
     * @param needCorrectMap
     * @return
     */
    private HashMap<String, List<Object>> getCurrentAfterSpecHashMap(List<Specification> specificationList, HashMap<String, List<Object>> needCorrectMap) {
        ExecutorService executor = Executors.newFixedThreadPool(specificationList.size());
        // 根据规格数量初始化CountDownLatch
        CountDownLatch latch = new CountDownLatch(specificationList.size());
        for (Specification spec : specificationList) {
            executor.submit(() -> {
                try {
                    String Name = spec.getItemKey();
                    double yieldLower = spec.getTargetYieldL();
                    double yieldUpper = spec.getTargetYieldU();
                    double spaceLower = spec.getLower();
                    double spaceUpper = spec.getUpper();
                    double targetYield = CorrectUtils.RandomGenerate(yieldLower, yieldUpper);
                    if (needCorrectMap.containsKey(Name)) {
                        List<Object> objects = needCorrectMap.get(Name);
                        // 开始补正
                        try {
                            Current(objects, spaceLower, spaceUpper, targetYield, spec, Name);
                            // 保存补正数据
                            needCorrectMap.put(Name, objects);
                        } catch (Exception e) {
                            // 处理异常
                            e.printStackTrace();
                        }
                    }
                } finally {
                    // 线程执行完毕后，递减倒计数器
                    latch.countDown();
                }
            });
        }

        try {
            // 等待所有线程执行完毕
            latch.await();
        } catch (InterruptedException e) {
            // 处理异常
        }

        executor.shutdown(); // 关闭线程池

        return needCorrectMap;
    }

    /**
     * 根据规格上下限补正数据
     * 补正每一个字段
     *
     * @param objects
     * @param specLower
     * @param specUpper
     */
    private void Current(List<Object> objects, double specLower, double specUpper, double targetYield, Specification spec, String Name) {
        if (objects.size() > 0) {
            int goodCount = 0;
            // 记录非良品索引
            List<Integer> indexList = new ArrayList<>();
            int currentIndex = 0;
            for (Object object : objects) {
                double value = CorrectUtils.convertDouble(object);
                if (value >= specLower && value <= specUpper) {
                    goodCount++;
                } else {
                    // 如果 objects 列表中存在重复的数值，indexOf() 方法将返回第一个匹配到的索引，会导致索引重复的情况
                    // indexList.add(objects.indexOf(object));
                    indexList.add(currentIndex);
                }
                currentIndex++;
            }

            // 计算目前良率
            double currentYield = (double) goodCount / (double) objects.size();
            BigDecimal yield = new BigDecimal(currentYield);
            // 设置每个规格需要补正的数量(向上取整)
            int needCorrectNumber = (int) Math.ceil(objects.size() * targetYield - goodCount);

            if (currentYield < targetYield) {
                // 开始补正
                for (int j = 0; j < needCorrectNumber; j++) {
                    int place = 0;
                    if (indexList.size() > 1) {
                        place = CorrectUtils.RandomGenerate(0, indexList.size() - 1);
                    }
                    int index = indexList.get(place);
                    indexList.remove(place);
                    objects.set(index, CorrectUtils.RandomGenerate2(specLower, specUpper).toString());
                }
            }

            // 每补正完一个字段，开始记录日志
            CorrectLog correctLog = new CorrectLog();
            correctLog.setProject(spec.getProject());
            correctLog.setLineType(spec.getLineType());
            correctLog.setLineName(spec.getLineName());
            correctLog.setEquName(spec.getEquName());
            correctLog.setStation(spec.getStation());
            // 注意：log记录里面的 itemkey 要进行处理，将_改为-，3D 要加上
            correctLog.setItemKey(CorrectUtils.getCurrentString(Name));
            correctLog.setStartTime(startTime);
            correctLog.setEndTime(endTime);
            correctLog.setDataCount(objects.size());
            correctLog.setBeforeGoodCount(goodCount);
            correctLog.setBeforeYield(yield);
            correctLog.setAfterGoodCount(goodCount + needCorrectNumber);
            BigDecimal dividend = new BigDecimal(goodCount).add(new BigDecimal(needCorrectNumber));
            BigDecimal divisor = new BigDecimal(objects.size());
            BigDecimal result = dividend.divide(divisor, 5, RoundingMode.HALF_UP);
            correctLog.setAfterYield(result);
            correctLogMapper.insertCorrectLog(correctLog);
        }

    }

}
