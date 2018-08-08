package com.yun11yun.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * @desrciption 收派时间管理
 */
@Entity
@Table(name = "t_take_time")
public class TakeTime {
    @Id
    @GeneratedValue
    @Column(name = "c_id")
    private Integer id; // 主键
    @Column(name = "c_name")
    private String name; // 收派时间名称
    @Column(name = "c_normal_work_time")
    private String normalWorkTime; // 上班时间
    @Column(name = "c_normal_duty_time")
    private String normalDutyTime; // 下班时间
    @Column(name = "c_sat_work_time")
    private String satWorkTime; // 周六上班时间
    @Column(name = "c_sat_duty_time")
    private String satDutyTime; // 周六下班时间
    @Column(name = "c_sun_work_time")
    private String sunWorkTime; // 周日上班时间
    @Column(name = "c_sun_suty_time")
    private String sunDutyTime; // 周日下班时间
    @Column(name = "c_status")
    private String status; // 状态
    @Column(name = "c_comany")
    private String company; // 所属公司

    @Column(name = "c_operating_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date operatingTime; // 操作时间

    @Column(name = "c_operator")
    private String operator; // 操作员

    @Column(name = "c_operating_company")
    private String operatingCompany; // 操作单位

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNormalWorkTime() {
        return normalWorkTime;
    }

    public void setNormalWorkTime(String normalWorkTime) {
        this.normalWorkTime = normalWorkTime;
    }

    public String getNormalDutyTime() {
        return normalDutyTime;
    }

    public void setNormalDutyTime(String normalDutyTime) {
        this.normalDutyTime = normalDutyTime;
    }

    public String getSatWorkTime() {
        return satWorkTime;
    }

    public void setSatWorkTime(String satWorkTime) {
        this.satWorkTime = satWorkTime;
    }

    public String getSatDutyTime() {
        return satDutyTime;
    }

    public void setSatDutyTime(String satDutyTime) {
        this.satDutyTime = satDutyTime;
    }

    public String getSunWorkTime() {
        return sunWorkTime;
    }

    public void setSunWorkTime(String sunWorkTime) {
        this.sunWorkTime = sunWorkTime;
    }

    public String getSunDutyTime() {
        return sunDutyTime;
    }

    public void setSunDutyTime(String sunDutyTime) {
        this.sunDutyTime = sunDutyTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Date getOperatingTime() {
        return operatingTime;
    }

    public void setOperatingTime(Date operatingTime) {
        this.operatingTime = operatingTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperatingCompany() {
        return operatingCompany;
    }

    public void setOperatingCompany(String operatingCompany) {
        this.operatingCompany = operatingCompany;
    }
}
