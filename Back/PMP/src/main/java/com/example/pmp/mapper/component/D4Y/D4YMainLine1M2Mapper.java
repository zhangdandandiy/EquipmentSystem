package com.example.pmp.mapper.component.D4Y;

import com.example.pmp.pojo.component.D4Y.D4YMainLine1M2;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/2/22 11:17
 **/

@Mapper
public interface D4YMainLine1M2Mapper {

    /**
     * 根据 MainLine3M6 中查到的码获取 MainLine1M2 中的数据集合
     *
     * @return
     */
    public List<D4YMainLine1M2> getD4YMainLine1M2List(@Param("BarcodeHSGList") List<String> BarcodeHSGList);

    /**
     * 根据 MainLine3M6 中查到的码获取 MainLine1M2 中的 Barcode_EMI 码数据集合
     *
     * @return
     */
    public List<String> getD4YMainLine1M2BarcodeEMIList(@Param("BarcodeHSGList") List<String> BarcodeHSGList);

}
