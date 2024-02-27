package com.example.pmp.service.impl.component;

import com.example.pmp.mapper.component.D4Y.*;
import com.example.pmp.pojo.component.ComponentFAI;
import com.example.pmp.pojo.component.D4Y.*;
import com.example.pmp.pojo.component.dto.ComponentParam;
import com.example.pmp.service.component.ComponentD4YService;
import com.example.pmp.utils.ComponentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author Dandan
 * @date 2024/2/22 10:40
 **/
@Service
public class ComponentD4YServiceImpl implements ComponentD4YService {

    @Autowired
    private D4YMainLine3M10Mapper d4YMainLine3M10Mapper;

    @Autowired
    private D4YMainLine3M6Mapper d4YMainLine3M6Mapper;

    @Autowired
    private D4YMainLine1M2Mapper d4YMainLine1M2Mapper;

    @Autowired
    private D4YSubLine2M1Mapper d4YSubLine2M1Mapper;

    @Autowired
    private D4YSubLine2M4Mapper d4YSubLine2M4Mapper;

    @Autowired
    private D4YSubLine1M6Mapper d4YSubLine1M6Mapper;

    @Autowired
    private D4YSubLine1M1Mapper d4YSubLine1M1Mapper;

    @Autowired
    private D4YOffLine8M13DMapper d4YOffLine8M13DMapper;

    @Autowired
    private D4YOffLine9M13DMapper d4YOffLine9M13DMapper;

    @Autowired
    private D4YOffLine10M13DMapper d4YOffLine10M13DMapper;

    @Autowired
    private D4YOffLine11M13DMapper d4YOffLine11M13DMapper;

    @Autowired
    private D4YSubLine2M3Mapper d4YSubLine2M3Mapper;

    @Autowired
    private D4YOffLine8M1AOI3Mapper d4YOffLine8M1AOI3Mapper;

    @Autowired
    private D4YOffLine9M1AOI3Mapper d4YOffLine9M1AOI3Mapper;

    @Autowired
    private D4YOffLine10M12DMapper d4YOffLine10M12DMapper;

    @Autowired
    private D4YOffLine11M12DMapper d4YOffLine11M12DMapper;

    /**
     * Barcode
     */
    List<String> BarCodeList;
    /**
     * Barcode_HSG
     */
    List<String> BarcodeHSGList;
    /**
     * Barcode_EMI
     */
    List<String> BarcodeEMIList;
    /**
     * Barcode_MidPlate
     */
    List<String> BarcodeMidPlateList;
    /**
     * UpperContactIM_Reel_LOT
     */
    List<String> UpperContactIMReelLOTList;
    /**
     * LowerContactIM_Reel_LOT
     */
    List<String> LowerContactIMReelLOTList;

    @Override
    public List<ComponentFAI> selectComponentFAIData(ComponentParam componentParam) {
        List<ComponentFAI> componentFAIList = new ArrayList<>();

        String startTime = componentParam.getStartTime();
        String endTime = componentParam.getEndTime();
        String type = componentParam.getType();
        // 按照顺序添加成为键值对
        LinkedHashMap<String, List<String>> partMap = new LinkedHashMap<>();

        BarCodeList = getBarCodeList(startTime, endTime);
        BarcodeHSGList = getBarcodeHSGList(BarCodeList);
        BarcodeEMIList = getBarcodeEMIList(BarcodeHSGList);
        BarcodeMidPlateList = getBarcodeMidPlateList(BarcodeEMIList);
        UpperContactIMReelLOTList = getUpperContactIMReelLOTList(BarcodeMidPlateList);
        LowerContactIMReelLOTList = getLowerContactIMReelLOTList(BarcodeMidPlateList);

        switch (type) {
            case "TPZ": {
                List<String> OffLine8M13DStampingLotList = getOffLine8M13DStampingLotList(UpperContactIMReelLOTList);
                List<String> OffLine9M13DStampingLotList = getOffLine9M13DStampingLotList(UpperContactIMReelLOTList);

                List<D4YMainLine3M10TPZ> d4YMainLine3M10TPZ = getMainLine3M10TPZList(startTime, endTime);
                List<D4YSubLine2M4> d4YSubLine2M4 = getSubLine2M4List(BarcodeEMIList);
                List<D4YSubLine1M6TPZ> d4YSubLine1M6TPZ = getSubLine1M6TPZList(BarcodeMidPlateList);
                List<D4YOffLine8M13D> d4YOffLine8M13D = getOffLine8M13DList(UpperContactIMReelLOTList);
                List<D4YOffLine9M13D> d4YOffLine9M13D = getD4YOffLine9M13DList(LowerContactIMReelLOTList);
                List<D4YOffLine10M13D> d4YOffLine10M13D = getD4YOffLine10M13DList(OffLine8M13DStampingLotList);
                List<D4YOffLine11M13D> d4YOffLine11M13D = getD4YOffLine11M13DList(OffLine9M13DStampingLotList);

                partMap.putAll(ComponentUtils.getFAIDataMap(d4YOffLine11M13D));
                partMap.putAll(ComponentUtils.getFAIDataMap(d4YOffLine10M13D));
                partMap.putAll(ComponentUtils.getFAIDataMap(d4YOffLine9M13D));
                partMap.putAll(ComponentUtils.getFAIDataMap(d4YOffLine8M13D));
                partMap.putAll(ComponentUtils.getFAIDataMap(d4YSubLine1M6TPZ));
                partMap.putAll(ComponentUtils.getFAIDataMap(d4YSubLine2M4));
                partMap.putAll(ComponentUtils.getFAIDataMap(d4YMainLine3M10TPZ));
                break;
            }
            case "TPX": {
                List<String> OffLine8M1AOI3StampingLotList = getOffLine8M1AOI3StampingLotList(UpperContactIMReelLOTList);
                List<String> OffLine9M1AOI3StampingLotList = getD4YOffLine9M1AOI3StampingLotList(LowerContactIMReelLOTList);

                List<D4YMainLine3M10TPX> d4YMainLine3M10TPX = getD4YMainLine3M10TPXList(startTime, endTime);
                List<D4YSubLine2M3TPX> d4YSubLine2M3TPX = getD4YSubLine2M3TPXList(BarcodeEMIList);
                List<D4YSubLine1M6TPX> d4YSubLine1M6TPX = getD4YSubLine1M6TPXList(BarcodeMidPlateList);
                List<D4YOffLine8M1AOI3> d4YOffLine8M1AOI3 = getD4YOffLine8M1AOI3List(UpperContactIMReelLOTList);
                List<D4YOffLine9M1AOI3> d4YOffLine9M1AOI3 = getD4YOffLine9M1AOI3List(LowerContactIMReelLOTList);
                List<D4YOffLine10M12D> d4YOffLine10M12D = getD4YOffLine10M12DList(OffLine8M1AOI3StampingLotList);
                List<D4YOffLine11M12D> d4YOffLine11M12D = getD4YOffLine11M12DList(OffLine9M1AOI3StampingLotList);

                partMap.putAll(ComponentUtils.getFAIDataMap(d4YOffLine11M12D));
                partMap.putAll(ComponentUtils.getFAIDataMap(d4YOffLine10M12D));
                partMap.putAll(ComponentUtils.getFAIDataMap(d4YOffLine9M1AOI3));
                partMap.putAll(ComponentUtils.getFAIDataMap(d4YOffLine8M1AOI3));
                partMap.putAll(ComponentUtils.getFAIDataMap(d4YSubLine1M6TPX));
                partMap.putAll(ComponentUtils.getFAIDataMap(d4YSubLine2M3TPX));
                partMap.putAll(ComponentUtils.getFAIDataMap(d4YMainLine3M10TPX));
                break;
            }
            case "TPY": {
                List<D4YMainLine3M10TPY> d4YMainLine3M10TPY = getD4YMainLine3M10TPYList(startTime, endTime);
                List<D4YSubLine2M3TPY> d4YSubLine2M3TPY = getD4YSubLine2M3TPYList(BarcodeEMIList);
                List<D4YSubLine1M6TPY> d4YSubLine1M6TPY = getD4YSubLine1M6TPYList(BarcodeMidPlateList);

                partMap.putAll(ComponentUtils.getFAIDataMap(d4YSubLine1M6TPY));
                partMap.putAll(ComponentUtils.getFAIDataMap(d4YSubLine2M3TPY));
                partMap.putAll(ComponentUtils.getFAIDataMap(d4YMainLine3M10TPY));
            }
        }

        // forEachOrdered 保持顺序，依次处理
        partMap.entrySet().stream().forEachOrdered(entry -> {
            List<String> dataStringList = entry.getValue();
            List<BigDecimal> dataList = ComponentUtils.StringChangeDecimalList(dataStringList);
            ComponentFAI componentFAI = ComponentUtils.getFAIData(dataList);
            componentFAI.setName(entry.getKey());
            componentFAIList.add(componentFAI);
        });

        return componentFAIList;
    }

    /**
     * 获取 D4YSubLine1M6TPY FAI 数据集合
     *
     * @param BarcodeMidPlateList
     * @return
     */
    public List<D4YSubLine1M6TPY> getD4YSubLine1M6TPYList(List<String> BarcodeMidPlateList) {
        List<D4YSubLine1M6TPY> d4YSubLine1M6TPY = new ArrayList<>();
        if (BarcodeMidPlateList.size() > 0) {
            // 每批次的大小
            int batchSize = 2000;
            int totalSize = BarcodeMidPlateList.size();
            for (int i = 0; i < totalSize; i += batchSize) {
                // 防止最后一批不足 batchSize 个
                int endIndex = Math.min(i + batchSize, totalSize);
                List<String> batch = BarcodeMidPlateList.subList(i, endIndex);
                d4YSubLine1M6TPY.addAll(d4YSubLine1M6Mapper.getD4YSubLine1M6TPYList(batch));
            }
        }
        return d4YSubLine1M6TPY;
    }

    /**
     * 获取 D4YSubLine2M3TPY FAI 数据集合
     *
     * @param BarcodeEMIList
     * @return
     */
    public List<D4YSubLine2M3TPY> getD4YSubLine2M3TPYList(List<String> BarcodeEMIList) {
        List<D4YSubLine2M3TPY> d4YSubLine2M3TPY = new ArrayList<>();
        if (BarcodeEMIList.size() > 0) {
            // 每批次的大小
            int batchSize = 2000;
            int totalSize = BarcodeEMIList.size();
            for (int i = 0; i < totalSize; i += batchSize) {
                // 防止最后一批不足 batchSize 个
                int endIndex = Math.min(i + batchSize, totalSize);
                List<String> batch = BarcodeEMIList.subList(i, endIndex);
                d4YSubLine2M3TPY.addAll(d4YSubLine2M3Mapper.getD4YSubLine2M3TPYList(batch));
            }
        }
        return d4YSubLine2M3TPY;
    }

    /**
     * 根据时间筛选 D4YMainLine3M10TPY FAI 数据集合
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public List<D4YMainLine3M10TPY> getD4YMainLine3M10TPYList(String startTime, String endTime) {
        return d4YMainLine3M10Mapper.getD4YMainLine3M10TPYList(startTime, endTime);
    }

    /**
     * 获取 D4YSubLine1M6TPX FAI 数据集合
     *
     * @param BarcodeMidPlateList
     * @return
     */
    public List<D4YSubLine1M6TPX> getD4YSubLine1M6TPXList(List<String> BarcodeMidPlateList) {
        List<D4YSubLine1M6TPX> d4YSubLine1M6TPX = new ArrayList<>();
        if (BarcodeMidPlateList.size() > 0) {
            // 每批次的大小
            int batchSize = 2000;
            int totalSize = BarcodeMidPlateList.size();
            for (int i = 0; i < totalSize; i += batchSize) {
                // 防止最后一批不足 batchSize 个
                int endIndex = Math.min(i + batchSize, totalSize);
                List<String> batch = BarcodeMidPlateList.subList(i, endIndex);
                d4YSubLine1M6TPX.addAll(d4YSubLine1M6Mapper.getD4YSubLine1M6TPXList(batch));
            }
        }
        return d4YSubLine1M6TPX;
    }

    /**
     * 获取 D4YOffLine11M12D FAI 数据集合
     *
     * @param OffLine9M1AOI3StampingLotList
     * @return
     */
    public List<D4YOffLine11M12D> getD4YOffLine11M12DList(List<String> OffLine9M1AOI3StampingLotList) {
        List<D4YOffLine11M12D> d4YOffLine11M12D = new ArrayList<>();
        if (OffLine9M1AOI3StampingLotList.size() > 0) {
            // 每批次的大小
            int batchSize = 2000;
            int totalSize = OffLine9M1AOI3StampingLotList.size();
            for (int i = 0; i < totalSize; i += batchSize) {
                // 防止最后一批不足 batchSize 个
                int endIndex = Math.min(i + batchSize, totalSize);
                List<String> batch = OffLine9M1AOI3StampingLotList.subList(i, endIndex);
                d4YOffLine11M12D.addAll(d4YOffLine11M12DMapper.getD4YOffLine11M12DList(batch));
            }
        }
        return d4YOffLine11M12D;
    }

    /**
     * 获取 D4YOffLine10M12D FAI 数据集合
     *
     * @param OffLine8M1AOI3StampingLotList
     * @return
     */
    public List<D4YOffLine10M12D> getD4YOffLine10M12DList(List<String> OffLine8M1AOI3StampingLotList) {
        List<D4YOffLine10M12D> d4YOffLine10M12D = new ArrayList<>();
        if (OffLine8M1AOI3StampingLotList.size() > 0) {
            // 每批次的大小
            int batchSize = 2000;
            int totalSize = OffLine8M1AOI3StampingLotList.size();
            for (int i = 0; i < totalSize; i += batchSize) {
                // 防止最后一批不足 batchSize 个
                int endIndex = Math.min(i + batchSize, totalSize);
                List<String> batch = OffLine8M1AOI3StampingLotList.subList(i, endIndex);
                d4YOffLine10M12D.addAll(d4YOffLine10M12DMapper.getD4YOffLine10M12DList(batch));
            }
        }
        return d4YOffLine10M12D;
    }

    /**
     * 获取 D4YOffLine9M1AOI3 FAI 数据集合
     *
     * @param LowerContactIMReelLOTList
     * @return
     */
    public List<D4YOffLine9M1AOI3> getD4YOffLine9M1AOI3List(List<String> LowerContactIMReelLOTList) {
        List<D4YOffLine9M1AOI3> d4YOffLine9M1AOI3 = new ArrayList<>();
        if (LowerContactIMReelLOTList.size() > 0) {
            // 每批次的大小
            int batchSize = 2000;
            int totalSize = LowerContactIMReelLOTList.size();
            for (int i = 0; i < totalSize; i += batchSize) {
                // 防止最后一批不足 batchSize 个
                int endIndex = Math.min(i + batchSize, totalSize);
                List<String> batch = LowerContactIMReelLOTList.subList(i, endIndex);
                d4YOffLine9M1AOI3.addAll(d4YOffLine9M1AOI3Mapper.getD4YOffLine9M1AOI3List(batch));
            }
        }
        return d4YOffLine9M1AOI3;
    }

    /**
     * 获取 D4YOffLine9M1AOI3 StampingLot 数据集合
     *
     * @param LowerContactIMReelLOTList
     * @return
     */
    public List<String> getD4YOffLine9M1AOI3StampingLotList(List<String> LowerContactIMReelLOTList) {
        List<String> OffLine9M1AOI3StampingLotList = new ArrayList<>();
        if (LowerContactIMReelLOTList.size() > 0) {
            // 每批次的大小
            int batchSize = 2000;
            int totalSize = LowerContactIMReelLOTList.size();
            for (int i = 0; i < totalSize; i += batchSize) {
                // 防止最后一批不足 batchSize 个
                int endIndex = Math.min(i + batchSize, totalSize);
                List<String> batch = LowerContactIMReelLOTList.subList(i, endIndex);
                OffLine9M1AOI3StampingLotList.addAll(d4YOffLine9M1AOI3Mapper.getD4YOffLine9M1AOI3StampingLotList(batch));
            }
        }
        return OffLine9M1AOI3StampingLotList;
    }


    /**
     * 获取 D4YOffLine8M1AOI3 FAI 数据集合
     *
     * @param UpperContactIMReelLOTList
     * @return
     */
    public List<D4YOffLine8M1AOI3> getD4YOffLine8M1AOI3List(List<String> UpperContactIMReelLOTList) {
        List<D4YOffLine8M1AOI3> d4YOffLine8M1AOI3 = new ArrayList<>();
        if (UpperContactIMReelLOTList.size() > 0) {
            // 每批次的大小
            int batchSize = 2000;
            int totalSize = UpperContactIMReelLOTList.size();
            for (int i = 0; i < totalSize; i += batchSize) {
                // 防止最后一批不足 batchSize 个
                int endIndex = Math.min(i + batchSize, totalSize);
                List<String> batch = UpperContactIMReelLOTList.subList(i, endIndex);
                d4YOffLine8M1AOI3.addAll(d4YOffLine8M1AOI3Mapper.getD4YOffLine8M1AOI3List(batch));
            }
        }
        return d4YOffLine8M1AOI3;
    }

    /**
     * 获取 OffLine8M1AOI3StampingLot 数据集合
     *
     * @param UpperContactIMReelLOTList
     * @return
     */
    public List<String> getOffLine8M1AOI3StampingLotList(List<String> UpperContactIMReelLOTList) {
        List<String> OffLine8M1AOI3StampingLotList = new ArrayList<>();
        if (UpperContactIMReelLOTList.size() > 0) {
            // 每批次的大小
            int batchSize = 2000;
            int totalSize = UpperContactIMReelLOTList.size();
            for (int i = 0; i < totalSize; i += batchSize) {
                // 防止最后一批不足 batchSize 个
                int endIndex = Math.min(i + batchSize, totalSize);
                List<String> batch = UpperContactIMReelLOTList.subList(i, endIndex);
                OffLine8M1AOI3StampingLotList.addAll(d4YOffLine8M1AOI3Mapper.getOffLine8M1AOI3StampingLotList(batch));
            }
        }
        return OffLine8M1AOI3StampingLotList;
    }

    /**
     * 获取 D4YSubLine2M3TPX FAI 数据集合
     *
     * @param BarcodeEMIList
     * @return
     */
    public List<D4YSubLine2M3TPX> getD4YSubLine2M3TPXList(List<String> BarcodeEMIList) {
        List<D4YSubLine2M3TPX> d4YSubLine2M3TPX = new ArrayList<>();
        if (BarcodeEMIList.size() > 0) {
            // 每批次的大小
            int batchSize = 2000;
            int totalSize = BarcodeEMIList.size();
            for (int i = 0; i < totalSize; i += batchSize) {
                // 防止最后一批不足 batchSize 个
                int endIndex = Math.min(i + batchSize, totalSize);
                List<String> batch = BarcodeEMIList.subList(i, endIndex);
                d4YSubLine2M3TPX.addAll(d4YSubLine2M3Mapper.getD4YSubLine2M3TPXList(batch));
            }
        }
        return d4YSubLine2M3TPX;
    }

    /**
     * 获取 D4YMainLine3M10TPX FAI 数据集合
     */
    private List<D4YMainLine3M10TPX> getD4YMainLine3M10TPXList(String startTime, String endTime) {
        return d4YMainLine3M10Mapper.getD4YMainLine3M10TPXList(startTime, endTime);
    }

    /**
     * 获取 OffLine11M13D FAI 数据集合
     */
    private List<D4YOffLine11M13D> getD4YOffLine11M13DList(List<String> OffLine9M13DStampingLotList) {
        List<D4YOffLine11M13D> d4YOffLine11M13D = new ArrayList<>();
        if (OffLine9M13DStampingLotList.size() > 0) {
            // 每批次的大小
            int batchSize = 2000;
            int totalSize = OffLine9M13DStampingLotList.size();
            for (int i = 0; i < totalSize; i += batchSize) {
                // 防止最后一批不足 batchSize 个
                int endIndex = Math.min(i + batchSize, totalSize);
                List<String> batch = OffLine9M13DStampingLotList.subList(i, endIndex);
                d4YOffLine11M13D.addAll(d4YOffLine11M13DMapper.getD4YOffLine11M13DList(batch));
            }
        }
        return d4YOffLine11M13D;
    }

    /**
     * 获取 OffLine10M13D FAI 数据集合
     */
    private List<D4YOffLine10M13D> getD4YOffLine10M13DList(List<String> OffLine8M13DStampingLotList) {
        List<D4YOffLine10M13D> d4YOffLine10M13D = new ArrayList<>();
        if (OffLine8M13DStampingLotList.size() > 0) {
            // 每批次的大小
            int batchSize = 2000;
            int totalSize = OffLine8M13DStampingLotList.size();
            for (int i = 0; i < totalSize; i += batchSize) {
                // 防止最后一批不足 batchSize 个
                int endIndex = Math.min(i + batchSize, totalSize);
                List<String> batch = OffLine8M13DStampingLotList.subList(i, endIndex);
                d4YOffLine10M13D.addAll(d4YOffLine10M13DMapper.getD4YOffLine10M13DList(batch));
            }
        }
        return d4YOffLine10M13D;
    }

    /**
     * 获取 OffLine9M13D StampingLot 数据集合
     */
    private List<String> getOffLine9M13DStampingLotList(List<String> LowerContactIMReelLOTList) {
        List<String> OffLine9M13DStampingLotList = new ArrayList<>();
        if (LowerContactIMReelLOTList.size() > 0) {
            // 每批次的大小
            int batchSize = 2000;
            int totalSize = LowerContactIMReelLOTList.size();
            for (int i = 0; i < totalSize; i += batchSize) {
                // 防止最后一批不足 batchSize 个
                int endIndex = Math.min(i + batchSize, totalSize);
                List<String> batch = LowerContactIMReelLOTList.subList(i, endIndex);
                OffLine9M13DStampingLotList.addAll(d4YOffLine9M13DMapper.getD4YOffLine9M13DStampingLotList(batch));
            }
        }
        return OffLine9M13DStampingLotList;
    }

    /**
     * 获取 OffLine9M13D 数据集合
     *
     * @param LowerContactIMReelLOTList
     * @return
     */
    private List<D4YOffLine9M13D> getD4YOffLine9M13DList(List<String> LowerContactIMReelLOTList) {
        List<D4YOffLine9M13D> d4YOffLine9M13D = new ArrayList<>();
        if (LowerContactIMReelLOTList.size() > 0) {
            // 每批次的大小
            int batchSize = 2000;
            int totalSize = LowerContactIMReelLOTList.size();
            for (int i = 0; i < totalSize; i += batchSize) {
                // 防止最后一批不足 batchSize 个
                int endIndex = Math.min(i + batchSize, totalSize);
                List<String> batch = LowerContactIMReelLOTList.subList(i, endIndex);
                d4YOffLine9M13D.addAll(d4YOffLine9M13DMapper.getD4YOffLine9M13DList(batch));
            }
        }
        return d4YOffLine9M13D;
    }

    /**
     * 获取 OffLine8M13D FAI 数据集合
     *
     * @param UpperContactIMReelLOTList
     * @return
     */
    private List<D4YOffLine8M13D> getOffLine8M13DList(List<String> UpperContactIMReelLOTList) {
        List<D4YOffLine8M13D> d4YOffLine8M13D = new ArrayList<>();
        if (UpperContactIMReelLOTList.size() > 0) {
            // 每批次的大小
            int batchSize = 2000;
            int totalSize = UpperContactIMReelLOTList.size();
            for (int i = 0; i < totalSize; i += batchSize) {
                // 防止最后一批不足 batchSize 个
                int endIndex = Math.min(i + batchSize, totalSize);
                List<String> batch = UpperContactIMReelLOTList.subList(i, endIndex);
                d4YOffLine8M13D.addAll(d4YOffLine8M13DMapper.getD4YOffLine8M13DList(batch));
            }
        }
        return d4YOffLine8M13D;
    }

    /**
     * 获取 StampingLot 的数据集合
     *
     * @param UpperContactIMReelLOTList
     * @return
     */
    private List<String> getOffLine8M13DStampingLotList(List<String> UpperContactIMReelLOTList) {
        List<String> OffLine8M13DStampingLotList = new ArrayList<>();
        if (UpperContactIMReelLOTList.size() > 0) {
            // 每批次的大小
            int batchSize = 2000;
            int totalSize = UpperContactIMReelLOTList.size();
            for (int i = 0; i < totalSize; i += batchSize) {
                // 防止最后一批不足 batchSize 个
                int endIndex = Math.min(i + batchSize, totalSize);
                List<String> batch = UpperContactIMReelLOTList.subList(i, endIndex);
                OffLine8M13DStampingLotList.addAll(d4YOffLine8M13DMapper.getD4YOffLine8M13DStampingLotList(batch));
            }
        }
        return OffLine8M13DStampingLotList;
    }

    /**
     * 获取 LowerContactIMReelLOTList 的数据集合
     *
     * @param BarcodeMidPlateList
     * @return
     */
    private List<String> getLowerContactIMReelLOTList(List<String> BarcodeMidPlateList) {
        List<String> LowerContactIMReelLOTList = new ArrayList<>();
        if (BarcodeMidPlateList.size() > 0) {
            // 每批次的大小
            int batchSize = 2000;
            int totalSize = BarcodeMidPlateList.size();
            for (int i = 0; i < totalSize; i += batchSize) {
                // 防止最后一批不足 batchSize 个
                int endIndex = Math.min(i + batchSize, totalSize);
                List<String> batch = BarcodeMidPlateList.subList(i, endIndex);
                LowerContactIMReelLOTList.addAll(d4YSubLine1M1Mapper.getLowerContactIMReelLOTList(batch));
            }
        }
        return LowerContactIMReelLOTList;
    }

    /**
     * 获取 UpperContactIMReelLOT 的数据集合
     *
     * @param BarcodeMidPlateList
     * @return
     */
    private List<String> getUpperContactIMReelLOTList(List<String> BarcodeMidPlateList) {
        List<String> UpperContactIMReelLOTList = new ArrayList<>();
        if (BarcodeMidPlateList.size() > 0) {
            // 每批次的大小
            int batchSize = 2000;
            int totalSize = BarcodeMidPlateList.size();
            for (int i = 0; i < totalSize; i += batchSize) {
                // 防止最后一批不足 batchSize 个
                int endIndex = Math.min(i + batchSize, totalSize);
                List<String> batch = BarcodeMidPlateList.subList(i, endIndex);
                UpperContactIMReelLOTList.addAll(d4YSubLine1M1Mapper.getUpperContactIMReelLOTList(batch));
            }
        }
        return UpperContactIMReelLOTList;
    }

    /**
     * 获取 SubLine1M6 中的 FAI 数据集合
     *
     * @param BarcodeMidPlateList
     * @return
     */
    private List<D4YSubLine1M6TPZ> getSubLine1M6TPZList(List<String> BarcodeMidPlateList) {
        List<D4YSubLine1M6TPZ> subLine1M6TPZList = new ArrayList<>();
        if (BarcodeMidPlateList.size() > 0) {
            // 每批次的大小
            int batchSize = 2000;
            int totalSize = BarcodeMidPlateList.size();
            for (int i = 0; i < totalSize; i += batchSize) {
                // 防止最后一批不足 batchSize 个
                int endIndex = Math.min(i + batchSize, totalSize);
                List<String> batch = BarcodeMidPlateList.subList(i, endIndex);
                subLine1M6TPZList.addAll(d4YSubLine1M6Mapper.getD4YSubLine1M6TPZList(batch));
            }
        }
        return subLine1M6TPZList;
    }

    /**
     * 获取 MainLine3M10TPZ 中的 FAI 数据集合
     *
     * @param startTime
     * @param endTime
     * @return
     */
    private List<D4YMainLine3M10TPZ> getMainLine3M10TPZList(String startTime, String endTime) {
        return d4YMainLine3M10Mapper.getD4YMainLine3M10TPZList(startTime, endTime);
    }

    /**
     * 获取 SubLine2M4 中的 FAI 数据集合
     *
     * @param BarcodeEMIList
     * @return
     */
    private List<D4YSubLine2M4> getSubLine2M4List(List<String> BarcodeEMIList) {
        List<D4YSubLine2M4> subLine2M4TPZList = new ArrayList<>();
        if (BarcodeEMIList.size() > 0) {
            // 每批次的大小
            int batchSize = 2000;
            int totalSize = BarcodeEMIList.size();
            for (int i = 0; i < totalSize; i += batchSize) {
                // 防止最后一批不足 batchSize 个
                int endIndex = Math.min(i + batchSize, totalSize);
                List<String> batch = BarcodeEMIList.subList(i, endIndex);
                subLine2M4TPZList.addAll(d4YSubLine2M4Mapper.getD4YSubLine2M4List(batch));
            }
        }
        return subLine2M4TPZList;
    }

    /**
     * 获取 SubLine2 中的 Barcode_MidPlate 码数据集合
     *
     * @param BarcodeEMIList
     * @return
     */
    private List<String> getBarcodeMidPlateList(List<String> BarcodeEMIList) {
        List<String> BarcodeMidPlateList = new ArrayList<>();
        if (BarcodeEMIList.size() > 0) {
            // 每批次的大小
            int batchSize = 2000;
            int totalSize = BarcodeEMIList.size();
            for (int i = 0; i < totalSize; i += batchSize) {
                // 防止最后一批不足 batchSize 个
                int endIndex = Math.min(i + batchSize, totalSize);
                List<String> batch = BarcodeEMIList.subList(i, endIndex);
                BarcodeMidPlateList.addAll(d4YSubLine2M1Mapper.getD4YSubLine2M1BarcodeMidPlateList(batch));
            }
        }
        return BarcodeMidPlateList;
    }

    /**
     * 获取 MainLine1M2 中的 Barcode_EMI 码数据集合
     *
     * @param BarcodeHSGList
     * @return
     */
    private List<String> getBarcodeEMIList(List<String> BarcodeHSGList) {
        List<String> BarcodeEMIList = new ArrayList<>();
        if (BarcodeHSGList.size() > 0) {
            // 每批次的大小
            int batchSize = 2000;
            int totalSize = BarcodeHSGList.size();
            for (int i = 0; i < totalSize; i += batchSize) {
                // 防止最后一批不足 batchSize 个
                int endIndex = Math.min(i + batchSize, totalSize);
                List<String> batch = BarcodeHSGList.subList(i, endIndex);
                BarcodeEMIList.addAll(d4YMainLine1M2Mapper.getD4YMainLine1M2BarcodeEMIList(batch));
            }
        }
        return BarcodeEMIList;
    }


    /**
     * 获取 MainLine3M6 中的 BarcodeHSG 数据集合
     *
     * @param BarCodeList
     * @return
     */
    private List<String> getBarcodeHSGList(List<String> BarCodeList) {
        // 由于数据库对于参数个数的限制，在这里对批量查询的数据进行分批处理
        List<String> BarcodeHSGList = new ArrayList<>();
        if (BarCodeList.size() > 0) {
            // 每批次的大小
            int batchSize = 2000;
            int totalSize = BarCodeList.size();
            for (int i = 0; i < totalSize; i += batchSize) {
                // 防止最后一批不足 batchSize 个
                int endIndex = Math.min(i + batchSize, totalSize);
                List<String> batch = BarCodeList.subList(i, endIndex);
                BarcodeHSGList.addAll(d4YMainLine3M6Mapper.getD4YMainLine3M6BarcodeHSGList(batch));
            }
        }
        return BarcodeHSGList;
    }

    /**
     * 获取 MainLine3M10 中的 BarCode 数据集合
     *
     * @param startTime
     * @param endTime
     * @return
     */
    private List<String> getBarCodeList(String startTime, String endTime) {
        return d4YMainLine3M10Mapper.getD4YMainLine3M10BarcodeList(startTime, endTime);
    }

}
