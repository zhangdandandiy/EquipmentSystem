package com.example.pmp.mapper.component.D9X;

import com.example.pmp.pojo.component.D9X.OffLine11M12D;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/2/23 9:20
 **/

@Mapper
public interface OffLine11M12DMapper {

    /**
     * 获取 OffLine11M12D FAI 数据集合
     *
     * @param OffLine9M1AOI3StampingLotList
     * @return
     */
    public List<OffLine11M12D> getOffLine11M12DList(@Param("OffLine9M1AOI3StampingLotList") List<String> OffLine9M1AOI3StampingLotList);

}
