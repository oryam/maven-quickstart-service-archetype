#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.common.util.mapper;

import java.math.BigDecimal;

import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

public class StringToBigDecimalConverter extends BidirectionalConverter<String, BigDecimal> {

    public BigDecimal convertTo(String source, Type<BigDecimal> destinationType, MappingContext mappingContext) {
        return (source == null) ? null : new BigDecimal(source);
    }

    public String convertFrom(BigDecimal source, Type<String> destinationType, MappingContext mappingContext) {
        return (source == null) ? null : source.stripTrailingZeros().toPlainString();
    }
}
