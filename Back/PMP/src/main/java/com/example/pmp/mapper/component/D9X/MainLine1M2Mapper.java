package com.example.pmp.mapper.component.D9X;

import com.example.pmp.pojo.component.D9X.MainLine1M2;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/1/16 9:58
 **/
@Mapper
public interface MainLine1M2Mapper {

    /**
     * 根据 MainLine3M6 中查到的码获取 MainLine1M2 中的数据集合
     *
     * @return
     */
    public List<MainLine1M2> getMainLine1M2List(@Param("BarcodeHSGList") List<String> BarcodeHSGList);

    /**
     * 根据 MainLine3M6 中查到的码获取 MainLine1M2 中的 Barcode_EMI 码数据集合
     *
     * @return
     */
    public List<String> getMainLine1M2BarcodeEMIList(@Param("BarcodeHSGList") List<String> BarcodeHSGList);

}
