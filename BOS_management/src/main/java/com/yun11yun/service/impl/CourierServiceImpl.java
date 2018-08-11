package com.yun11yun.service.impl;

import com.yun11yun.dao.CourierRepository;
import com.yun11yun.domain.Courier;
import com.yun11yun.domain.Standard;
import com.yun11yun.service.CourierService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CourierServiceImpl implements CourierService {

    @Autowired
    private CourierRepository courierRepository;

    @Override
    public void save(Courier courier) {
        if (courier == null) {
            return;
        }
        this.courierRepository.save(courier);
    }

    @Override
    public Page<Courier> queryPage(Courier courier, int page, int rows) {
        if (page < 1 && rows < 0) {
            return null;
        }

        // 封装Pageable对象
        Pageable pageable = new PageRequest(page - 1, rows);

        // 封装条件查询
        Specification<Courier> specification = new Specification <Courier>() {
            @Override
            public Predicate toPredicate(Root<Courier> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                
                List<Predicate> predicates = new ArrayList <>();
                if (StringUtils.isNotBlank(courier.getCourierNum())) {
                    Predicate predicate = criteriaBuilder.equal(
                            root.get("courierNum").as(String.class), courier.getCourierNum());
                    predicates.add(predicate);
                }
                if (StringUtils.isNoneBlank(courier.getCompany())) {
                    Predicate predicate = criteriaBuilder.like(
                            root.get("company").as(String.class), "%" + courier.getCompany() + "%");
                    predicates.add(predicate);
                }
                if (StringUtils.isNoneBlank(courier.getType())) {
                    Predicate predicate = criteriaBuilder.equal(
                            root.get("type").as(String.class), courier.getType());
                    predicates.add(predicate);
                }

                // 多表查询
                Join<Courier, Standard> standardJoin = root.join("standard", JoinType.INNER);
                if (courier.getStandard() != null
                        && StringUtils.isNotBlank(courier.getStandard().getName())) {
                    Predicate predicate = criteriaBuilder.like(standardJoin.get("name").as(String.class), "%" + courier.getStandard().getName() + "%");
                    predicates.add(predicate);
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            }
        };

        // 开始查询
        Page<Courier> result = courierRepository.findAll(specification, pageable);

        // 返回结果
        return result;
    }

    @Override
    public void delBatch(String[] ids) {
        if (ids == null || ids.length == 0) {
            return;
        }
        for (String idStr : ids) {
            Integer id = Integer.parseInt(idStr);
            this.courierRepository.updateDeltag(id);
        }
    }
}
