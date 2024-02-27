package com.example.pmp.mapper.hot;

import com.example.pmp.pojo.hot.HotFace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Dandan
 * @date 2024/1/13 13:14
 **/
@Mapper
public interface HotFaceMapper {

    /**
     * 根据面的名称获取横纵坐标偏移量
     *
     * @param FaceName
     * @return
     */
    public HotFace selectHotFaceByName(@Param("LineID") String LineID, @Param("FaceName") String FaceName);

}
