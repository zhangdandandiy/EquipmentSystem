package com.example.pmp.pojo.correct;

import java.util.Date;

/**
 * @author Dandan
 * @date 2024/1/20 8:37
 **/
public class CorrectPerson {

    /**
     * 主键id，自增
     */
    private Long id;

    /**
     * 专案名称
     */
    private String project;

    /**
     * 负责人工号
     */
    private String person;

    /**
     * 标志 1：正常 0：禁用
     */
    private int flag;

    /**
     * 创建时间
     */
    private Date createTime;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

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

    public void setPerson(String person) {
        this.person = person;
    }

    public String getPerson() {
        return person;
    }

    public void setCreateTime(Date createTime){
        this.createTime=createTime;
    }

    public Date getCreateTime() {
        return createTime;
    }
}
