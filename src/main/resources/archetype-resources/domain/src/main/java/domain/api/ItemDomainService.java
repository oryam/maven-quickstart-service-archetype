#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.domain.api;

import ${package}.domain.common.ItemDetail;
import ${package}.domain.common.SearchResult;
import ${package}.domain.criteria.ItemSearchCriteria;

public interface ItemDomainService {

    ItemDetail getDetail(Long id);

    SearchResult<ItemDetail> findAll();

    SearchResult<ItemDetail> search(ItemSearchCriteria criteria);

}
