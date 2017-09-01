package com.oryam.maven.myapp.web.common;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemSearchResultView extends SearchResultView<ItemDetailView> implements Serializable {

    private static final long serialVersionUID = 3960921683019723625L;

    @JsonCreator
    public ItemSearchResultView(@JsonProperty("total") long total,
                                @JsonProperty("values") List<ItemDetailView> values) {
        super(total, values);
    }

}
