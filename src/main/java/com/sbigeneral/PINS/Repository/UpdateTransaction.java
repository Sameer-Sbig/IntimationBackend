package com.sbigeneral.PINS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sbigeneral.PINS.Entity.LimitTransctionEntity;
@Repository
public interface UpdateTransaction extends JpaRepository<LimitTransctionEntity, Integer> {

}
