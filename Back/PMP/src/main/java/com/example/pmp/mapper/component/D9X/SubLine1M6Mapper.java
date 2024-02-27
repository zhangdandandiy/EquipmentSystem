package com.example.pmp.mapper.component.D9X;

import com.example.pmp.pojo.component.D9X.SubLine1M6TPX;
import com.example.pmp.pojo.component.D9X.SubLine1M6TPY;
import com.example.pmp.pojo.component.D9X.SubLine1M6TPZ;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/1/16 10:22
 **/
@Mapper
public interface SubLine1M6Mapper {

    /**
     * 根据 SubLine2M1 中查到的码获取 SubLine1M6TPZ 中的数据集合
     *
     * @return
     */
    public List<SubLine1M6TPZ> getSubLine1M6TPZList(@Param("BarcodeMidPlateList") List<String> BarcodeMidPlateList);

    /**
     * 获取 SubLine1M6TPX 中的数据集合
     *
     * @param BarcodeMidPlateList
     * @return
     */
    public List<SubLine1M6TPX> getSubLine1M6TPXList(@Param("BarcodeMidPlateList") List<String> BarcodeMidPlateList);

    /**
     * 获取 SubLine1M6TPY 中的数据集合
     *
     * @param BarcodeMidPlateList
     * @return
     */
    public List<SubLine1M6TPY> getSubLine1M6TPYList(@Param("BarcodeMidPlateList") List<String> BarcodeMidPlateList);

    /**
     * 根据 SubLine2M1 中查到的码获取 SubLine1M6 中的 Barcode_EMI 码数据集合
     *
     * @return
     */
    public List<String> getSubLine1M6BarcodeMidPlateList(@Param("BarcodeMidPlateList") List<String> BarcodeMidPlateList);

}
