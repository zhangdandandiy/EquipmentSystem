package com.example.pmp.mapper.component.D4Y;

import com.example.pmp.pojo.component.D4Y.D4YOffLine10M12D;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/2/22 15:22
 **/

@Mapper
public interface D4YOffLine10M12DMapper {

    /**
     * 获取 D4YOffLine10M12D FAI 数据集合
     *
     * @param OffLine8M1AOI3StampingLotList
     * @return
     */
    public List<D4YOffLine10M12D> getD4YOffLine10M12DList(@Param("OffLine8M1AOI3StampingLotList") List<String> OffLine8M1AOI3StampingLotList);

}
