#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.domain.criteria;

public class ItemSearchCriteria {

    private final String code;

    public ItemSearchCriteria(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
