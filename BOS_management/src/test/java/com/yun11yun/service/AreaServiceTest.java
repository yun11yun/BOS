package com.yun11yun.service;

import com.yun11yun.domain.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class AreaServiceTest extends ServiceBaseTestBase {

    @Autowired
    private AreaService areaService;

    @Test
    public void save() {

        Area area = new Area();
        area.setId("12345");
        area.setProvince("河北省");
        area.setCity("石家庄");

        areaService.save(area);
    }

    @Test
    public void delete() {
        Area area = new Area();
        area.setId("12345");
        areaService.delete(area);
    }

    @Test
    public void saveBatch() {

    }

    @Test
    public void findByPage() {
    }
}