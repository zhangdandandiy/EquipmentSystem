package com.example.pmp.mapper.component.D9X;

import com.example.pmp.pojo.component.D9X.OffLine8M13D;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/1/17 10:33
 **/
@Mapper
public interface OffLine8M13DMapper {

    /**
     * 根据 UpperContactIMReelLOTList 查询 OffLine8M13D FAI 数据集合
     *
     * @param UpperContactIMReelLOTList
     * @return
     */
    public List<OffLine8M13D> getOffLine8M13DList(@Param("UpperContactIMReelLOTList") List<String> UpperContactIMReelLOTList);

    /**
     * 获取 OffLine8M13DStampingLot 数据集合
     *
     * @param UpperContactIMReelLOTList
     * @return
     */
    public List<String> getOffLine8M13DStampingLotList(@Param("UpperContactIMReelLOTList") List<String> UpperContactIMReelLOTList);

}
