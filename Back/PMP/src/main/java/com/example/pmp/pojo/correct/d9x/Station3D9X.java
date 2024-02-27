package com.example.pmp.pojo.correct.d9x;

import com.example.pmp.utils.CorrectUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dandan
 * @date 2024/1/18 14:27
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Station3D9X {

    private String Barcode;
    private String ALT;
    private String TestResult;
    private String TestTime;
    private String ModuleID;
    private String LineID;
    private String LineType;
    private String rn;

    // 模板对象
    private static Station3D9X template;

    /**
     * 获取模板对象
     */
    public static Station3D9X getTemplate() {
        // 在静态代码块中初始化模板对象
        template = new Station3D9X();
        // 第三站没必要设置这个，因为第三站的良率为100%，每个都会补到
        // template.setALT(CorrectUtils.convertString(0.01,0.04));
        template.setTestResult("PASS");
        template.setRn("1");
        return template;
    }

}
