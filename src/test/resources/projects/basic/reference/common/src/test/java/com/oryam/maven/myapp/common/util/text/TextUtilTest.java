package com.oryam.maven.myapp.common.util.text;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.oryam.maven.myapp.common.util.test.CommonTest;

public class TextUtilTest extends CommonTest {

    @Test
    public void should_convert_underscore_to_camel_case() {
        assertThat(TextUtil.convertUnderscoreToCamelCase("ABC_DEF".toLowerCase())).isEqualTo("abcDef");
    }

}
