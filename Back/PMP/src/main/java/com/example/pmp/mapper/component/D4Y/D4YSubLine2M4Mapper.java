package com.example.pmp.mapper.component.D4Y;

import com.example.pmp.pojo.component.D4Y.D4YSubLine2M4;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/2/22 12:52
 **/

@Mapper
public interface D4YSubLine2M4Mapper {

    /**
     * 根据 MainLine1M2 中查到的码获取 SubLine2M4 中的数据集合
     *
     * @return
     */
    public List<D4YSubLine2M4> getD4YSubLine2M4List(@Param("BarcodeEMIList") List<String> BarcodeEMIList);

}
