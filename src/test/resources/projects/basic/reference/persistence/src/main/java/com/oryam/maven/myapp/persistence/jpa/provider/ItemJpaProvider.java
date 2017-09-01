package com.oryam.maven.myapp.persistence.jpa.provider;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.oryam.maven.myapp.common.util.log.LogName;
import com.oryam.maven.myapp.common.util.log.LogTime;
import com.oryam.maven.myapp.domain.common.ItemDetail;
import com.oryam.maven.myapp.domain.common.SearchResult;
import com.oryam.maven.myapp.domain.criteria.ItemSearchCriteria;
import com.oryam.maven.myapp.domain.spi.ItemProvider;
import com.oryam.maven.myapp.persistence.jpa.model.ItemJpa;
import com.oryam.maven.myapp.persistence.jpa.repository.ItemJpaRepository;

@Service
public class ItemJpaProvider implements ItemProvider {

    @Autowired
    private ItemJpaRepository itemJpaRepository;

    @LogName
    @LogTime
    @Override
    public ItemDetail getDetail(Long id) {
        return map(itemJpaRepository.findOne(id));
    }

    @LogName
    @LogTime
    @Override
    public SearchResult<ItemDetail> findAll() {
        List<ItemDetail> values = itemJpaRepository.findAll().stream().map(value -> map(value)).collect(toList());
        return new SearchResult<>(values.size(), values);
    }

    @LogName
    @LogTime
    @Override
    public SearchResult<ItemDetail> search(ItemSearchCriteria criteria) {

        // example of search engine using ExampleMatcher
        // other solution: jpa specification, etc.

        // prepare query
        ItemJpa probe = new ItemJpa();
        probe.setCode(criteria.getCode().toLowerCase());
        ExampleMatcher matcher = ExampleMatcher
                                               .matching()
                                               .withMatcher("code"/* Item_.code.getName() */, match -> match.ignoreCase().startsWith());
        // TODO find a way to use static metamodel (to avoid NullPointerException)

        // search
        Page<ItemJpa> page = itemJpaRepository.findAll(Example.of(probe, matcher), new PageRequest(0, 500));

        // prepare result
        List<ItemDetail> values = page.getContent().stream().map(value -> map(value)).collect(toList());

        return new SearchResult<>(page.getTotalElements(), values);
    }

    private ItemDetail map(ItemJpa value) {
        return new ItemDetail(value.getCode(), value.getValue());
    }

}
