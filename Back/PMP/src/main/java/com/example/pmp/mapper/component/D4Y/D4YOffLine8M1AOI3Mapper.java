package com.example.pmp.mapper.component.D4Y;

import com.example.pmp.pojo.component.D4Y.D4YOffLine8M1AOI3;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/2/22 15:26
 **/
@Mapper
public interface D4YOffLine8M1AOI3Mapper {

    /**
     * 根据 UpperContactIMReelLOTList 获取 OffLine8M1AOI3List 数据集合
     *
     * @param UpperContactIMReelLOTList
     * @return
     */
    public List<D4YOffLine8M1AOI3> getD4YOffLine8M1AOI3List(@Param("UpperContactIMReelLOTList") List<String> UpperContactIMReelLOTList);

    /**
     * 根据 UpperContactIMReelLOTList 获取 OffLine8M1AOI3StampingLot 数据集合
     *
     * @param UpperContactIMReelLOTList
     * @return
     */
    public List<String> getOffLine8M1AOI3StampingLotList(@Param("UpperContactIMReelLOTList") List<String> UpperContactIMReelLOTList);

}
