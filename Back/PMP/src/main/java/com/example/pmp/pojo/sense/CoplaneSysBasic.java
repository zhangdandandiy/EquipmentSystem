package com.example.pmp.pojo.sense;

/**
 * @author Dandan
 * @date 2023/11/24 15:13
 **/
public class CoplaneSysBasic {

    /**
     * 共面度检测表的id，自增，主键
     */
    private Long id;

    /**
     * 专案
     */
    private String project;

    /**
     * 线体类型
     */
    private String lineType;

    /**
     * 线体编号
     */
    private String lineName;

    /**
     * 需要检测的FAI项
     */
    private String faiName;

    /**
     * y轴最大值
     */
    private String yaxisMax;

    /**
     * y轴最小值
     */
    private String yaxisMin;

    /**
     * y轴上标准线
     */
    private String yaxisTopTarget;

    /**
     * y轴下标准下，可有可无
     */
    private String yaxisDownTarget;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getProject() {
        return project;
    }

    public void setLineType(String lineType) {
        this.lineType = lineType;
    }

    public String getLineType() {
        return lineType;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public String getLineName() {
        return lineName;
    }

    public void setFaiName(String faiName) {
        this.faiName = faiName;
    }

    public String getFaiName() {
        return faiName;
    }

    public void setYaxisMax(String yaxisMax) {
        this.yaxisMax = yaxisMax;
    }

    public String getYaxisMax() {
        return yaxisMax;
    }

    public void setYaxisMin(String yaxisMin) {
        this.yaxisMin = yaxisMin;
    }

    public String getYaxisMin() {
        return yaxisMin;
    }

    public void setYaxisTopTarget(String yaxisTopTarget) {
        this.yaxisTopTarget = yaxisTopTarget;
    }

    public String getYaxisTopTarget() {
        return yaxisTopTarget;
    }

    public void setYaxisDownTarget(String yaxisDownTarget) {
        this.yaxisDownTarget = yaxisDownTarget;
    }

    public String getYaxisDownTarget() {
        return yaxisDownTarget;
    }

}
