package com.example.pmp.mapper.component.D4Y;

import com.example.pmp.pojo.component.D4Y.D4YOffLine11M13D;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/2/22 14:42
 **/

@Mapper
public interface D4YOffLine11M13DMapper {

    /**
     * 根据 OffLine9M13DStampingLotList 获取 OffLine11M13D FAI 数据集合
     *
     * @param OffLine9M13DStampingLotList
     * @return
     */
    public List<D4YOffLine11M13D> getD4YOffLine11M13DList(@Param("OffLine9M13DStampingLotList") List<String> OffLine9M13DStampingLotList);

}
