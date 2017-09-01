#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.web.common;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemDetailView implements Serializable {

    private static final long serialVersionUID = 7479095096789075863L;

    private final String code;
    private final BigDecimal value;

    @JsonCreator
    public ItemDetailView(@JsonProperty("code") String code,
                          @JsonProperty("value") BigDecimal value) {

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
