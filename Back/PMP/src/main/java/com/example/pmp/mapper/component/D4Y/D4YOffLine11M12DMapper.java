package com.example.pmp.mapper.component.D4Y;

import com.example.pmp.pojo.component.D4Y.D4YOffLine11M12D;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/2/22 16:15
 **/
@Mapper
public interface D4YOffLine11M12DMapper {

    /**
     * 获取 D4YOffLine11M12D FAI 数据集合
     *
     * @param OffLine9M1AOI3StampingLotList
     * @return
     */
    public List<D4YOffLine11M12D> getD4YOffLine11M12DList(@Param("OffLine9M1AOI3StampingLotList") List<String> OffLine9M1AOI3StampingLotList);

}
