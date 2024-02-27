package com.example.pmp.mapper.component.D9X;

import com.example.pmp.pojo.component.D9X.OffLine10M13D;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/2/23 8:15
 **/

@Mapper
public interface OffLine10M13DMapper {

    /**
     * 获取 OffLine10M13D FAI 数据集合
     *
     * @param offLine8M13DStampingLotList
     * @return
     */
    public List<OffLine10M13D> getOffLine10M13DList(@Param("offLine8M13DStampingLotList") List<String> offLine8M13DStampingLotList);

}
