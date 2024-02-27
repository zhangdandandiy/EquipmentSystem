package com.example.pmp.mapper.component.D9X;

import com.example.pmp.pojo.component.D9X.MainLine3M6;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/1/16 9:48
 **/
@Mapper
public interface MainLine3M6Mapper {

    /**
     * 根据 MainLine3M10 中查到的码获取 MainLine3M6 中的数据集合
     *
     * @return
     */
    public List<MainLine3M6> getMainLine3M6List(@Param("BarCodeList") List<String> BarCodeList);

    /**
     * 根据 MainLine3M10 中查到的码获取 MainLine3M6 中的 Barcode_HSG 码数据集合
     *
     * @return
     */
    public List<String> getMainLine3M6BarcodeHSGList(@Param("BarCodeList") List<String> BarCodeList);

}
