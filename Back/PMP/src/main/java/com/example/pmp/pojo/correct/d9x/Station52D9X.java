package com.example.pmp.pojo.correct.d9x;

import com.example.pmp.utils.CorrectUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dandan
 * @date 2024/1/19 13:29
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Station52D9X {

    private String Barcode;
    private String CCD6_FAI1;
    private String CCD7_FAI17;
    private String CCD7_FAI12;
    private String CCD7_FAI626_1;
    private String CCD7_FAI626_2;
    private String CCD7_FAI626_3;
    private String CCD7_FAI626_4;
    private String CCD7_FAI626_5;
    private String CCD7_FAI626_6;
    private String CCD7_FAI626_7;
    private String CCD7_FAI626_8;
    private String CCD7_FAI626_9;
    private String CCD7_FAI626_10;
    private String CCD7_FAI626_11;
    private String CCD7_FAI626_12;
    private String CCD7_FAI626_13;
    private String CCD7_FAI626_14;
    private String CCD7_FAI626_15;
    private String CCD7_FAI626_16;
    private String CCD7_FAI626_17;
    private String CCD7_FAI626_18;
    private String CCD7_FAI626_19;
    private String CCD7_FAI626_20;
    private String CCD7_FAI626_21;
    private String CCD7_FAI626_22;
    private String CCD7_FAI626_23;
    private String CCD7_FAI626_24;
    private String CCD7_FAI626_25;
    private String CCD7_FAI626_26;
    private String CCD7_FAI626_27;
    private String CCD7_FAI626_28;
    private String CCD7_FAI28_1;
    private String CCD7_FAI28_2;
    private String CCD7_FAI28_3;
    private String CCD7_FAI28_4;
    private String CCD7_FAI28_5;
    private String CCD7_FAI28_6;
    private String CCD7_FAI28_7;
    private String CCD7_FAI28_8;
    private String CCD7_FAI28_9;
    private String CCD7_FAI28_10;
    private String CCD7_FAI28_11;
    private String CCD7_FAI28_12;
    private String CCD7_FAI28_13;
    private String CCD7_FAI28_14;
    private String CCD7_FAI28_15;
    private String CCD7_FAI28_16;
    private String CCD7_FAI28_17;
    private String CCD7_FAI28_18;
    private String CCD7_FAI28_19;
    private String CCD7_FAI28_20;
    private String CCD7_FAI28_21;
    private String CCD7_FAI28_22;
    private String CCD7_FAI28_23;
    private String CCD7_FAI28_24;
    private String CCD7_FAI28_25;
    private String CCD7_FAI28_26;
    private String CCD7_FAI28_27;
    private String CCD7_FAI28_28;
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

    private String CCD7_FAI712_1;
    private String CCD7_FAI712_2;
    private String CCD7_FAI712_3;
    private String CCD7_FAI711_1;
    private String CCD7_FAI711_2;
    private String CCD7_FAI711_3;
    private String CCD7_FAI24_1;
    private String CCD7_FAI24_2;
    private String CCD7_FAI24_3;
    private String CCD7_FAI24_4;
    private String CCD7_FAI24_5;

    // 注意这个字段
    private String SCAN_FAI2;

    private String TestResult;
    private String TestTime;
    private String ModuleID;
    private String LineID;
    private String LineType;
    private String rn;

    // 模板对象
    private static Station52D9X template;

    /**
     * 获取模板对象
     */
    public static Station52D9X getTemplate() {
        // 在静态代码块中初始化模板对象
        template = new Station52D9X();
        template.setCCD6_FAI1(CorrectUtils.convertString(0, 0.05));
        template.setCCD7_FAI17(CorrectUtils.convertString(0.06, 0.06));
        template.setCCD7_FAI12(CorrectUtils.convertString(0.70, 0.90));
        template.setCCD7_FAI626_1(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI626_2(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI626_3(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI626_4(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI626_5(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI626_6(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI626_7(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI626_8(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI626_9(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI626_10(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI626_11(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI626_12(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI626_13(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI626_14(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI626_15(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI626_16(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI626_17(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI626_18(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI626_19(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI626_20(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI626_21(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI626_22(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI626_23(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI626_24(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI626_25(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI626_26(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI626_27(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI626_28(CorrectUtils.convertString(-0.07, 0.07));
        template.setCCD7_FAI28_1(CorrectUtils.convertString(-0.08, 0.08));
        template.setCCD7_FAI28_2(CorrectUtils.convertString(-0.08, 0.08));
        template.setCCD7_FAI28_3(CorrectUtils.convertString(-0.08, 0.08));
        template.setCCD7_FAI28_4(CorrectUtils.convertString(-0.08, 0.08));
        template.setCCD7_FAI28_5(CorrectUtils.convertString(-0.08, 0.08));
        template.setCCD7_FAI28_6(CorrectUtils.convertString(-0.08, 0.08));
        template.setCCD7_FAI28_7(CorrectUtils.convertString(-0.08, 0.08));
        template.setCCD7_FAI28_8(CorrectUtils.convertString(-0.08, 0.08));
        template.setCCD7_FAI28_9(CorrectUtils.convertString(-0.08, 0.08));
        template.setCCD7_FAI28_10(CorrectUtils.convertString(-0.08, 0.08));
        template.setCCD7_FAI28_11(CorrectUtils.convertString(-0.08, 0.08));
        template.setCCD7_FAI28_12(CorrectUtils.convertString(-0.08, 0.08));
        template.setCCD7_FAI28_13(CorrectUtils.convertString(-0.08, 0.08));
        template.setCCD7_FAI28_14(CorrectUtils.convertString(-0.08, 0.08));
        template.setCCD7_FAI28_15(CorrectUtils.convertString(-0.08, 0.08));
        template.setCCD7_FAI28_16(CorrectUtils.convertString(-0.08, 0.08));
        template.setCCD7_FAI28_17(CorrectUtils.convertString(-0.08, 0.08));
        template.setCCD7_FAI28_18(CorrectUtils.convertString(-0.08, 0.08));
        template.setCCD7_FAI28_19(CorrectUtils.convertString(-0.08, 0.08));
        template.setCCD7_FAI28_20(CorrectUtils.convertString(-0.08, 0.08));
        template.setCCD7_FAI28_21(CorrectUtils.convertString(-0.08, 0.08));
        template.setCCD7_FAI28_22(CorrectUtils.convertString(-0.08, 0.08));
        template.setCCD7_FAI28_23(CorrectUtils.convertString(-0.08, 0.08));
        template.setCCD7_FAI28_24(CorrectUtils.convertString(-0.08, 0.08));
        template.setCCD7_FAI28_25(CorrectUtils.convertString(-0.08, 0.08));
        template.setCCD7_FAI28_26(CorrectUtils.convertString(-0.08, 0.08));
        template.setCCD7_FAI28_27(CorrectUtils.convertString(-0.08, 0.08));
        template.setCCD7_FAI28_28(CorrectUtils.convertString(-0.08, 0.08));
        template.setScan_FAI2_1(CorrectUtils.convertString(0, 0.10));
        template.setScan_FAI2_2(CorrectUtils.convertString(0, 0.10));
        template.setScan_FAI2_3(CorrectUtils.convertString(0, 0.10));
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

        template.setCCD7_FAI712_1(CorrectUtils.convertString(-0.065, 0.065));
        template.setCCD7_FAI712_2(CorrectUtils.convertString(-0.065, 0.065));
        template.setCCD7_FAI712_3(CorrectUtils.convertString(-0.065, 0.065));
        template.setCCD7_FAI711_1(CorrectUtils.convertString(-0.065, 0.065));
        template.setCCD7_FAI711_2(CorrectUtils.convertString(-0.065, 0.065));
        template.setCCD7_FAI711_3(CorrectUtils.convertString(-0.065, 0.065));
        template.setCCD7_FAI24_1(CorrectUtils.convertString(0, 0.15));
        template.setCCD7_FAI24_2(CorrectUtils.convertString(0, 0.15));
        template.setCCD7_FAI24_3(CorrectUtils.convertString(0, 0.15));
        template.setCCD7_FAI24_4(CorrectUtils.convertString(0, 0.15));
        template.setCCD7_FAI24_5(CorrectUtils.convertString(0, 0.15));
        template.setSCAN_FAI2(CorrectUtils.convertString(0, 0.10));

        template.setTestResult("PASS");
        template.setRn("1");
        return template;
    }

}
