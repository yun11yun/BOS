package com.yun11yun.service;

import com.yun11yun.domain.Standard;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 收派标准service
 */
public interface StandardService {
    void save(Standard standard);
    Page<Standard> findByPage(int page, int rows);
    List<Standard> findAll();
}
