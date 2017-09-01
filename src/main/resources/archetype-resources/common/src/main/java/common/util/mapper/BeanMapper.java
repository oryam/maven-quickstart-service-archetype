#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.common.util.mapper;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class BeanMapper {

    private static BeanMapper instance = new BeanMapper();

    private MapperFactory factory;

    private BeanMapper() {
        factory = new DefaultMapperFactory.Builder().build();

        factory
               .getConverterFactory()
               .registerConverter("StringToBigDecimalConverter", new StringToBigDecimalConverter());
    }

    public static BeanMapper getInstance() {
        return instance;
    }

    public MapperFactory getFactory() {
        return this.factory;
    }

}
