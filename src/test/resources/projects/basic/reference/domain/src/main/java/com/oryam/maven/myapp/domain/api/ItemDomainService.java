package com.oryam.maven.myapp.domain.api;

import com.oryam.maven.myapp.domain.common.ItemDetail;
import com.oryam.maven.myapp.domain.common.SearchResult;
import com.oryam.maven.myapp.domain.criteria.ItemSearchCriteria;

public interface ItemDomainService {

    ItemDetail getDetail(Long id);

    SearchResult<ItemDetail> findAll();

    SearchResult<ItemDetail> search(ItemSearchCriteria criteria);

}
