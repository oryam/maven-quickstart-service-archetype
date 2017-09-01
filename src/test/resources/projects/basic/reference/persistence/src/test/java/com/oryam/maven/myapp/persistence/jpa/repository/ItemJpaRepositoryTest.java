package com.oryam.maven.myapp.persistence.jpa.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import com.oryam.maven.myapp.common.util.test.BeanFactoryTest;
import com.oryam.maven.myapp.common.util.test.CommonTest;
import com.oryam.maven.myapp.persistence.jpa.model.ItemJpa;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemJpaRepositoryTest extends CommonTest {

    @Autowired
    private ItemJpaRepository transactionJpaRepository;

    @Test
    public void should_create_transaction_report() {

        // random ID for creation as there is no sequence for id
        ItemJpa newRandomData = BeanFactoryTest.INSTANCE.getRandomObject(ItemJpa.class);

        String code = newRandomData.getCode();
        BigDecimal value = newRandomData.getValue();

        ItemJpa foundData = transactionJpaRepository.save(newRandomData);

        // check at least 2 fields other than ID
        assertThat(foundData.getCode()).isEqualTo(code);
        assertThat(foundData.getValue().doubleValue()).isEqualTo(value.doubleValue());
    }

    @Test
    public void should_find_transaction_report() {

        Long searchId = 1L;
        BigDecimal value = BigDecimal.valueOf(1.01);

        ItemJpa foundData = transactionJpaRepository.getOne(searchId);

        // check at least 2 fields other than ID
        assertThat(foundData.getId()).isEqualTo(searchId);
        assertThat(foundData.getValue().doubleValue()).isEqualTo(value.doubleValue());
    }

    @Test
    public void should_find_paginating_transaction_report_result() {

        int expectedTotal = 3;

        PageRequest pageable = new PageRequest(0, 2);
        Page<ItemJpa> results = transactionJpaRepository.findAll(pageable);

        assertThat(results.getTotalElements()).isEqualTo(expectedTotal);
        assertThat(results.getContent()).hasSize(2);
    }

}
