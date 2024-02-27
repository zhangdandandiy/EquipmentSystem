package com.example.pmp.mapper.component.D9X;

import com.example.pmp.pojo.component.D9X.SubLine2M1;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/1/16 10:08
 **/

@Mapper
public interface SubLine2M1Mapper {

    /**
     * 根据 MainLine1M2 中查到的码获取 SubLine2M1 中的数据集合
     *
     * @return
     */
    public List<SubLine2M1> getSubLine2M1List(@Param("BarcodeEMIList") List<String> BarcodeEMIList);

    /**
     * 根据 MainLine3M10 中查到的码获取 SubLine2M1 中的 Barcode_MidPlate 码数据集合
     *
     * @return
     */
    public List<String> getSubLine2M1BarcodeMidPlateList(@Param("BarcodeEMIList") List<String> BarcodeEMIList);

}
