package com.example.pmp.pojo.correct.d9x;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dandan
 * @date 2024/1/18 13:33
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Station2D9X {

    private String Barcode;
    private String Open_Result;
    // 这个字段需要格外注意
    private String OS_HIPOT_Test;
    private String TestResult;
    private String TestTime;
    private String ModuleID;
    private String LineID;
    private String LineType;
    private String rn;


    // 模板对象
    private static Station2D9X template;

    /**
     * 获取模板对象
     */
    public static Station2D9X getTemplate() {
        // 在静态代码块中初始化模板对象
        template = new Station2D9X();
        template.setOpen_Result("OK");
        template.setOS_HIPOT_Test("OK");
        template.setTestResult("PASS");
        template.setRn("1");
        return template;
    }

}
