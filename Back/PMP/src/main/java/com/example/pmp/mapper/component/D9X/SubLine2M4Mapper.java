package com.example.pmp.mapper.component.D9X;

import com.example.pmp.pojo.component.D9X.SubLine2M4TPZ;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/1/16 10:16
 **/
@Mapper
public interface SubLine2M4Mapper {

    /**
     * 根据 MainLine1M2 中查到的码获取 SubLine2M4 中的数据集合
     *
     * @return
     */
    public List<SubLine2M4TPZ> getSubLine2M4List(@Param("BarcodeEMIList") List<String> BarcodeEMIList);

    /**
     * 根据 MainLine1M2 中查到的码获取 SubLine2M4 中的 Barcode_EMI 码数据集合
     *
     * @return
     */
    public List<String> getSubLine2M4BarcodeEMIList(@Param("BarcodeEMIList") List<String> BarcodeEMIList);

}
