package com.yun11yun.service;

import com.yun11yun.domain.Area;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AreaService {
    void save(Area area);
    void delete(Area area);
    void saveBatch(List<Area> list);
    Page<Area> findByPage(Area area, int page, int rows);
}
