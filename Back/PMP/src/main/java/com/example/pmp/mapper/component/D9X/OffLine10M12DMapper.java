package com.example.pmp.mapper.component.D9X;

import com.example.pmp.pojo.component.D9X.OffLine10M12D;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/2/23 9:05
 **/

@Mapper
public interface OffLine10M12DMapper {

    /**
     * 获取 OffLine10M12D FAI 数据集合
     *
     * @param OffLine8M1AOIStampingLotList
     * @return
     */
    public List<OffLine10M12D> getOffLine10M12DList(@Param("OffLine8M1AOIStampingLotList") List<String> OffLine8M1AOIStampingLotList);

}
