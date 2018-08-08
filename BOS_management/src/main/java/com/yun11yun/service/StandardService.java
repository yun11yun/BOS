package com.yun11yun.service;

import com.yun11yun.domain.Standard;
import org.springframework.data.domain.Page;

/**
 * 收派标准service
 */
public interface StandardService {
    void save(Standard standard);
    Page<Standard> findByPage(int page, int rows);
}
