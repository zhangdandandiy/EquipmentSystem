package com.example.pmp.pojo.correct;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Dandan
 * @date 2024/1/9 18:14
 **/
public class CorrectLog {

    /**
     * 主键，自增
     */
    private int Id;

    /**
     * 专案
     */
    private String Project;

    /**
     * 线体类型
     */
    private String LineType;

    /**
     * 线体编号
     */
    private String LineName;

    /**
     * 设备名
     */
    private String EquName;

    /**
     * 站点名
     */
    private String Station;

    /**
     * 要补的字段名
     */
    private String ItemKey;

    /**
     * 开始时间
     */
    private String StartTime;

    /**
     * 结束时间
     */
    private String EndTime;

    /**
     * 数据总数
     */
    private int DataCount;

    /**
     * 补之前良品数
     */
    private int BeforeGoodCount;

    /**
     * 补之前良率
     */
    private BigDecimal BeforeYield;

    /**
     * 补之后良品数
     */
    private int AfterGoodCount;

    /**
     * 补之后良率
     */
    private BigDecimal AfterYield;

    private Date CreateTime;

    public Date getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Date createTime) {
        CreateTime = createTime;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getId() {
        return Id;
    }

    public void setProject(String Project) {
        this.Project = Project;
    }

    public String getProject() {
        return Project;
    }

    public void setLineType(String LineType) {
        this.LineType = LineType;
    }

    public String getLineType() {
        return LineType;
    }

    public void setLineName(String LineName) {
        this.LineName = LineName;
    }

    public String getLineName() {
        return LineName;
    }

    public void setEquName(String EquName) {
        this.EquName = EquName;
    }

    public String getEquName() {
        return EquName;
    }

    public void setStation(String Station) {
        this.Station = Station;
    }

    public String getStation() {
        return Station;
    }

    public void setItemKey(String ItemKey) {
        this.ItemKey = ItemKey;
    }

    public String getItemKey() {
        return ItemKey;
    }

    public void setStartTime(String StartTime) {
        this.StartTime = StartTime;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setEndTime(String EndTime) {
        this.EndTime = EndTime;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setDataCount(int DataCount) {
        this.DataCount = DataCount;
    }

    public int getDataCount() {
        return DataCount;
    }

    public void setBeforeGoodCount(int BeforeGoodCount) {
        this.BeforeGoodCount = BeforeGoodCount;
    }

    public int getBeforeGoodCount() {
        return BeforeGoodCount;
    }

    public void setBeforeYield(BigDecimal BeforeYield) {
        this.BeforeYield = BeforeYield;
    }

    public BigDecimal getBeforeYield() {
        return BeforeYield;
    }

    public void setAfterGoodCount(int AfterGoodCount) {
        this.AfterGoodCount = AfterGoodCount;
    }

    public int getAfterGoodCount() {
        return AfterGoodCount;
    }

    public void setAfterYield(BigDecimal AfterYield) {
        this.AfterYield = AfterYield;
    }

    public BigDecimal getAfterYield() {
        return AfterYield;
    }

}
