package com.example.pmp.mapper.component.D4Y;

import com.example.pmp.pojo.component.D4Y.D4YSubLine2M3TPX;
import com.example.pmp.pojo.component.D4Y.D4YSubLine2M3TPY;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/2/22 15:04
 **/

@Mapper
public interface D4YSubLine2M3Mapper {

    /**
     * 根据 BarcodeEMIList 获取 SubLine2M3TPX FAI 数据集合
     *
     * @param BarcodeEMIList
     * @return
     */
    public List<D4YSubLine2M3TPX> getD4YSubLine2M3TPXList(@Param("BarcodeEMIList") List<String> BarcodeEMIList);

    /**
     * 获取 D4YSubLine2M3TPY FAI 数据集合
     *
     * @param BarcodeEMIList
     * @return
     */
    public List<D4YSubLine2M3TPY> getD4YSubLine2M3TPYList(@Param("BarcodeEMIList") List<String> BarcodeEMIList);

}
