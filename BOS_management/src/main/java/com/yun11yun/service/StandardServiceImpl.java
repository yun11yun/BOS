package com.yun11yun.service;


import com.yun11yun.dao.StandardRepository;
import com.yun11yun.domain.Standard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StandardServiceImpl implements StandardService {

    @Autowired
    private StandardRepository standardRepository;

    @Override
    public void save(Standard standard) {
        standardRepository.save(standard);
    }

    @Override
    public Page<Standard> findByPage(int page, int rows) {
        return standardRepository.findAll(new PageRequest(page - 1, rows));
    }

    @Override
    public List<Standard> findAll() {
        return standardRepository.findAll();
    }
}
