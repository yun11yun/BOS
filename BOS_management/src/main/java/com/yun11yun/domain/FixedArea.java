package com.yun11yun.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_fixed_area")
public class FixedArea {
    @Id
    @Column(name = "c_id")
    private String id;
    @Column(name = "c_fixed_area_name", unique = true)
    private String name;
    @Column(name = "c_fixed_area_leader", unique = true)
    private String leader;
    @Column(name = "c_telephone")
    private String telephone;
    @Column(name = "c_company")
    private String company;
    @Column(name = "c_operating_time")
    private String operatingTime;
    @Column(name = "c_operator")
    private String operator;
    @Column(name = "c_operating_company")
    private String operatingCompany;

    @OneToMany(mappedBy = "fixedArea")
    private Set<SubArea> subareas = new HashSet <>(0);

    @ManyToMany
    @JoinTable(
            name = "t_fixedarea_courier",
            joinColumns = {@JoinColumn(name = "c_fixedarea_id", referencedColumnName = "c_id")},
            inverseJoinColumns = {@JoinColumn(name = "c_courier_id", referencedColumnName = "c_id")}
    )
    private Set<Courier> couriers = new HashSet <>(0);

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getOperatingTime() {
        return operatingTime;
    }

    public void setOperatingTime(String operatingTime) {
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

    public Set <SubArea> getSubareas() {
        return subareas;
    }

    public void setSubareas(Set <SubArea> subareas) {
        this.subareas = subareas;
    }

    public Set <Courier> getCouriers() {
        return couriers;
    }

    public void setCouriers(Set <Courier> couriers) {
        this.couriers = couriers;
    }
}
