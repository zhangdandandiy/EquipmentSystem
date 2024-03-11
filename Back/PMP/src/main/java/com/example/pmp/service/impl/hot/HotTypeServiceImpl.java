package com.example.pmp.service.impl.hot;

import com.example.pmp.mapper.hot.HotFaceMapper;
import com.example.pmp.mapper.hot.HotTypeMapper;
import com.example.pmp.pojo.hot.HotData;
import com.example.pmp.pojo.hot.HotFace;
import com.example.pmp.pojo.hot.HotType;
import com.example.pmp.pojo.hot.dto.HotTypeParamDto;
import com.example.pmp.service.hot.HotTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Dandan
 * @date 2024/1/6 9:54
 **/
@Service
public class HotTypeServiceImpl implements HotTypeService {

    @Autowired
    private HotTypeMapper hotTypeMapper;

    @Autowired
    private HotFaceMapper hotFaceMapper;

    BigDecimal decimalMultiplier = new BigDecimal("0.4");


    @Override
    public Map<String, Map<String, Object>> getHotDataList(HotTypeParamDto hotTypeParamDto) {
        List<HotType> hotTypeList = getHotTypeList(hotTypeParamDto);

        // 先根据"面" & 线体类型(Top/Bottom/Left/Right/Front/Back)进行分组
        Map<String, List<HotType>> countMap = hotTypeList.parallelStream()
                .collect(Collectors.groupingByConcurrent(
                        HotType::getDirection,
                        Collectors.toList()
                ));

        Map<String, Map<String, Object>> result = new HashMap<>();

        // 遍历countMap
        for (String direction : countMap.keySet()) {

            // 将不在范围内的删掉

            Map<String, Object> resultData = new HashMap<>();
            // 统计最大的占比
            BigDecimal maxPercentage = new BigDecimal("0");
            // 统计最小占比
            BigDecimal minPercentage = new BigDecimal("1");

            List<HotType> hotTypes = countMap.get(direction);
            BigDecimal sum = BigDecimal.valueOf(hotTypes.size());
            // 获取线体类型
            // String lineType = hotTypeParamDto.getLineType();
            // 获取偏移量
            // HotFace hotFace = getHotFace(lineType, direction);
            // 统计x和y坐标相同的数据
            Map<String, HotData> tempMap = new HashMap<>();

            BigDecimal result1;
            BigDecimal result2;

            for (HotType hotType : hotTypes) {

                result1 = hotType.getPositionX().compareTo(new BigDecimal("0")) >= 1 ? hotType.getPositionX().divide(decimalMultiplier, 0, RoundingMode.UP) : hotType.getPositionX().divide(decimalMultiplier, 0, RoundingMode.DOWN);
                result2 = hotType.getPositionY().compareTo(new BigDecimal("0")) >= 1 ? hotType.getPositionY().divide(decimalMultiplier, 0, RoundingMode.UP) : hotType.getPositionY().divide(decimalMultiplier, 0, RoundingMode.DOWN);

                BigDecimal x = result1.multiply(decimalMultiplier);
                BigDecimal y = result2.multiply(decimalMultiplier);
                String key = x + "_" + y;

                if (tempMap.containsKey(key)) {
                    HotData hotData = tempMap.get(key);
                    hotData.setCount(hotData.getCount().add(new BigDecimal("1")));
                } else {
                    // HotData hotData = new HotData(
                    //        direction, (x.subtract(hotFace.getXAxis()).setScale(1, BigDecimal.ROUND_HALF_UP)), (y.subtract(hotFace.getYAxis()).setScale(1, BigDecimal.ROUND_HALF_UP)), new BigDecimal("1"), sum, new BigDecimal("0"));
                    HotData hotData = new HotData(
                            direction, (x.setScale(1, RoundingMode.HALF_UP)), y.setScale(1, RoundingMode.HALF_UP), new BigDecimal("1"), sum, new BigDecimal("0"));

                    tempMap.put(key, hotData);
                }
            }

            // 计算百分比
            BigDecimal totalCount = BigDecimal.valueOf(hotTypes.size());
            // 统计占比
            BigDecimal percentage;

            // 获取HotData集合数据
            List<HotData> hotDataList = new ArrayList<>();
            for (HotData hotData : tempMap.values()) {
                percentage = hotData.getCount().divide(totalCount, 6, RoundingMode.HALF_UP);
                if (percentage.compareTo(maxPercentage) > 0) {
                    maxPercentage = percentage;
                }
                if (percentage.compareTo(minPercentage) < 0) {
                    minPercentage = percentage;
                }
                hotData.setPercentage(percentage);
                hotDataList.add(hotData);
            }

            resultData.put("data", hotDataList);
            resultData.put("maxPercentage", maxPercentage);
            resultData.put("minPercentage", minPercentage);

            // 将结果存入result
            result.put(direction, resultData);
        }

        return result;
    }

    /**
     * 获取热力图原始数据(没经过处理)
     *
     * @param hotTypeParamDto
     * @return
     */
    private List<HotType> getHotTypeList(HotTypeParamDto hotTypeParamDto) {
        return hotTypeMapper.getHotTypeList(hotTypeParamDto);
    }

    /**
     * 根据面的名称获取横纵坐标偏移量
     *
     * @param FaceName
     * @return
     */
    private HotFace getHotFace(String LineID, String FaceName) {
        return hotFaceMapper.selectHotFaceByName(LineID, FaceName);
    }

}
