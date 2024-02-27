package com.example.pmp.mapper.component.D4Y;

import com.example.pmp.pojo.component.D4Y.D4YOffLine10M13D;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/2/22 14:31
 **/
@Mapper
public interface D4YOffLine10M13DMapper {

    /**
     * 根据 OffLine8M13DStampingLotList 获取 FAI 数据集合
     *
     * @param OffLine8M13DStampingLotList
     * @return
     */
    public List<D4YOffLine10M13D> getD4YOffLine10M13DList(@Param("OffLine8M13DStampingLotList") List<String> OffLine8M13DStampingLotList);

}
