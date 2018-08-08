package com.yun11yun.domain;

import sun.jvm.hotspot.jdi.IntegerTypeImpl;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_standard")
public class Standard {
    @Id
    @GeneratedValue
    @Column(name = "C_ID")
    private Integer id; // 主键
    @Column(name = "C_NAME")
    private String name; // 标准名称
    @Column(name = "C_MIN_WEIGHT")
    private Integer minWeight;
    @Column(name = "C_MAX_WEIGHT")
    private Integer maxWeight;
    @Column(name = "C_MIN_LENGTH")
    private Integer minLength;
    @Column(name = "C_MAX_LENGTH")
    private Integer maxLength;
    @Column(name = "C_OPERATING_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date operatingTime;
    @Column(name = "C_OPERATOR")
    private String operator;
    @Column(name = "C_OPERATING_COMPANY")
    private String operatingCompany;

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

    public Integer getMinWeight() {
        return minWeight;
    }

    public void setMinWeight(Integer minWeight) {
        this.minWeight = minWeight;
    }

    public Integer getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Integer maxWeight) {
        this.maxWeight = maxWeight;
    }

    public Integer getMinLength() {
        return minLength;
    }

    public void setMinLength(Integer minLength) {
        this.minLength = minLength;
    }

    public Integer getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
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

    @Override
    public String toString() {
        return "Standard{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", minWeight=" + minWeight +
                ", maxWeight=" + maxWeight +
                ", minLength=" + minLength +
                ", maxLength=" + maxLength +
                ", operatingTime=" + operatingTime +
                ", operator='" + operator + '\'' +
                ", operatingCompany='" + operatingCompany + '\'' +
                '}';
    }
}
