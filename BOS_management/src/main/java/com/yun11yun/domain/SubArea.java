package com.yun11yun.domain;

import javax.persistence.*;

/**
 * @description: 分区
 */

@Entity
@Table(name = "t_sub_area")
public class SubArea {

    @Id
    @Column(name = "c_id")
    private String id;
    @Column(name = "c_start_num")
    private String startNum; // 起始号
    @Column(name = "c_end_num")
    private String endNum; // 终止号
    @Column(name = "c_single")
    private Character single; // 单双号
    @Column(name = "c_key_words")
    private String keyWords; // 关键字
    @Column(name = "c_assist_key_words")
    private String assistKeyWords; // 辅助关键字

    @ManyToOne
    @JoinColumn(name = "c_area_id")
    private Area area; // 区域

    @ManyToOne
    @JoinColumn(name = "c_fixedarea_id")
    private FixedArea fixedArea; // 定区

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStartNum() {
        return startNum;
    }

    public void setStartNum(String startNum) {
        this.startNum = startNum;
    }

    public String getEndNum() {
        return endNum;
    }

    public void setEndNum(String endNum) {
        this.endNum = endNum;
    }

    public Character getSingle() {
        return single;
    }

    public void setSingle(Character single) {
        this.single = single;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public String getAssistKeyWords() {
        return assistKeyWords;
    }

    public void setAssistKeyWords(String assistKeyWords) {
        this.assistKeyWords = assistKeyWords;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public FixedArea getFixedArea() {
        return fixedArea;
    }

    public void setFixedArea(FixedArea fixedArea) {
        this.fixedArea = fixedArea;
    }
}
