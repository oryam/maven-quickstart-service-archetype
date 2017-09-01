package com.oryam.maven.myapp.web.rest;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oryam.maven.myapp.common.util.log.LogName;
import com.oryam.maven.myapp.common.util.log.LogTime;
import com.oryam.maven.myapp.domain.api.ItemDomainService;
import com.oryam.maven.myapp.domain.common.ItemDetail;
import com.oryam.maven.myapp.domain.common.SearchResult;
import com.oryam.maven.myapp.domain.criteria.ItemSearchCriteria;
import com.oryam.maven.myapp.web.common.ItemDetailView;
import com.oryam.maven.myapp.web.common.ItemSearchResultView;
import com.oryam.maven.myapp.web.config.RestApiUrlConfig;

@RestController
@RequestMapping(path = RestApiUrlConfig.CONTEXT_URL)
public class ItemWebResource {

    @Autowired
    private ItemDomainService itemDomainService;

    @LogName
    @LogTime
    @GetMapping(path = RestApiUrlConfig.ITEM_DETAIL)
    public ItemDetailView detail(@PathVariable Long id) {
        return map(itemDomainService.getDetail(id));
    }

    @LogName
    @LogTime
    @GetMapping(path = RestApiUrlConfig.ITEM)
    public ItemSearchResultView list() {

        SearchResult<ItemDetail> result = itemDomainService.findAll();

        List<ItemDetailView> values = result
                                            .getValues()
                                            .stream()
                                            .map(value -> map(value))
                                            .collect(toList());

        return new ItemSearchResultView(result.getTotal(), values);
    }

    @LogName
    @LogTime
    @PostMapping(path = RestApiUrlConfig.ITEMS)
    public ItemSearchResultView search(@RequestBody String code) {

        ItemSearchCriteria criteria = new ItemSearchCriteria(code);

        SearchResult<ItemDetail> result = itemDomainService.search(criteria);

        List<ItemDetailView> values = result
                                            .getValues()
                                            .stream()
                                            .map(value -> map(value))
                                            .collect(toList());

        return new ItemSearchResultView(result.getTotal(), values);
    }

    private ItemDetailView map(ItemDetail detail) {
        return new ItemDetailView(detail.getCode(), detail.getValue());
    }

}
