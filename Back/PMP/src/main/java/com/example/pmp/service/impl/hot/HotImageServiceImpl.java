package com.example.pmp.service.impl.hot;

import com.example.pmp.mapper.hot.HotImageMapper;
import com.example.pmp.pojo.hot.HotImage;
import com.example.pmp.service.hot.HotImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/1/29 13:41
 **/

@Service
public class HotImageServiceImpl implements HotImageService {

    @Autowired
    private HotImageMapper hotImageMapper;

    /**
     * 查询热力图图片资源
     *
     * @param id 热力图图片资源主键
     * @return 热力图图片资源
     */
    @Override
    public HotImage selectHotImageById(Long id) {
        return hotImageMapper.selectHotImageById(id);
    }

    /**
     * 查询热力图图片资源列表
     *
     * @param HotImage 热力图图片资源
     * @return 热力图图片资源集合
     */
    @Override
    public List<HotImage> selectHotImageList(HotImage hotImage) {
        return hotImageMapper.selectHotImageList(hotImage);
    }

    /**
     * 查询热力图图片资源列表
     *
     * @param hotImage 热力图图片资源
     * @return 热力图图片资源集合
     */
    @Override
    public List<String> selectHotImageURLList(HotImage hotImage) {
        return hotImageMapper.selectHotImageURLList(hotImage);
    }

}
