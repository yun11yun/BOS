package com.yun11yun.domain;

import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @description: 地域信息实体类，主要包含 省市区(县)
 */

@Entity
@Table(name = "t_area")
public class Area {
    @Id
    @Column(name = "c_id")
    private String id;
    @Column(name = "c_province")
    private String province; // 省
    @Column(name = "c_city")
    private String city; // 城市
    @Column(name = "c_district")
    private String district; // 区域
    @Column(name = "c_postcode")
    private String postcode; // 邮编
    @Column(name = "c_citycode")
    private String citycode; // 城市编码
    @Column(name = "c_shortcode")
    private String shortcode; // 简码

    @OneToMany(mappedBy = "area", fetch = FetchType.EAGER)
    private Set<SubArea> subareas = new HashSet <>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    public String getShortcode() {
        return shortcode;
    }

    public void setShortcode(String shortcode) {
        this.shortcode = shortcode;
    }

    public Set <SubArea> getSubareas() {
        return subareas;
    }

    @JSON(serialize = false)
    public void setSubareas(Set <SubArea> subareas) {
        this.subareas = subareas;
    }
}
