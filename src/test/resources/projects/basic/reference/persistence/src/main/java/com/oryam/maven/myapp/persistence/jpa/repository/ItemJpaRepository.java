package com.oryam.maven.myapp.persistence.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.oryam.maven.myapp.persistence.jpa.model.ItemJpa;

public interface ItemJpaRepository extends JpaRepository<ItemJpa, Long>, JpaSpecificationExecutor<Long> {

}
