package com.example.pmp.pojo.hot;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Dandan
 * @date 2024/1/16 18:51
 **/
public class MThermodynamicchartT {

    private Long items;

    private String Testpcid;

    private Date Collecttime;

    private String FileName;

    private String ProjectName;

    private String LineType;

    private String LineName;

    private String ModuleID;

    private String CameraID;

    private String Barcode;

    private String Direction;

    private String ErrorCode;

    private String ErrorNum;

    private BigDecimal PositionX;

    private BigDecimal PositionY;

    private Date TestTime;

    private String Result;

    public void setItems(Long items) {
        this.items = items;
    }

    public Long getItems() {
        return items;
    }

    public void setTestpcid(String Testpcid) {
        this.Testpcid = Testpcid;
    }

    public String getTestpcid() {
        return Testpcid;
    }

    public void setCollecttime(Date Collecttime) {
        this.Collecttime = Collecttime;
    }

    public Date getCollecttime() {
        return Collecttime;
    }

    public void setFileName(String FileName) {
        this.FileName = FileName;
    }

    public String getFileName() {
        return FileName;
    }

    public void setProjectName(String ProjectName) {
        this.ProjectName = ProjectName;
    }

    public String getProjectName() {
        return ProjectName;
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

    public void setModuleID(String ModuleID) {
        this.ModuleID = ModuleID;
    }

    public String getModuleID() {
        return ModuleID;
    }

    public void setCameraID(String CameraID) {
        this.CameraID = CameraID;
    }

    public String getCameraID() {
        return CameraID;
    }

    public void setBarcode(String Barcode) {
        this.Barcode = Barcode;
    }

    public String getBarcode() {
        return Barcode;
    }

    public void setDirection(String Direction) {
        this.Direction = Direction;
    }

    public String getDirection() {
        return Direction;
    }

    public void setErrorCode(String ErrorCode) {
        this.ErrorCode = ErrorCode;
    }

    public String getErrorCode() {
        return ErrorCode;
    }

    public void setErrorNum(String ErrorNum) {
        this.ErrorNum = ErrorNum;
    }

    public String getErrorNum() {
        return ErrorNum;
    }

    public void setPositionX(BigDecimal PositionX) {
        this.PositionX = PositionX;
    }

    public BigDecimal getPositionX() {
        return PositionX;
    }

    public void setPositionY(BigDecimal PositionY) {
        this.PositionY = PositionY;
    }

    public BigDecimal getPositionY() {
        return PositionY;
    }

    public void setTestTime(Date TestTime) {
        this.TestTime = TestTime;
    }

    public Date getTestTime() {
        return TestTime;
    }

    public void setResult(String Result) {
        this.Result = Result;
    }

    public String getResult() {
        return Result;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("items", getItems())
                .append("Testpcid", getTestpcid())
                .append("Collecttime", getCollecttime())
                .append("FileName", getFileName())
                .append("ProjectName", getProjectName())
                .append("LineType", getLineType())
                .append("LineName", getLineName())
                .append("ModuleID", getModuleID())
                .append("CameraID", getCameraID())
                .append("Barcode", getBarcode())
                .append("Direction", getDirection())
                .append("ErrorCode", getErrorCode())
                .append("ErrorNum", getErrorNum())
                .append("PositionX", getPositionX())
                .append("PositionY", getPositionY())
                .append("TestTime", getTestTime())
                .append("Result", getResult())
                .toString();
    }

}
