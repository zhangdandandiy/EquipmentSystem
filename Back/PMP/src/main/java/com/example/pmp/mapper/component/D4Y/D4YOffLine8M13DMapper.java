package com.example.pmp.mapper.component.D4Y;

import com.example.pmp.pojo.component.D4Y.D4YOffLine8M13D;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/2/22 13:27
 **/

@Mapper
public interface D4YOffLine8M13DMapper {

    /**
     * 根据 UpperContactIMReelLOTList 查询 OffLine8M13D FAI 数据集合
     *
     * @param UpperContactIMReelLOTList
     * @return
     */
    public List<D4YOffLine8M13D> getD4YOffLine8M13DList(@Param("UpperContactIMReelLOTList") List<String> UpperContactIMReelLOTList);

    /**
     * 根据 UpperContactIMReelLOTList 查询 StampingLot 数据集合
     *
     * @param UpperContactIMReelLOTList
     * @return
     */
    public List<String> getD4YOffLine8M13DStampingLotList(@Param("UpperContactIMReelLOTList") List<String> UpperContactIMReelLOTList);

}
