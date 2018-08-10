package com.yun11yun.domain;


import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_courier")
public class Courier {

    @Id
    @GeneratedValue
    @Column(name = "c_id")
    private Integer id; // 主键
    @Column(name = "c_courier_num")
    private String courierNum; // 工号
    @Column(name = "c_name")
    private String name; // 姓名
    @Column(name = "c_phone")
    private String phone; // 联系电话
    @Column(name = "c_pda")
    private String pda;  // PDA号
    @Column(name = "c_deltag")
    private Character deltag; // 作为标记 1 为标记作废
    @Column(name = "c_check_pwd")
    private String checkPwd; // 查泰密码
    @Column(name = "c_type")
    private String type; // 取件员类型
    @Column(name = "c_company")
    private String company; // 单位
    @Column(name = "c_vehicle_type")
    private String vehicleType; // 车辆类型
    @Column(name = "c_vehicle_num")
    private String vehicleNum; // 车牌号

    @ManyToOne
    @JoinColumn(name = "c_standard_id")
    private Standard standard; //

    @ManyToOne
    @JoinColumn(name = "c_taketime_id")
    private TakeTime takeTime;

    // 配置
    @ManyToMany(mappedBy = "couriers", fetch = FetchType.EAGER)
    private Set<FixedArea> fixedAreas = new HashSet <>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourierNum() {
        return courierNum;
    }

    public void setCourierNum(String courierNum) {
        this.courierNum = courierNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPda() {
        return pda;
    }

    public void setPda(String pda) {
        this.pda = pda;
    }

    public Character getDeltag() {
        return deltag;
    }

    public void setDeltag(Character deltag) {
        this.deltag = deltag;
    }

    public String getCheckPwd() {
        return checkPwd;
    }

    public void setCheckPwd(String checkPwd) {
        this.checkPwd = checkPwd;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleNum() {
        return vehicleNum;
    }

    public void setVehicleNum(String vehicleNum) {
        this.vehicleNum = vehicleNum;
    }

    public Standard getStandard() {
        return standard;
    }

    public void setStandard(Standard standard) {
        this.standard = standard;
    }

    public TakeTime getTakeTime() {
        return takeTime;
    }

    public void setTakeTime(TakeTime takeTime) {
        this.takeTime = takeTime;
    }


    public Set <FixedArea> getFixedAreas() {
        return fixedAreas;
    }

    @JSON(serialize = false)
    public void setFixedAreas(Set <FixedArea> fixedAreas) {
        this.fixedAreas = fixedAreas;
    }

    public String getDeltagStr() {
        if (this.deltag == null) {
            return "正常使用";
        } else {
            return "已经作废";
        }
    }
}
