package com.example.pmp.service.component;

import com.example.pmp.pojo.component.ComponentFAI;
import com.example.pmp.pojo.component.dto.ComponentParam;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/2/22 10:12
 **/
public interface ComponentD4YService {

    /**
     * 获取零件尺寸数据
     *
     * @param componentParam
     * @return
     */
    public List<ComponentFAI> selectComponentFAIData(ComponentParam componentParam);

}
