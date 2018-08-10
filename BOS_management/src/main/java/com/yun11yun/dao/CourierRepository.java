package com.yun11yun.dao;

import com.yun11yun.domain.Courier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CourierRepository extends JpaRepository<Courier, Integer>, JpaSpecificationExecutor<Courier> {

    @Query(value = "update Courier set deltag='1' where id = ?1")
    @Modifying
    void updateDeltag(Integer id);
}
