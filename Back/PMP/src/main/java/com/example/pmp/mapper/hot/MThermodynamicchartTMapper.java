package com.example.pmp.mapper.hot;

import com.example.pmp.pojo.hot.MThermodynamicchartT;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Dandan
 * @date 2024/1/16 18:54
 **/

@Mapper
public interface MThermodynamicchartTMapper {

    /**
     * 新增热力图数据
     *
     * @param mThermodynamicchartT 热力图数据
     * @return 结果
     */
    public int insertMThermodynamicchartT(MThermodynamicchartT mThermodynamicchartT);

}
