package com.yun11yun.service;

import com.yun11yun.domain.Courier;
import org.springframework.data.domain.Page;

public interface CourierService {
    void save(Courier courier);
    Page<Courier> queryPage(Courier courier, int page, int rows);
    void delBatch(String[] ids);
}
