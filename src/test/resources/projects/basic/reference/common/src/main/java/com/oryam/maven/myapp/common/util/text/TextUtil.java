package com.oryam.maven.myapp.common.util.text;

import com.google.common.base.CaseFormat;

public class TextUtil {

    private TextUtil() {
    }

    public static String convertUnderscoreToCamelCase(String value) {
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, value);
    }

}
