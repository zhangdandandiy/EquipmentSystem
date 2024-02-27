package com.example.pmp.mapper.component.D4Y;

import com.example.pmp.pojo.component.D4Y.D4YOffLine9M13D;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/2/22 13:43
 **/

@Mapper
public interface D4YOffLine9M13DMapper {

    /**
     * 根据 LowerContactIMReelLOTList 获取 OffLine9M13D 数据集合
     *
     * @param LowerContactIMReelLOTList
     * @return
     */
    public List<D4YOffLine9M13D> getD4YOffLine9M13DList(@Param("LowerContactIMReelLOTList") List<String> LowerContactIMReelLOTList);

    /**
     * 根据 LowerContactIMReelLOTList 获取 StampingLot 数据集合
     *
     * @param LowerContactIMReelLOTList
     * @return
     */
    public List<String> getD4YOffLine9M13DStampingLotList(@Param("LowerContactIMReelLOTList") List<String> LowerContactIMReelLOTList);

}
