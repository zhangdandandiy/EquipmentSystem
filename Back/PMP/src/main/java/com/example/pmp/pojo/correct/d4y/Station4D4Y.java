package com.example.pmp.pojo.correct.d4y;

import com.example.pmp.utils.CorrectUtils;
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
public class Station4D4Y {

    private String Barcode;
    private String CCD2_FAI19;
    private String CCD2_FAI698;
    // 格外注意以下字段
    private String CCD2_FAI44_1;
    private String CCD2_FAI44_2;
    private String CCD2_FAI44_3;
    private String CCD2_FAI44_4;
    private String CCD2_FAI44_5;
    private String CCD2_FAI44_6;
    private String CCD2_FAI44_7;
    private String CCD2_FAI44_8;
    private String CCD2_FAI44_9;
    private String CCD2_FAI44_10;
    private String CCD2_FAI44_11;
    private String CCD2_FAI44_12;
    private String CCD2_FAI45_1;
    private String CCD2_FAI45_2;
    private String CCD2_FAI45_3;
    private String CCD2_FAI45_4;
    private String CCD2_FAI45_5;
    private String CCD2_FAI45_6;
    private String CCD2_FAI45_7;
    private String CCD2_FAI45_8;
    private String CCD2_FAI45_9;
    private String CCD2_FAI45_10;
    private String CCD2_FAI45_11;
    private String CCD2_FAI45_12;
    private String TestResult;
    private String TestTime;
    private String ModuleID;
    private String LineID;
    private String LineType;
    private String rn;

    // 模板对象
    private static Station4D4Y template;

    /**
     * 获取模板对象
     */
    public static Station4D4Y getTemplate() {
        // 在静态代码块中初始化模板对象
        template = new Station4D4Y();
        template.setCCD2_FAI19(CorrectUtils.convertString(7.5, 8));
        template.setCCD2_FAI698(CorrectUtils.convertString(3.5, 4));
        template.setCCD2_FAI44_1(CorrectUtils.convertString(0.55, 0.80));
        template.setCCD2_FAI44_2(CorrectUtils.convertString(0.55, 0.80));
        template.setCCD2_FAI44_3(CorrectUtils.convertString(0.55, 0.80));
        template.setCCD2_FAI44_4(CorrectUtils.convertString(0.55, 0.80));
        template.setCCD2_FAI44_5(CorrectUtils.convertString(0.55, 0.80));
        template.setCCD2_FAI44_6(CorrectUtils.convertString(0.55, 0.80));
        template.setCCD2_FAI44_7(CorrectUtils.convertString(0.55, 0.80));
        template.setCCD2_FAI44_8(CorrectUtils.convertString(0.55, 0.80));
        template.setCCD2_FAI44_9(CorrectUtils.convertString(0.55, 0.80));
        template.setCCD2_FAI44_10(CorrectUtils.convertString(0.55, 0.80));
        template.setCCD2_FAI44_11(CorrectUtils.convertString(0.55, 0.80));
        template.setCCD2_FAI44_12(CorrectUtils.convertString(0.55, 0.80));
        template.setCCD2_FAI45_1(CorrectUtils.convertString(-0.05, 0.05));
        template.setCCD2_FAI45_2(CorrectUtils.convertString(-0.05, 0.05));
        template.setCCD2_FAI45_3(CorrectUtils.convertString(-0.05, 0.05));
        template.setCCD2_FAI45_4(CorrectUtils.convertString(-0.05, 0.05));
        template.setCCD2_FAI45_5(CorrectUtils.convertString(-0.05, 0.05));
        template.setCCD2_FAI45_6(CorrectUtils.convertString(-0.05, 0.05));
        template.setCCD2_FAI45_7(CorrectUtils.convertString(-0.05, 0.05));
        template.setCCD2_FAI45_8(CorrectUtils.convertString(-0.05, 0.05));
        template.setCCD2_FAI45_9(CorrectUtils.convertString(-0.05, 0.05));
        template.setCCD2_FAI45_10(CorrectUtils.convertString(-0.05, 0.05));
        template.setCCD2_FAI45_11(CorrectUtils.convertString(-0.05, 0.05));
        template.setCCD2_FAI45_12(CorrectUtils.convertString(-0.05, 0.05));
        template.setTestResult("PASS");
        template.setRn("1");
        return template;
    }

}
