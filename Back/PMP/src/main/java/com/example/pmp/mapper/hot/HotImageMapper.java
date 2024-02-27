package com.example.pmp.mapper.hot;

import com.example.pmp.pojo.hot.HotImage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/1/29 13:37
 **/

@Mapper
public interface HotImageMapper {

    /**
     * 查询热力图图片资源
     *
     * @param id 热力图图片资源主键
     * @return 热力图图片资源
     */
    public HotImage selectHotImageById(Long id);

    /**
     * 查询热力图图片资源列表
     *
     * @param hotImage 热力图图片资源
     * @return 热力图图片资源集合
     */
    public List<HotImage> selectHotImageList(HotImage hotImage);

    /**
     * 查询热力图图片资源列表
     *
     * @param hotImage 热力图图片资源
     * @return 热力图图片资源集合
     */
    public List<String> selectHotImageURLList(HotImage hotImage);

}
