package com.example.pmp.pojo.pmp;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dandan
 * @date 2023/5/24 13:41
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class E85AutoPMP {
    /**
     * @JsonProperty注解指定了每个属性对应的JSON字段名，并使用@JsonAlias注解指定了每个属性对应的数据库字段名。 这样，在序列化时，Jackson库会按照@JsonProperty注解指定的顺序生成JSON字符串，
     * 而在反序列化时，Jackson库会根据@JsonAlias注解指定的字段名将JSON字符串中的值赋给对应的属性。
     */

    @JsonProperty("items")
    @JsonAlias({"items"})
    private int items;

    @JsonProperty("Testpcid")
    @JsonAlias({"Testpcid"})
    private String Testpcid;

    @JsonProperty("Vendor")
    @JsonAlias({"Vendor"})
    private String Vendor;

    @JsonProperty("Config")
    @JsonAlias({"Config"})
    private String Config;

    @JsonProperty("Line_name")
    @JsonAlias({"Line_name"})
    private String Line_name;

    @JsonProperty("Line_number")
    @JsonAlias({"Line_number"})
    private String Line_number;

    @JsonProperty("MachineID")
    @JsonAlias({"MachineID"})
    private String MachineID;

    @JsonProperty("Station_number")
    @JsonAlias({"Station_number"})
    private String Station_number;

    @JsonProperty("Station_name")
    @JsonAlias({"Station_name"})
    private String Station_name;

    @JsonProperty("Variable")
    @JsonAlias({"Variable"})
    private String Variable;

    @JsonProperty("Variable_type")
    @JsonAlias({"Variable_type"})
    private String Variable_type;

    @JsonProperty("Unit")
    @JsonAlias({"Unit"})
    private String Unit;

    @JsonProperty("Actual")
    @JsonAlias({"Actual"})
    private String Actual;

    @JsonProperty("Nominal")
    @JsonAlias({"Nominal"})
    private String Nominal;

    @JsonProperty("TolAdd")
    @JsonAlias({"Tol-"})
    private String TolAdd;

    @JsonProperty("TolMinus")
    @JsonAlias({"Tol-"})
    private String TolMinus;

    @JsonProperty("Build")
    @JsonAlias({"Build"})
    private String Build;

    @JsonProperty("Latest")
    @JsonAlias({"Latest"})
    private String Latest;

    @JsonProperty("Source")
    @JsonAlias({"Source"})
    private String Source;

    @JsonProperty("Document")
    @JsonAlias({"Document"})
    private String Document;

    @JsonProperty("Check_type")
    @JsonAlias({"Check_type"})
    private String Check_type;

    @JsonProperty("Check_method")
    @JsonAlias({"Check_method"})
    private String Check_method;

    @JsonProperty("Check_qty")
    @JsonAlias({"Check_qty"})
    private String Check_qty;

    @JsonProperty("Per_HW")
    @JsonAlias({"Per_HW"})
    private String Per_HW;

    @JsonProperty("Check_freq")
    @JsonAlias({"Check_freq"})
    private String Check_freq;

    @JsonProperty("DRI")
    @JsonAlias({"DRI"})
    private String DRI;

    @JsonProperty("Reactive_plan")
    @JsonAlias({"Reactive_plan"})
    private String Reactive_plan;

    @JsonProperty("Record")
    @JsonAlias({"Record"})
    private String Record;

}
