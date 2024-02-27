package com.example.pmp.mapper.component.D4Y;

import com.example.pmp.pojo.component.D4Y.D4YMainLine3M6;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/2/22 11:04
 **/

@Mapper
public interface D4YMainLine3M6Mapper {

    /**
     * 根据 MainLine3M10 中查到的码获取 MainLine3M6 中的数据集合
     *
     * @return
     */
    public List<D4YMainLine3M6> getD4YMainLine3M6List(@Param("BarCodeList") List<String> BarCodeList);

    /**
     * 根据 MainLine3M10 中查到的码获取 MainLine3M6 中的 Barcode_HSG 码数据集合
     *
     * @return
     */
    public List<String> getD4YMainLine3M6BarcodeHSGList(@Param("BarCodeList") List<String> BarCodeList);

}
