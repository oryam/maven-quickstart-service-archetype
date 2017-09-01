#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.domain.common;

import java.util.List;

public class SearchResult<T> {

    private final long total;
    private final List<T> values;

    public SearchResult(long total, List<T> values) {
        this.total = total;
        this.values = values;
    }

    public long getTotal() {
        return total;
    }

    public List<T> getValues() {
        return values;
    }

}
