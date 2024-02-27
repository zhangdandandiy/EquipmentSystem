package com.example.pmp.pojo.component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Dandan
 * @date 2024/1/16 11:07
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComponentData {

    /**
     * 总的 FAI 的名称
     */
    private String name;

    private List<ComponentComFAI> componentComFAIList;

}
