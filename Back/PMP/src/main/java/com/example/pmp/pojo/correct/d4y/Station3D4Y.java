package com.example.pmp.pojo.correct.d4y;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dandan
 * @date 2024/2/3 13:45
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Station3D4Y {

    private String Barcode;
    private String ALT;
    private String TestResult;
    private String TestTime;
    private String ModuleID;
    private String LineID;
    private String LineType;
    private String rn;

    // 模板对象
    private static Station3D4Y template;

    /**
     * 获取模板对象
     */
    public static Station3D4Y getTemplate() {
        // 在静态代码块中初始化模板对象
        template = new Station3D4Y();
        // 第三站没必要设置这个，因为第三站的良率为100%，每个都会补到
        // template.setALT(CorrectUtils.convertString(0.01,0.04));
        template.setTestResult("PASS");
        template.setRn("1");
        return template;
    }

}
