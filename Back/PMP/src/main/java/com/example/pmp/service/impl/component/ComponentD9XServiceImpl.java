package com.example.pmp.service.impl.component;

import com.example.pmp.mapper.component.D9X.*;
import com.example.pmp.pojo.component.ComponentFAI;
import com.example.pmp.pojo.component.D9X.*;
import com.example.pmp.pojo.component.dto.ComponentParam;
import com.example.pmp.service.component.ComponentD9XService;
import com.example.pmp.utils.ComponentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author Dandan
 * @date 2024/1/16 10:36
 **/
@Service
public class ComponentD9XServiceImpl implements ComponentD9XService {

    @Autowired
    private MainLine3M10Mapper mainLine3M10Mapper;

    @Autowired
    private MainLine3M6Mapper mainLine3M6Mapper;

    @Autowired
    private MainLine1M2Mapper mainLine1M2Mapper;

    @Autowired
    private SubLine2M1Mapper subLine2M1Mapper;

    @Autowired
    private SubLine2M4Mapper subLine2M4Mapper;

    @Autowired
    private SubLine1M6Mapper subLine1M6Mapper;

    @Autowired
    private SubLine1M1Mapper subLine1M1Mapper;

    @Autowired
    private SubLine2M3Mapper subLine2M3Mapper;

    @Autowired
    private OffLine8M13DMapper offLine8M13DMapper;

    @Autowired
    private OffLine9M13DMapper offLine9M13DMapper;

    @Autowired
    private OffLine8M1AOIMapper offLine8M1AOIMapper;

    @Autowired
    private OffLine9M1AOI3Mapper offLine9M1AOI3Mapper;

    @Autowired
    private OffLine10M13DMapper offLine10M13DMapper;

    @Autowired
    private OffLine11M13DMapper offLine11M13DMapper;

    @Autowired
    private OffLine10M12DMapper offLine10M12DMapper;

    @Autowired
    private OffLine11M12DMapper offLine11M12DMapper;

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


    /**
     * 获取零件尺寸数据
     *
     * @param componentParam
     * @return
     */
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
            case "TPZ":

                List<String> offLine8M13DStampingLotList = getOffLine8M13DStampingLotList(UpperContactIMReelLOTList);
                List<String> offLine9M13DStampingLotList = getOffLine9M13DStampingLotList(LowerContactIMReelLOTList);

                List<MainLine3M10TPZ> mainLine3M10TPZList = getMainLine3M10TPZList(startTime, endTime);
                List<SubLine2M4TPZ> subLine2M4TPZList = getSubLine2M4List(BarcodeEMIList);
                List<SubLine1M6TPZ> subLine1M6TPZList = getSubLine1M6TPZList(BarcodeMidPlateList);
                List<OffLine8M13D> offLine8M13DList = getOffLine8M13DList(UpperContactIMReelLOTList);
                List<OffLine9M13D> offLine9M13DList = getOffLine9M13DList(LowerContactIMReelLOTList);
                List<OffLine10M13D> offLine10M13DList = getOffLine10M13DList(offLine8M13DStampingLotList);
                List<OffLine11M13D> offLine11M13DList = getOffLine11M13DList(offLine9M13DStampingLotList);

                partMap.putAll(ComponentUtils.getFAIDataMap(offLine11M13DList));
                partMap.putAll(ComponentUtils.getFAIDataMap(offLine10M13DList));
                partMap.putAll(ComponentUtils.getFAIDataMap(offLine9M13DList));
                partMap.putAll(ComponentUtils.getFAIDataMap(offLine8M13DList));
                partMap.putAll(ComponentUtils.getFAIDataMap(subLine1M6TPZList));
                partMap.putAll(ComponentUtils.getFAIDataMap(subLine2M4TPZList));
                partMap.putAll(ComponentUtils.getFAIDataMap(mainLine3M10TPZList));
                break;
            case "TPX": {
                List<String> OffLine8M1AOIStampingLotList = getOffLine8M1AOIStampingLotList(UpperContactIMReelLOTList);
                List<String> OffLine9M1AOI3StampingLotList = getOffLine9M1AOI3StampingLotList(LowerContactIMReelLOTList);

                List<MainLine3M10TPX> mainLine3M10TPXList = getMainLine3M10TPXList(startTime, endTime);
                List<SubLine2M3TPX> subLine2M3TPXList = getSubLine2M3TPXList(BarcodeEMIList);
                List<SubLine1M6TPX> subLine1M6TPXList = getSubLine1M6TPXList(BarcodeMidPlateList);
                List<OffLine8M1AOI3> offLine8M1AOI3List = getOffLine8M1AOIList(UpperContactIMReelLOTList);
                List<OffLine9M1AOI3> offLine9M1AOI3List = getOffLine9M1AOI3List(LowerContactIMReelLOTList);
                List<OffLine10M12D> offLine10M12DList = getOffLine10M12DList(OffLine8M1AOIStampingLotList);
                List<OffLine11M12D> offLine11M12DList = getOffLine11M12DList(OffLine9M1AOI3StampingLotList);

                partMap.putAll(ComponentUtils.getFAIDataMap(offLine11M12DList));
                partMap.putAll(ComponentUtils.getFAIDataMap(offLine10M12DList));
                partMap.putAll(ComponentUtils.getFAIDataMap(offLine9M1AOI3List));
                partMap.putAll(ComponentUtils.getFAIDataMap(offLine8M1AOI3List));
                partMap.putAll(ComponentUtils.getFAIDataMap(subLine1M6TPXList));
                partMap.putAll(ComponentUtils.getFAIDataMap(subLine2M3TPXList));
                partMap.putAll(ComponentUtils.getFAIDataMap(mainLine3M10TPXList));
                break;
            }
            case "TPY": {
                List<MainLine3M10TPY> mainLine3M10TPYList = getMainLine3M10TPYList(startTime, endTime);
                List<SubLine2M3TPY> subLine2M3TPYList = getSubLine2M3TPYList(BarcodeEMIList);
                List<SubLine1M6TPY> subLine1M6TPXList = getSubLine1M6TPYList(BarcodeMidPlateList);
                partMap.putAll(ComponentUtils.getFAIDataMap(subLine1M6TPXList));
                partMap.putAll(ComponentUtils.getFAIDataMap(subLine2M3TPYList));
                partMap.putAll(ComponentUtils.getFAIDataMap(mainLine3M10TPYList));
                break;
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
     * 获取 OffLine11M12D FAI 数据集合
     *
     * @param OffLine9M1AOI3StampingLotList
     * @return
     */
    public List<OffLine11M12D> getOffLine11M12DList(List<String> OffLine9M1AOI3StampingLotList) {
        List<OffLine11M12D> offLine11M12D = new ArrayList<>();
        if (OffLine9M1AOI3StampingLotList.size() > 0) {
            // 每批次的大小
            int batchSize = 2000;
            int totalSize = OffLine9M1AOI3StampingLotList.size();
            for (int i = 0; i < totalSize; i += batchSize) {
                // 防止最后一批不足 batchSize 个
                int endIndex = Math.min(i + batchSize, totalSize);
                List<String> batch = OffLine9M1AOI3StampingLotList.subList(i, endIndex);
                offLine11M12D.addAll(offLine11M12DMapper.getOffLine11M12DList(batch));
            }
        }
        return offLine11M12D;
    }

    /**
     * 获取 OffLine10M12D FAI 数据集合
     *
     * @param OffLine8M1AOIStampingLotList
     * @return
     */
    public List<OffLine10M12D> getOffLine10M12DList(List<String> OffLine8M1AOIStampingLotList) {
        List<OffLine10M12D> offLine10M12D = new ArrayList<>();
        if (OffLine8M1AOIStampingLotList.size() > 0) {
            // 每批次的大小
            int batchSize = 2000;
            int totalSize = OffLine8M1AOIStampingLotList.size();
            for (int i = 0; i < totalSize; i += batchSize) {
                // 防止最后一批不足 batchSize 个
                int endIndex = Math.min(i + batchSize, totalSize);
                List<String> batch = OffLine8M1AOIStampingLotList.subList(i, endIndex);
                offLine10M12D.addAll(offLine10M12DMapper.getOffLine10M12DList(batch));
            }
        }
        return offLine10M12D;
    }

    /**
     * 获取 OffLine9M1AOI3 StampingLot 数据集合
     *
     * @param LowerContactIMReelLOTList
     * @return
     */
    public List<String> getOffLine9M1AOI3StampingLotList(List<String> LowerContactIMReelLOTList) {
        List<String> OffLine9M1AOI3StampingLotList = new ArrayList<>();
        if (LowerContactIMReelLOTList.size() > 0) {
            // 每批次的大小
            int batchSize = 2000;
            int totalSize = LowerContactIMReelLOTList.size();
            for (int i = 0; i < totalSize; i += batchSize) {
                // 防止最后一批不足 batchSize 个
                int endIndex = Math.min(i + batchSize, totalSize);
                List<String> batch = LowerContactIMReelLOTList.subList(i, endIndex);
                OffLine9M1AOI3StampingLotList.addAll(offLine9M1AOI3Mapper.getOffLine9M1AOI3StampingLotList(batch));
            }
        }
        return OffLine9M1AOI3StampingLotList;
    }

    /**
     * 获取 OffLine8M1AOI StampingLot 数据集合
     *
     * @param UpperContactIMReelLOTList
     * @return
     */
    public List<String> getOffLine8M1AOIStampingLotList(List<String> UpperContactIMReelLOTList) {
        List<String> OffLine8M1AOIStampingLotList = new ArrayList<>();
        if (UpperContactIMReelLOTList.size() > 0) {
            // 每批次的大小
            int batchSize = 2000;
            int totalSize = UpperContactIMReelLOTList.size();
            for (int i = 0; i < totalSize; i += batchSize) {
                // 防止最后一批不足 batchSize 个
                int endIndex = Math.min(i + batchSize, totalSize);
                List<String> batch = UpperContactIMReelLOTList.subList(i, endIndex);
                OffLine8M1AOIStampingLotList.addAll(offLine8M1AOIMapper.getOffLine8M1AOIStampingLotList(batch));
            }
        }
        return OffLine8M1AOIStampingLotList;
    }

    /**
     * 获取 OffLine11M13D FAI 数据集合
     *
     * @param offLine9M13DStampingLotList
     * @return
     */
    public List<OffLine11M13D> getOffLine11M13DList(List<String> offLine9M13DStampingLotList) {
        List<OffLine11M13D> offLine11M13D = new ArrayList<>();
        if (offLine9M13DStampingLotList.size() > 0) {
            // 每批次的大小
            int batchSize = 2000;
            int totalSize = offLine9M13DStampingLotList.size();
            for (int i = 0; i < totalSize; i += batchSize) {
                // 防止最后一批不足 batchSize 个
                int endIndex = Math.min(i + batchSize, totalSize);
                List<String> batch = offLine9M13DStampingLotList.subList(i, endIndex);
                offLine11M13D.addAll(offLine11M13DMapper.getOffLine11M13DList(batch));
            }
        }
        return offLine11M13D;
    }

    /**
     * 获取 OffLine10M13D FAI 数据集合
     *
     * @param offLine8M13DStampingLotList
     * @return
     */
    public List<OffLine10M13D> getOffLine10M13DList(List<String> offLine8M13DStampingLotList) {
        List<OffLine10M13D> offLine10M13D = new ArrayList<>();
        if (offLine8M13DStampingLotList.size() > 0) {
            // 每批次的大小
            int batchSize = 2000;
            int totalSize = offLine8M13DStampingLotList.size();
            for (int i = 0; i < totalSize; i += batchSize) {
                // 防止最后一批不足 batchSize 个
                int endIndex = Math.min(i + batchSize, totalSize);
                List<String> batch = offLine8M13DStampingLotList.subList(i, endIndex);
                offLine10M13D.addAll(offLine10M13DMapper.getOffLine10M13DList(batch));
            }
        }
        return offLine10M13D;
    }

    /**
     * 获取 OffLine9M13D StampingLot 数据集合
     *
     * @param LowerContactIMReelLOTList
     * @return
     */
    public List<String> getOffLine9M13DStampingLotList(List<String> LowerContactIMReelLOTList) {
        List<String> OffLine9M13DStampingLotList = new ArrayList<>();
        if (LowerContactIMReelLOTList.size() > 0) {
            // 每批次的大小
            int batchSize = 2000;
            int totalSize = LowerContactIMReelLOTList.size();
            for (int i = 0; i < totalSize; i += batchSize) {
                // 防止最后一批不足 batchSize 个
                int endIndex = Math.min(i + batchSize, totalSize);
                List<String> batch = LowerContactIMReelLOTList.subList(i, endIndex);
                OffLine9M13DStampingLotList.addAll(offLine9M13DMapper.getOffLine9M13DStampingLotList(batch));
            }
        }
        return OffLine9M13DStampingLotList;
    }

    /**
     * 获取 OffLine8M13DStampingLot 数据集合
     *
     * @param UpperContactIMReelLOTList
     * @return
     */
    public List<String> getOffLine8M13DStampingLotList(List<String> UpperContactIMReelLOTList) {
        List<String> OffLine8M13DStampingLotList = new ArrayList<>();
        if (UpperContactIMReelLOTList.size() > 0) {
            // 每批次的大小
            int batchSize = 2000;
            int totalSize = UpperContactIMReelLOTList.size();
            for (int i = 0; i < totalSize; i += batchSize) {
                // 防止最后一批不足 batchSize 个
                int endIndex = Math.min(i + batchSize, totalSize);
                List<String> batch = UpperContactIMReelLOTList.subList(i, endIndex);
                OffLine8M13DStampingLotList.addAll(offLine8M13DMapper.getOffLine8M13DStampingLotList(batch));
            }
        }
        return OffLine8M13DStampingLotList;
    }

    /**
     * 获取offLine9M1AOI3 中的 FAI数据集合
     *
     * @param LowerContactIMReelLOTList
     * @return
     */
    private List<OffLine9M1AOI3> getOffLine9M1AOI3List(List<String> LowerContactIMReelLOTList) {
        List<OffLine9M1AOI3> offLine9M1AOI3List = new ArrayList<>();
        if (LowerContactIMReelLOTList.size() > 0) {
            // 每批次的大小
            int batchSize = 2000;
            int totalSize = LowerContactIMReelLOTList.size();
            for (int i = 0; i < totalSize; i += batchSize) {
                // 防止最后一批不足 batchSize 个
                int endIndex = Math.min(i + batchSize, totalSize);
                List<String> batch = LowerContactIMReelLOTList.subList(i, endIndex);
                offLine9M1AOI3List.addAll(offLine9M1AOI3Mapper.getOffLine9M1AOI3List(batch));
            }
        }
        return offLine9M1AOI3List;
    }

    /**
     * 获取 OffLine8M1AOI 中的 FAI 数据集合
     *
     * @param UpperContactIMReelLOTList
     * @return
     */
    private List<OffLine8M1AOI3> getOffLine8M1AOIList(List<String> UpperContactIMReelLOTList) {
        List<OffLine8M1AOI3> offLine8M1AOI3List = new ArrayList<>();
        if (UpperContactIMReelLOTList.size() > 0) {
            // 每批次的大小
            int batchSize = 2000;
            int totalSize = UpperContactIMReelLOTList.size();
            for (int i = 0; i < totalSize; i += batchSize) {
                // 防止最后一批不足 batchSize 个
                int endIndex = Math.min(i + batchSize, totalSize);
                List<String> batch = UpperContactIMReelLOTList.subList(i, endIndex);
                offLine8M1AOI3List.addAll(offLine8M1AOIMapper.getOffLine8M1AOIList(batch));
            }
        }
        return offLine8M1AOI3List;
    }

    /**
     * 获取 SubLine1M6TPX 中的 FAI 数据集合
     *
     * @param BarcodeMidPlateList
     * @return
     */
    private List<SubLine1M6TPX> getSubLine1M6TPXList(List<String> BarcodeMidPlateList) {
        List<SubLine1M6TPX> SubLine1M6TPXList = new ArrayList<>();
        if (BarcodeMidPlateList.size() > 0) {
            // 每批次的大小
            int batchSize = 2000;
            int totalSize = BarcodeMidPlateList.size();
            for (int i = 0; i < totalSize; i += batchSize) {
                // 防止最后一批不足 batchSize 个
                int endIndex = Math.min(i + batchSize, totalSize);
                List<String> batch = BarcodeMidPlateList.subList(i, endIndex);
                SubLine1M6TPXList.addAll(subLine1M6Mapper.getSubLine1M6TPXList(batch));
            }
        }
        return SubLine1M6TPXList;
    }

    /**
     * 获取 SubLine2M3TPX 中的 FAI 数据集合
     *
     * @param BarcodeEMIList
     * @return
     */
    private List<SubLine2M3TPX> getSubLine2M3TPXList(List<String> BarcodeEMIList) {
        // 由于数据库对于参数个数的限制，在这里对批量查询的数据进行分批处理
        List<SubLine2M3TPX> SubLine2M3TPXList = new ArrayList<>();
        if (BarcodeEMIList.size() > 0) {
            // 每批次的大小
            int batchSize = 2000;
            int totalSize = BarcodeEMIList.size();
            for (int i = 0; i < totalSize; i += batchSize) {
                // 防止最后一批不足 batchSize 个
                int endIndex = Math.min(i + batchSize, totalSize);
                List<String> batch = BarcodeEMIList.subList(i, endIndex);
                SubLine2M3TPXList.addAll(subLine2M3Mapper.getSubLine2M3TPXList(batch));
            }
        }
        return SubLine2M3TPXList;
    }

    /**
     * 获取 MainLine3M10TPX 中的 FAI 数据集合
     *
     * @param startTime
     * @param endTime
     * @return
     */
    private List<MainLine3M10TPX> getMainLine3M10TPXList(String startTime, String endTime) {
        return mainLine3M10Mapper.getMainLine3M10TPXList(startTime, endTime);
    }

    /**
     * 获取 MainLine3M10TPZ 中的 FAI 数据集合
     *
     * @param startTime
     * @param endTime
     * @return
     */
    private List<MainLine3M10TPZ> getMainLine3M10TPZList(String startTime, String endTime) {
        return mainLine3M10Mapper.getMainLine3M10TPZList(startTime, endTime);
    }

    /**
     * 获取 MainLine3M10TPY 中的 FAI 数据集合
     *
     * @param startTime
     * @param endTime
     * @return
     */
    private List<MainLine3M10TPY> getMainLine3M10TPYList(String startTime, String endTime) {
        return mainLine3M10Mapper.getMainLine3M10TPYList(startTime, endTime);
    }

    /**
     * 获取 SubLine2M3TPY 中的 FAI 数据集合
     *
     * @param BarcodeEMIList
     * @return
     */
    private List<SubLine2M3TPY> getSubLine2M3TPYList(List<String> BarcodeEMIList) {
        List<SubLine2M3TPY> subLine2M3TPYList = new ArrayList<>();
        if (BarcodeEMIList.size() > 0) {
            // 每批次的大小
            int batchSize = 2000;
            int totalSize = BarcodeEMIList.size();
            for (int i = 0; i < totalSize; i += batchSize) {
                // 防止最后一批不足 batchSize 个
                int endIndex = Math.min(i + batchSize, totalSize);
                List<String> batch = BarcodeEMIList.subList(i, endIndex);
                subLine2M3TPYList.addAll(subLine2M3Mapper.getSubLine2M3TPYList(batch));
            }
        }
        return subLine2M3TPYList;
    }

    /**
     * 获取 SubLine1M6TPY 中的 FAI 数据集合
     *
     * @param BarcodeMidPlateList
     * @return
     */
    private List<SubLine1M6TPY> getSubLine1M6TPYList(List<String> BarcodeMidPlateList) {
        List<SubLine1M6TPY> subLine1M6TPYList = new ArrayList<>();
        if (BarcodeMidPlateList.size() > 0) {
            // 每批次的大小
            int batchSize = 2000;
            int totalSize = BarcodeMidPlateList.size();
            for (int i = 0; i < totalSize; i += batchSize) {
                // 防止最后一批不足 batchSize 个
                int endIndex = Math.min(i + batchSize, totalSize);
                List<String> batch = BarcodeMidPlateList.subList(i, endIndex);
                subLine1M6TPYList.addAll(subLine1M6Mapper.getSubLine1M6TPYList(batch));
            }
        }
        return subLine1M6TPYList;
    }

    /**
     * 获取 MainLine3M10 中的 BarCode 数据集合
     *
     * @param startTime
     * @param endTime
     * @return
     */
    private List<String> getBarCodeList(String startTime, String endTime) {
        return mainLine3M10Mapper.getMainLine3M10BarcodeList(startTime, endTime);
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
                BarcodeHSGList.addAll(mainLine3M6Mapper.getMainLine3M6BarcodeHSGList(batch));
            }
        }
        return BarcodeHSGList;
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
                BarcodeEMIList.addAll(mainLine1M2Mapper.getMainLine1M2BarcodeEMIList(batch));
            }
        }
        return BarcodeEMIList;
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
                BarcodeMidPlateList.addAll(subLine2M1Mapper.getSubLine2M1BarcodeMidPlateList(batch));
            }
        }
        return BarcodeMidPlateList;
    }

    /**
     * 获取 SubLine2M4 中的 FAI 数据集合
     *
     * @param BarcodeEMIList
     * @return
     */
    private List<SubLine2M4TPZ> getSubLine2M4List(List<String> BarcodeEMIList) {
        List<SubLine2M4TPZ> subLine2M4TPZList = new ArrayList<>();
        if (BarcodeEMIList.size() > 0) {
            // 每批次的大小
            int batchSize = 2000;
            int totalSize = BarcodeEMIList.size();
            for (int i = 0; i < totalSize; i += batchSize) {
                // 防止最后一批不足 batchSize 个
                int endIndex = Math.min(i + batchSize, totalSize);
                List<String> batch = BarcodeEMIList.subList(i, endIndex);
                subLine2M4TPZList.addAll(subLine2M4Mapper.getSubLine2M4List(batch));
            }
        }
        return subLine2M4TPZList;
    }

    /**
     * 获取 SubLine1M6 中的 FAI 数据集合
     *
     * @param BarcodeMidPlateList
     * @return
     */
    private List<SubLine1M6TPZ> getSubLine1M6TPZList(List<String> BarcodeMidPlateList) {
        List<SubLine1M6TPZ> subLine1M6TPZList = new ArrayList<>();
        if (BarcodeMidPlateList.size() > 0) {
            // 每批次的大小
            int batchSize = 2000;
            int totalSize = BarcodeMidPlateList.size();
            for (int i = 0; i < totalSize; i += batchSize) {
                // 防止最后一批不足 batchSize 个
                int endIndex = Math.min(i + batchSize, totalSize);
                List<String> batch = BarcodeMidPlateList.subList(i, endIndex);
                subLine1M6TPZList.addAll(subLine1M6Mapper.getSubLine1M6TPZList(batch));
            }
        }
        return subLine1M6TPZList;
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
                UpperContactIMReelLOTList.addAll(subLine1M1Mapper.getUpperContactIMReelLOTList(batch));
            }
        }
        return UpperContactIMReelLOTList;
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
                LowerContactIMReelLOTList.addAll(subLine1M1Mapper.getLowerContactIMReelLOTList(batch));
            }
        }
        return LowerContactIMReelLOTList;
    }

    /**
     * 获取 OffLine8M13D FAI 数据集合
     *
     * @param UpperContactIMReelLOTList
     * @return
     */
    private List<OffLine8M13D> getOffLine8M13DList(List<String> UpperContactIMReelLOTList) {
        List<OffLine8M13D> OffLine8M13DList = new ArrayList<>();
        if (UpperContactIMReelLOTList.size() > 0) {
            // 每批次的大小
            int batchSize = 2000;
            int totalSize = UpperContactIMReelLOTList.size();
            for (int i = 0; i < totalSize; i += batchSize) {
                // 防止最后一批不足 batchSize 个
                int endIndex = Math.min(i + batchSize, totalSize);
                List<String> batch = UpperContactIMReelLOTList.subList(i, endIndex);
                OffLine8M13DList.addAll(offLine8M13DMapper.getOffLine8M13DList(batch));
            }
        }
        return OffLine8M13DList;
    }

    /**
     * 获取 OffLine9M13D FAI 数据集合
     *
     * @param LowerContactIMReelLOTList
     * @return
     */
    private List<OffLine9M13D> getOffLine9M13DList(List<String> LowerContactIMReelLOTList) {
        List<OffLine9M13D> OffLine9M13DList = new ArrayList<>();
        if (LowerContactIMReelLOTList.size() > 0) {
            // 每批次的大小
            int batchSize = 2000;
            int totalSize = LowerContactIMReelLOTList.size();
            for (int i = 0; i < totalSize; i += batchSize) {
                // 防止最后一批不足 batchSize 个
                int endIndex = Math.min(i + batchSize, totalSize);
                List<String> batch = LowerContactIMReelLOTList.subList(i, endIndex);
                OffLine9M13DList.addAll(offLine9M13DMapper.getOffLine9M13DList(batch));
            }
        }
        return OffLine9M13DList;
    }

}
