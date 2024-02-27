package com.example.pmp.mapper.component.D4Y;

import com.example.pmp.pojo.component.D4Y.D4YOffLine9M1AOI3;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/2/22 15:54
 **/
@Mapper
public interface D4YOffLine9M1AOI3Mapper {

    /**
     * 获取 D4YOffLine9M1AOI3 FAI 数据集合
     *
     * @param LowerContactIMReelLOTList
     * @return
     */
    public List<D4YOffLine9M1AOI3> getD4YOffLine9M1AOI3List(@Param("LowerContactIMReelLOTList") List<String> LowerContactIMReelLOTList);

    /**
     * 获取 D4YOffLine9M1AOI3 StampingLot 数据集合
     *
     * @param LowerContactIMReelLOTList
     * @return
     */
    public List<String> getD4YOffLine9M1AOI3StampingLotList(@Param("LowerContactIMReelLOTList") List<String> LowerContactIMReelLOTList);

}
