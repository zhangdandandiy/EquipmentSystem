package com.example.pmp.mapper.sap;

import com.example.pmp.pojo.sap.SapLot;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Dandan
 * @date 2023/10/27 9:26
 **/

@Mapper
public interface SapLotMapper {

    List<SapLot> searchSapLotList(@Param("pid") String pid,@Param("status") String status);

}
