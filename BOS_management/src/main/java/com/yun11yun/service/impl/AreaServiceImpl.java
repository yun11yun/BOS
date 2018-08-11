package com.yun11yun.service.impl;

import com.yun11yun.dao.AreaRepository;
import com.yun11yun.domain.Area;
import com.yun11yun.service.AreaService;
import com.yun11yun.util.ServiceUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaRepository areaRepository;

    @Override
    public void save(Area area) {
        if (area == null) {
            return;
        }
        this.areaRepository.save(area);
    }

    @Override
    public void saveBatch(List<Area> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.areaRepository.saveAll(list);
    }

    @Override
    public Page <Area> findByPage(Area area, int page, int rows) {
        if (area == null || page < 1 || rows <= 0) {
            return null;
        }

        Pageable pageable = new PageRequest(page - 1, rows);

        Specification<Area> specification = new Specification <Area>() {
            @Override
            public Predicate toPredicate(Root<Area> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList <>();
                if (StringUtils.isNotBlank(area.getProvince())) {
                    predicates.add(criteriaBuilder.like(root.get("province"), ServiceUtils.likePredicateStringFrom(area.getProvince())));
                }
                if (StringUtils.isNotBlank(area.getCity())) {
                    predicates.add(criteriaBuilder.like(root.get("city"), ServiceUtils.likePredicateStringFrom(area.getCity())));
                }
                if (StringUtils.isNotBlank(area.getDistrict())) {
                    predicates.add(criteriaBuilder.like(root.get("district"), ServiceUtils.likePredicateStringFrom(area.getDistrict())));
                }
                Predicate result = criteriaBuilder.and(predicates.toArray(new Predicate[0]));

                return result;
            }
        };

        return this.areaRepository.findAll(specification, pageable);
    }

    @Override
    public void delete(Area area) {
        if (area == null) {
            return;
        }
        this.areaRepository.delete(area);
    }
}
