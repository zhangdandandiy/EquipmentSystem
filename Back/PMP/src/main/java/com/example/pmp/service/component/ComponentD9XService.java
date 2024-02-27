package com.example.pmp.service.component;

import com.example.pmp.pojo.component.ComponentData;
import com.example.pmp.pojo.component.ComponentFAI;
import com.example.pmp.pojo.component.dto.ComponentParam;

import java.util.List;

/**
 * @author Dandan
 * @date 2024/1/16 10:36
 **/
public interface ComponentD9XService {

    /**
     * 获取零件尺寸数据
     *
     * @param componentParam
     * @return
     */
    public List<ComponentFAI> selectComponentFAIData(ComponentParam componentParam);

}
