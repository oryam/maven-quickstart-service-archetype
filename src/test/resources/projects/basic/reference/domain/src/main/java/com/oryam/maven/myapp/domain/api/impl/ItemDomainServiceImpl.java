package com.oryam.maven.myapp.domain.api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oryam.maven.myapp.domain.api.ItemDomainService;
import com.oryam.maven.myapp.domain.common.ItemDetail;
import com.oryam.maven.myapp.domain.common.SearchResult;
import com.oryam.maven.myapp.domain.criteria.ItemSearchCriteria;
import com.oryam.maven.myapp.domain.spi.ItemProvider;

@Service
public class ItemDomainServiceImpl implements ItemDomainService {

    @Autowired
    private ItemProvider itemProvider;

    @Override
    public ItemDetail getDetail(Long id) {
        return itemProvider.getDetail(id);
    }

    @Override
    public SearchResult<ItemDetail> findAll() {
        return itemProvider.findAll();
    }

    @Override
    public SearchResult<ItemDetail> search(ItemSearchCriteria criteria) {
        return itemProvider.search(criteria);
    }

}
