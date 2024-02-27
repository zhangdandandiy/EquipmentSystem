package com.example.pmp.mapper.component.D9X;

import com.example.pmp.pojo.component.D9X.OffLine8M1AOI3;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/1/18 8:11
 **/

@Mapper
public interface OffLine8M1AOIMapper {

    /**
     * 获取 OffLine8M1AOI 中的数据集合
     */
    public List<OffLine8M1AOI3> getOffLine8M1AOIList(@Param("UpperContactIMReelLOTList") List<String> UpperContactIMReelLOTList);

    /**
     * 获取 OffLine8M1AOI StampingLot 数据集合
     *
     * @param UpperContactIMReelLOTList
     * @return
     */
    public List<String> getOffLine8M1AOIStampingLotList(@Param("UpperContactIMReelLOTList") List<String> UpperContactIMReelLOTList);

}
