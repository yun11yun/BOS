package com.yun11yun.dao;

import com.yun11yun.domain.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AreaRepository extends JpaRepository<Area, String>, JpaSpecificationExecutor<Area> {

}
