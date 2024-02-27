package com.example.pmp.service.impl.fox;

import com.example.pmp.mapper.fox.D8xMapper;
import com.example.pmp.pojo.fox.*;
import com.example.pmp.service.fox.D8XService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dandan
 * @date 2023/8/25 8:32
 **/

@Service
public class D8XServiceImpl implements D8XService {

    @Autowired
    private D8xMapper d8xMapper;

    @Override
    public List<d8x> selectD8XAll() {
        return d8xMapper.selectD8XAll();
    }

    @Override
    public targetFormat convertData(List<d8x> originalData) {

        targetFormat targetFormat = new targetFormat();

        // 设置sendResultDetails字段值
        targetFormat.setSendResultDetails(new sendResultDetails("", "", ""));

        // 设置test_attributes字段值
        targetFormat.setTestAttributes(new testAttributes(null, null, null, null));

        // 设置test_station_attributes字段值
        targetFormat.setTestStationAttributes(new testStationAttributes(null, null, null, null, null, null));

        // 设置uut_attributes字段值
        targetFormat.setUutAttributes(new uutAttributes(null, null, null));

        // 遍历原始数据对象
        List<results> results = new ArrayList<>();
        for (d8x item : originalData) {
            results result = new results();

            // 设置result对象的字段值
            result.setLower_limit(null);
            result.setParametric_key(item.getBarcode());
            result.setPriority(item.getTestResult());
            result.setResult("");
            result.setSub_test(null);
            result.setSub_sub_test(null);
            result.setTest(null);
            result.setUnits(null);
            result.setUpper_limit(null);
            result.setValue(null);
            results.add(result);
        }

        // 设置results字段值
        targetFormat.setResultsList(results);

        return targetFormat;
    }

    @Override
    public int insertMD8xMainLine301M5T(D8XMainLine301M5 mD8xMainLine301M5T) {
        return d8xMapper.insertMD8xMainLine301M5T(mD8xMainLine301M5T);
    }

    @Override
    public List<D8XMainLine301M5Search> searchMD8xMainLine301M5T(String Barcode, String StartTime, String EndTime) {
        return d8xMapper.searchMD8xMainLine301M5T(Barcode, StartTime, EndTime);
    }

    @Override
    public int insertMD8xMainLine301M6T(D8XMainLine301M6 mD8xMainLine301M6T) {
        return d8xMapper.insertMD8xMainLine301M6T(mD8xMainLine301M6T);
    }

    @Override
    public List<D8XMainLine301M6Search> searchMD8xMainLine301M6T(String Barcode, String StartTime, String EndTime) {
        return d8xMapper.searchMD8xMainLine301M6T(Barcode, StartTime, EndTime);
    }

    @Override
    public List<D8XMainLine301M7Search> searchMD8xMainLine301M7T(String Barcode, String StartTime, String EndTime) {
        return d8xMapper.searchMD8xMainLine301M7T(Barcode, StartTime, EndTime);
    }

    @Override
    public int insertMD8xMainLine301M7T(D8XMainLine301M7 mD8xMainLine301M7T) {
        return d8xMapper.insertMD8xMainLine301M7T(mD8xMainLine301M7T);
    }

    @Override
    public int insertMD8xMainLine301M8T(D8XMainLine301M8 mD8xMainLine301M8T) {
        return d8xMapper.insertMD8xMainLine301M8T(mD8xMainLine301M8T);
    }

    @Override
    public List<D8XMainLine301M8Search> searchMD8xMainLine301M8T(String Barcode, String StartTime, String EndTime) {
        return d8xMapper.searchMD8xMainLine301M8T(Barcode, StartTime, EndTime);
    }

    @Override
    public List<D8XMainLine301M9Search> searchMD8xMainLine301M9T(String Barcode, String StartTime, String EndTime) {
        return d8xMapper.searchMD8xMainLine301M9T(Barcode, StartTime, EndTime);
    }

    @Override
    public int insertMD8xMainLine301M9T(D8XMainLine301M9 mD8xMainLine301M9T) {
        return d8xMapper.insertMD8xMainLine301M9T(mD8xMainLine301M9T);
    }
}
