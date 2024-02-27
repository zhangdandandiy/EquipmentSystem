package com.example.pmp.mapper.component.D9X;

import com.example.pmp.pojo.component.D9X.SubLine2M3TPX;
import com.example.pmp.pojo.component.D9X.SubLine2M3TPY;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/1/17 11:25
 **/
@Mapper
public interface SubLine2M3Mapper {

    /**
     * 获取 SubLine2M3TPX FAI 数据集合
     *
     * @param BarcodeEMIList
     * @return
     */
    public List<SubLine2M3TPX> getSubLine2M3TPXList(@Param("BarcodeEMIList") List<String> BarcodeEMIList);

    /**
     * 获取 SubLine2M3TPY FAI 数据集合
     *
     * @param BarcodeEMIList
     * @return
     */
    public List<SubLine2M3TPY> getSubLine2M3TPYList(@Param("BarcodeEMIList") List<String> BarcodeEMIList);

}
