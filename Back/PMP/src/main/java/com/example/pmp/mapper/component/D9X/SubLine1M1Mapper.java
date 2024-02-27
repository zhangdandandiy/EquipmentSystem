package com.example.pmp.mapper.component.D9X;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/1/17 10:03
 **/

@Mapper
public interface SubLine1M1Mapper {

    /**
     * 根据 Barcode_MidPlate 查询 UpperContactIM_Reel_LOT
     */
    public List<String> getUpperContactIMReelLOTList(@Param("BarcodeMidPlateList") List<String> BarcodeMidPlateList);

    /**
     * 根据 Barcode_MidPlate 查询 LowerContactIM_Reel_LOT
     */
    public List<String> getLowerContactIMReelLOTList(@Param("BarcodeMidPlateList") List<String> BarcodeMidPlateList);

}
