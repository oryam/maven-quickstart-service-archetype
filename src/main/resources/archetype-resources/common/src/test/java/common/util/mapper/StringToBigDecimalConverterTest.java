#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.common.util.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

public class StringToBigDecimalConverterTest {

    private StringToBigDecimalConverter converter = new StringToBigDecimalConverter();

    @Test
    public void should_convert_from_string_to_bigdecimal() {
        assertThat(convertToBigDecimal("1.123456789123456789").doubleValue()).isEqualTo(1.123456789123456789);
        assertThat(convertToBigDecimal("1.000000000000000000").doubleValue()).isEqualTo(1.0);
        assertThat(convertToBigDecimal("0.000000000000000001").doubleValue()).isEqualTo(0.000000000000000001);
        assertThat(convertToBigDecimal("123456789123456789.123456789123456789").doubleValue()).isEqualTo(123456789123456789.123456789123456789);
    }

    @Test
    public void should_convert_from_bigdecimal_to_string() {
        assertThat(convertFromBigDecimal(new BigDecimal("1.123456789123456789"))).isEqualTo("1.123456789123456789");
        assertThat(convertFromBigDecimal(new BigDecimal("1.000000000000000000"))).isEqualTo("1");
        assertThat(convertFromBigDecimal(new BigDecimal("0.000000000000000001"))).isEqualTo("0.000000000000000001");
        assertThat(convertFromBigDecimal(new BigDecimal("123456789123456789.123456789123456789"))).isEqualTo("123456789123456789.123456789123456789");
    }

    private String convertFromBigDecimal(BigDecimal number) {
        return converter.convertFrom(number, null, null);
    }

    private BigDecimal convertToBigDecimal(String value) {
        return converter.convertTo(value, null, null);
    }
}
