#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.domain.common;

import java.math.BigDecimal;

public class ItemDetail {

    private final String code;
    private final BigDecimal value;

    public ItemDetail(String code, BigDecimal value) {
        super();
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public BigDecimal getValue() {
        return value;
    }

}
