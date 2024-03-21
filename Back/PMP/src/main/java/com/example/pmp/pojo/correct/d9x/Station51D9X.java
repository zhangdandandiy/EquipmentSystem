package com.example.pmp.pojo.correct.d9x;

import com.example.pmp.utils.CorrectUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dandan
 * @date 2024/1/19 8:52
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Station51D9X {

    // 模板对象
    private static Station51D9X template;
    private String Barcode;
    private String CCD6_FAI1;
    private String CCD7_FAI31_1;
    private String CCD7_FAI61_1;
    private String CCD7_FAI31_2;
    private String CCD7_FAI61_2;
    private String CCD7_FAI57_1;
    private String CCD7_FAI63_1;
    private String CCD7_FAI57_2;
    private String CCD7_FAI63_2;
    private String CCD7_FAI46;
    private String CCD7_FAI5;
    private String CCD7_FAI34_1;
    private String CCD7_FAI34_2;
    private String CCD7_FAI34_3;
    private String CCD7_FAI34_4;
    private String CCD7_FAI34_5;
    private String CCD7_FAI34_6;
    private String CCD7_FAI34_7;
    private String CCD7_FAI34_8;
    private String CCD7_FAI34_9;
    private String CCD7_FAI34_10;
    private String CCD7_FAI34_11;
    private String CCD7_FAI34_12;
    private String CCD7_FAI34_13;
    private String CCD7_FAI34_14;
    private String CCD7_FAI34_15;
    private String CCD7_FAI34_16;
    private String CCD7_FAI34_17;
    private String CCD7_FAI34_18;
    private String CCD7_FAI34_19;
    private String CCD7_FAI34_20;
    private String CCD7_FAI34_21;
    private String CCD7_FAI34_22;
    private String CCD7_FAI34_23;
    private String CCD7_FAI34_24;
    private String CCD7_FAI34_25;
    private String CCD7_FAI34_26;
    private String CCD7_FAI34_27;
    private String CCD7_FAI34_28;
    private String CCD7_FAI43_1;
    private String CCD7_FAI43_2;
    private String CCD7_FAI43_3;
    private String CCD7_FAI43_4;
    private String CCD7_FAI43_5;
    private String CCD7_FAI43_6;
    private String CCD7_FAI43_7;
    private String CCD7_FAI43_8;
    private String CCD7_FAI43_9;
    private String CCD7_FAI43_10;
    private String CCD7_FAI43_11;
    private String CCD7_FAI43_12;
    private String CCD7_FAI43_13;
    private String CCD7_FAI43_14;
    private String CCD7_FAI43_15;
    private String CCD7_FAI43_16;
    private String CCD7_FAI43_17;
    private String CCD7_FAI43_18;
    private String CCD7_FAI43_19;
    private String CCD7_FAI43_20;
    private String CCD7_FAI43_21;
    private String CCD7_FAI43_22;
    private String CCD7_FAI43_23;
    private String CCD7_FAI43_24;
    private String CCD7_FAI43_25;
    private String CCD7_FAI43_26;
    private String CCD7_FAI43_27;
    private String CCD7_FAI43_28;
    private String Scan_FAI2_1;
    private String Scan_FAI2_2;
    private String Scan_FAI2_3;
    private String Scan_FAI2_4;
    private String Scan_FAI2_5;
    private String Scan_FAI2_6;
    private String Scan_FAI2_7;
    private String Scan_FAI2_8;
    private String Scan_FAI2_9;
    private String Scan_FAI2_10;
    private String Scan_FAI2_11;
    private String Scan_FAI2_12;
    private String Scan_FAI2_13;
    private String Scan_FAI2_14;
    private String Scan_FAI2_15;
    private String Scan_FAI2_16;
    private String Scan_FAI2_17;
    private String Scan_FAI2_18;
    private String Scan_FAI2_19;
    private String Scan_FAI2_20;
    private String Scan_FAI2_21;
    private String Scan_FAI2_22;
    private String Scan_FAI2_23;
    private String Scan_FAI2_24;
    private String Scan_FAI2_25;
    private String Scan_FAI2_26;
    private String Scan_FAI2_27;
    private String Scan_FAI2_28;
    private String Scan_FAI2_29;
    private String Scan_FAI2_30;
    private String Scan_FAI2_31;
    private String Scan_FAI2_32;
    private String Scan_FAI2_33;
    private String Scan_FAI2_34;
    private String Scan_FAI2_35;
    private String Scan_FAI2_36;
    private String Scan_FAI2_37;

    private String CCD7_FAI75_1;
    private String CCD7_FAI75_2;
    private String CCD7_FAI75_3;
    private String CCD7_FAI74_1;
    private String CCD7_FAI74_2;
    private String CCD7_FAI74_3;
    private String CCD7_FAI31_3;
    private String CCD7_FAI31_4;
    private String CCD7_FAI31_5;

    // 注意这个字段
    private String SCAN_FAI2;

    private String TestResult;
    private String TestTime;
    private String ModuleID;
    private String LineID;
    private String LineType;
    private String rn;

    /**
     * 获取模板对象
     */
    public static Station51D9X getTemplate() {
        // 在静态代码块中初始化模板对象
        template = new Station51D9X();
        template.setCCD6_FAI1(CorrectUtils.convertString(0, 0.05));
        template.setCCD7_FAI31_1(CorrectUtils.convertString(-0.06, 0.06));
        template.setCCD7_FAI61_1(CorrectUtils.convertString(-0.06, 0.06));
        template.setCCD7_FAI31_2(CorrectUtils.convertString(-0.06, 0.06));
        template.setCCD7_FAI61_2(CorrectUtils.convertString(-0.06, 0.06));
        template.setCCD7_FAI57_1(CorrectUtils.convertString(-0.06, 0.06));
        template.setCCD7_FAI63_1(CorrectUtils.convertString(-0.06, 0.06));
        template.setCCD7_FAI57_2(CorrectUtils.convertString(-0.06, 0.06));
        template.setCCD7_FAI63_2(CorrectUtils.convertString(-0.06, 0.06));
        template.setCCD7_FAI46(CorrectUtils.convertString(-0.06, 0.06));
        template.setCCD7_FAI5(CorrectUtils.convertString(-0.70, 0.90));
        template.setCCD7_FAI34_1(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI34_2(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI34_3(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI34_4(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI34_5(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI34_6(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI34_7(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI34_8(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI34_9(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI34_10(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI34_11(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI34_12(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI34_13(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI34_14(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI34_15(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI34_16(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI34_17(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI34_18(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI34_19(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI34_20(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI34_21(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI34_22(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI34_23(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI34_24(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI34_25(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI34_26(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI34_27(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI34_28(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI43_1(CorrectUtils.convertString(-0.09, 0.09));
        template.setCCD7_FAI43_2(CorrectUtils.convertString(-0.09, 0.09));
        template.setCCD7_FAI43_3(CorrectUtils.convertString(-0.09, 0.09));
        template.setCCD7_FAI43_4(CorrectUtils.convertString(-0.09, 0.09));
        template.setCCD7_FAI43_5(CorrectUtils.convertString(-0.09, 0.09));
        template.setCCD7_FAI43_6(CorrectUtils.convertString(-0.09, 0.09));
        template.setCCD7_FAI43_7(CorrectUtils.convertString(-0.09, 0.09));
        template.setCCD7_FAI43_8(CorrectUtils.convertString(-0.09, 0.09));
        template.setCCD7_FAI43_9(CorrectUtils.convertString(-0.09, 0.09));
        template.setCCD7_FAI43_10(CorrectUtils.convertString(-0.09, 0.09));
        template.setCCD7_FAI43_11(CorrectUtils.convertString(-0.09, 0.09));
        template.setCCD7_FAI43_12(CorrectUtils.convertString(-0.09, 0.09));
        template.setCCD7_FAI43_13(CorrectUtils.convertString(-0.09, 0.09));
        template.setCCD7_FAI43_14(CorrectUtils.convertString(-0.09, 0.09));
        template.setCCD7_FAI43_15(CorrectUtils.convertString(-0.09, 0.09));
        template.setCCD7_FAI43_16(CorrectUtils.convertString(-0.09, 0.09));
        template.setCCD7_FAI43_17(CorrectUtils.convertString(-0.09, 0.09));
        template.setCCD7_FAI43_18(CorrectUtils.convertString(-0.09, 0.09));
        template.setCCD7_FAI43_19(CorrectUtils.convertString(-0.09, 0.09));
        template.setCCD7_FAI43_20(CorrectUtils.convertString(-0.09, 0.09));
        template.setCCD7_FAI43_21(CorrectUtils.convertString(-0.09, 0.09));
        template.setCCD7_FAI43_22(CorrectUtils.convertString(-0.09, 0.09));
        template.setCCD7_FAI43_23(CorrectUtils.convertString(-0.09, 0.09));
        template.setCCD7_FAI43_24(CorrectUtils.convertString(-0.09, 0.09));
        template.setCCD7_FAI43_25(CorrectUtils.convertString(-0.09, 0.09));
        template.setCCD7_FAI43_26(CorrectUtils.convertString(-0.09, 0.09));
        template.setCCD7_FAI43_27(CorrectUtils.convertString(-0.09, 0.09));
        template.setCCD7_FAI43_28(CorrectUtils.convertString(-0.09, 0.09));
        template.setScan_FAI2_1(CorrectUtils.convertString(0, 0.09));
        template.setScan_FAI2_2(CorrectUtils.convertString(0, 0.09));
        template.setScan_FAI2_3(CorrectUtils.convertString(0, 0.09));
        template.setScan_FAI2_4(CorrectUtils.convertString(0, 0.10));
        template.setScan_FAI2_5(CorrectUtils.convertString(0, 0.10));
        template.setScan_FAI2_6(CorrectUtils.convertString(0, 0.10));
        template.setScan_FAI2_7(CorrectUtils.convertString(0, 0.10));
        template.setScan_FAI2_8(CorrectUtils.convertString(0, 0.10));
        template.setScan_FAI2_9(CorrectUtils.convertString(0, 0.10));
        template.setScan_FAI2_10(CorrectUtils.convertString(0, 0.10));
        template.setScan_FAI2_11(CorrectUtils.convertString(0, 0.10));
        template.setScan_FAI2_12(CorrectUtils.convertString(0, 0.10));
        template.setScan_FAI2_13(CorrectUtils.convertString(0, 0.10));
        template.setScan_FAI2_14(CorrectUtils.convertString(0, 0.10));
        template.setScan_FAI2_15(CorrectUtils.convertString(0, 0.10));
        template.setScan_FAI2_16(CorrectUtils.convertString(0, 0.10));
        template.setScan_FAI2_17(CorrectUtils.convertString(0, 0.10));
        template.setScan_FAI2_18(CorrectUtils.convertString(0, 0.10));
        template.setScan_FAI2_19(CorrectUtils.convertString(0, 0.10));
        template.setScan_FAI2_20(CorrectUtils.convertString(0, 0.10));
        template.setScan_FAI2_21(CorrectUtils.convertString(0, 0.10));
        template.setScan_FAI2_22(CorrectUtils.convertString(0, 0.10));
        template.setScan_FAI2_23(CorrectUtils.convertString(0, 0.10));
        template.setScan_FAI2_24(CorrectUtils.convertString(0, 0.10));
        template.setScan_FAI2_25(CorrectUtils.convertString(0, 0.10));
        template.setScan_FAI2_26(CorrectUtils.convertString(0, 0.10));
        template.setScan_FAI2_27(CorrectUtils.convertString(0, 0.10));
        template.setScan_FAI2_28(CorrectUtils.convertString(0, 0.10));
        template.setScan_FAI2_29(CorrectUtils.convertString(0, 0.10));
        template.setScan_FAI2_30(CorrectUtils.convertString(0, 0.10));
        template.setScan_FAI2_31(CorrectUtils.convertString(0, 0.10));
        template.setScan_FAI2_32(CorrectUtils.convertString(0, 0.10));
        template.setScan_FAI2_33(CorrectUtils.convertString(0, 0.10));
        template.setScan_FAI2_34(CorrectUtils.convertString(0, 0.10));
        template.setScan_FAI2_35(CorrectUtils.convertString(0, 0.10));
        template.setScan_FAI2_36(CorrectUtils.convertString(0, 0.10));
        template.setScan_FAI2_37(CorrectUtils.convertString(0, 0.10));

        template.setCCD7_FAI75_1(CorrectUtils.convertString(-0.06, 0.06));
        template.setCCD7_FAI75_2(CorrectUtils.convertString(-0.06, 0.06));
        template.setCCD7_FAI75_3(CorrectUtils.convertString(-0.06, 0.06));
        template.setCCD7_FAI74_1(CorrectUtils.convertString(-0.06, 0.06));
        template.setCCD7_FAI74_2(CorrectUtils.convertString(-0.06, 0.06));
        template.setCCD7_FAI74_3(CorrectUtils.convertString(-0.06, 0.06));
        template.setCCD7_FAI31_3(CorrectUtils.convertString(0, 0.15));
        template.setCCD7_FAI31_4(CorrectUtils.convertString(0, 0.15));
        template.setCCD7_FAI31_5(CorrectUtils.convertString(0, 0.15));
        template.setSCAN_FAI2(CorrectUtils.convertString(0, 0.10));

        template.setTestResult("PASS");
        template.setRn("1");
        return template;
    }

}
