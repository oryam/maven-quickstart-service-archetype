package com.oryam.maven.myapp.web.config;

import org.apache.commons.lang3.StringUtils;

public class RestApiUrlConfig {

    public static final String CONTEXT_URL = "service/rest";

    public static final String ITEM = "item";
    public static final String ITEM_DETAIL = "item/{id}";
    public static final String ITEMS = "items";

    public static String buildUrl(boolean asAbsolute, String... fragments) {
        StringBuilder url = new StringBuilder();

        if (asAbsolute) {
            url.append("/");
        }

        url.append(CONTEXT_URL).append("/");
        url.append(StringUtils.join(fragments, "/"));

        return url.toString();
    }

}
