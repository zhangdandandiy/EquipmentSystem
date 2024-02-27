package com.example.pmp.mapper.component.D4Y;

import com.example.pmp.pojo.component.D4Y.D4YSubLine2M1;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/2/22 12:38
 **/

@Mapper
public interface D4YSubLine2M1Mapper {

    /**
     * 根据 MainLine1M2 中查到的码获取 SubLine2M1 中的数据集合
     *
     * @return
     */
    public List<D4YSubLine2M1> getD4YSubLine2M1List(@Param("BarcodeEMIList") List<String> BarcodeEMIList);

    /**
     * 根据 MainLine3M10 中查到的码获取 SubLine2M1 中的 Barcode_MidPlate 码数据集合
     *
     * @return
     */
    public List<String> getD4YSubLine2M1BarcodeMidPlateList(@Param("BarcodeEMIList") List<String> BarcodeEMIList);

}
