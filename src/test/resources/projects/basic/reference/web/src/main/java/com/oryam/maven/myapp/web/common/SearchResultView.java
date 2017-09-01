package com.oryam.maven.myapp.web.common;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class SearchResultView<T extends Serializable> {

    protected final long total;
    protected final List<T> values;

    protected SearchResultView(long total, List<T> values) {
        this.total = total;
        this.values = values;
    }

    public long getTotal() {
        return total;
    }

    public List<T> getValues() {
        return values;
    }

    public Optional<T> findFirst() {
        return values.stream().findFirst();
    }

}
