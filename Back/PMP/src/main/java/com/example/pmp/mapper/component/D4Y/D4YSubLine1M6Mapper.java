package com.example.pmp.mapper.component.D4Y;

import com.example.pmp.pojo.component.D4Y.D4YSubLine1M6TPX;
import com.example.pmp.pojo.component.D4Y.D4YSubLine1M6TPY;
import com.example.pmp.pojo.component.D4Y.D4YSubLine1M6TPZ;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/2/22 13:11
 **/

@Mapper
public interface D4YSubLine1M6Mapper {

    /**
     * 根据 SubLine2M1 中查到的码获取 SubLine1M6TPZ 中的数据集合
     *
     * @return
     */
    public List<D4YSubLine1M6TPZ> getD4YSubLine1M6TPZList(@Param("BarcodeMidPlateList") List<String> BarcodeMidPlateList);

    /**
     * 获取 D4YSubLine1M6TPX FAI 数据集合
     *
     * @param BarcodeMidPlateList
     * @return
     */
    public List<D4YSubLine1M6TPX> getD4YSubLine1M6TPXList(@Param("BarcodeMidPlateList") List<String> BarcodeMidPlateList);

    /**
     * 获取 D4YSubLine1M6TPY FAI 数据集合
     *
     * @param BarcodeMidPlateList
     * @return
     */
    public List<D4YSubLine1M6TPY> getD4YSubLine1M6TPYList(@Param("BarcodeMidPlateList") List<String> BarcodeMidPlateList);

}
