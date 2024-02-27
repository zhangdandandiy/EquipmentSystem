package com.example.pmp.pojo.correct.d9x;

import com.example.pmp.utils.CorrectUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dandan
 * @date 2024/1/18 19:12
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Station41D9X {

    private String Barcode;
    private String CCD2_FAI48;
    private String CCD2_FAI9;
    private String CCD2_FAI37_1;
    private String CCD2_FAI37_2;
    private String CCD2_FAI37_3;
    private String CCD2_FAI37_4;
    private String CCD2_FAI37_5;
    private String CCD2_FAI37_6;
    private String CCD2_FAI37_7;
    private String CCD2_FAI37_8;
    private String CCD2_FAI37_9;
    private String CCD2_FAI37_10;
    private String CCD2_FAI37_11;
    private String CCD2_FAI37_12;
    private String CCD2_FAI38_1;
    private String CCD2_FAI38_2;
    private String CCD2_FAI38_3;
    private String CCD2_FAI38_4;
    private String CCD2_FAI38_5;
    private String CCD2_FAI38_6;
    private String CCD2_FAI38_7;
    private String CCD2_FAI38_8;
    private String CCD2_FAI38_9;
    private String CCD2_FAI38_10;
    private String CCD2_FAI38_11;
    private String CCD2_FAI38_12;
    private String TestResult;
    private String TestTime;
    private String ModuleID;
    private String LineID;
    private String LineType;
    private String rn;

    // 模板对象
    private static Station41D9X template;

    /**
     * 获取模板对象
     */
    public static Station41D9X getTemplate() {
        // 在静态代码块中初始化模板对象
        template = new Station41D9X();
        template.setCCD2_FAI48(CorrectUtils.convertString(3.5, 4));
        template.setCCD2_FAI9(CorrectUtils.convertString(7.5, 8));
        template.setCCD2_FAI37_1(CorrectUtils.convertString(0.55, 0.80));
        template.setCCD2_FAI37_2(CorrectUtils.convertString(0.55, 0.80));
        template.setCCD2_FAI37_3(CorrectUtils.convertString(0.55, 0.80));
        template.setCCD2_FAI37_4(CorrectUtils.convertString(0.55, 0.80));
        template.setCCD2_FAI37_5(CorrectUtils.convertString(0.55, 0.80));
        template.setCCD2_FAI37_6(CorrectUtils.convertString(0.55, 0.80));
        template.setCCD2_FAI37_7(CorrectUtils.convertString(0.55, 0.80));
        template.setCCD2_FAI37_8(CorrectUtils.convertString(0.55, 0.80));
        template.setCCD2_FAI37_9(CorrectUtils.convertString(0.55, 0.80));
        template.setCCD2_FAI37_10(CorrectUtils.convertString(0.55, 0.80));
        template.setCCD2_FAI37_11(CorrectUtils.convertString(0.55, 0.80));
        template.setCCD2_FAI37_12(CorrectUtils.convertString(0.55, 0.80));
        template.setCCD2_FAI38_1(CorrectUtils.convertString(-0.05, 0.05));
        template.setCCD2_FAI38_2(CorrectUtils.convertString(-0.05, 0.05));
        template.setCCD2_FAI38_3(CorrectUtils.convertString(-0.05, 0.05));
        template.setCCD2_FAI38_4(CorrectUtils.convertString(-0.05, 0.05));
        template.setCCD2_FAI38_5(CorrectUtils.convertString(-0.05, 0.05));
        template.setCCD2_FAI38_6(CorrectUtils.convertString(-0.05, 0.05));
        template.setCCD2_FAI38_7(CorrectUtils.convertString(-0.05, 0.05));
        template.setCCD2_FAI38_8(CorrectUtils.convertString(-0.05, 0.05));
        template.setCCD2_FAI38_9(CorrectUtils.convertString(-0.05, 0.05));
        template.setCCD2_FAI38_10(CorrectUtils.convertString(-0.05, 0.05));
        template.setCCD2_FAI38_11(CorrectUtils.convertString(-0.05, 0.05));
        template.setCCD2_FAI38_12(CorrectUtils.convertString(-0.05, 0.05));
        template.setTestResult("PASS");
        template.setRn("1");
        return template;
    }

}
