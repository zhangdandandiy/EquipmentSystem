package com.example.pmp.mapper.component.D9X;

import com.example.pmp.pojo.component.D9X.OffLine9M1AOI3;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/1/18 9:04
 **/

@Mapper
public interface OffLine9M1AOI3Mapper {

    /**
     * 获取 OffLine9M1AOI3 FAI 数据集合
     *
     * @param LowerContactIMReelLOTList
     * @return
     */
    public List<OffLine9M1AOI3> getOffLine9M1AOI3List(@Param("LowerContactIMReelLOTList") List<String> LowerContactIMReelLOTList);

    /**
     * 获取 OffLine9M1AOI3 StampingLot 数据集合
     *
     * @param LowerContactIMReelLOTList
     * @return
     */
    public List<String> getOffLine9M1AOI3StampingLotList(@Param("LowerContactIMReelLOTList") List<String> LowerContactIMReelLOTList);

}
