package com.example.pmp.mapper.component.D9X;

import com.example.pmp.pojo.component.D9X.OffLine11M13D;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/2/23 8:41
 **/

@Mapper
public interface OffLine11M13DMapper {

    /**
     * 获取 OffLine11M13D FAI 数据集合
     *
     * @param offLine9M13DStampingLotList
     * @return
     */
    public List<OffLine11M13D> getOffLine11M13DList(@Param("offLine9M13DStampingLotList") List<String> offLine9M13DStampingLotList);

}
