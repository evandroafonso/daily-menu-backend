package com.daily.menu.domain.model.baseDao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daily.menu.domain.model.baseEntity.BaseEntity;

public interface BaseDao <T extends BaseEntity> extends JpaRepository<T, Long> {

}
