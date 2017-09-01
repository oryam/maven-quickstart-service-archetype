#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.domain.api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ${package}.domain.api.ItemDomainService;
import ${package}.domain.common.ItemDetail;
import ${package}.domain.common.SearchResult;
import ${package}.domain.criteria.ItemSearchCriteria;
import ${package}.domain.spi.ItemProvider;

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
