package com.example.pmp.mapper.component.D9X;

import com.example.pmp.pojo.component.D9X.OffLine9M13D;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/1/17 10:47
 **/
@Mapper
public interface OffLine9M13DMapper {

    /**
     * 获取 OffLine9M13D FAI 数据集合
     *
     * @param LowerContactIMReelLOTList
     * @return
     */
    public List<OffLine9M13D> getOffLine9M13DList(@Param("LowerContactIMReelLOTList") List<String> LowerContactIMReelLOTList);

    /**
     * 获取 OffLine9M13D StampingLot 数据集合
     *
     * @param LowerContactIMReelLOTList
     * @return
     */
    public List<String> getOffLine9M13DStampingLotList(@Param("LowerContactIMReelLOTList") List<String> LowerContactIMReelLOTList);

}
