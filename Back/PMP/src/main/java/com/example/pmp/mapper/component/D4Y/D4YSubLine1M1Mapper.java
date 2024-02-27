package com.example.pmp.mapper.component.D4Y;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/2/22 13:20
 **/

@Mapper
public interface D4YSubLine1M1Mapper {

    /**
     * 根据 Barcode_MidPlate 查询 UpperContactIM_Reel_LOT
     */
    public List<String> getUpperContactIMReelLOTList(@Param("BarcodeMidPlateList") List<String> BarcodeMidPlateList);

    /**
     * 根据 Barcode_MidPlate 查询 LowerContactIM_Reel_LOT
     */
    public List<String> getLowerContactIMReelLOTList(@Param("BarcodeMidPlateList") List<String> BarcodeMidPlateList);

}
