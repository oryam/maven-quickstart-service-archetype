package com.oryam.maven.myapp.common.util.query;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;

public final class QueryUtil {

    public static final char ESCAPE_CHAR = '\\';

    private QueryUtil() {
    }

    public static String toContainsPattern(String value) {
        if (value == null) {
            return null;
        }
        return new StringBuilder().append("%").append(value).append("%").toString();
    }

    public static String toStartWithPattern(String value) {
        if (value == null) {
            return null;
        }
        return new StringBuilder().append(value).append("%").toString();
    }

    public static String toEndWithPattern(String value) {
        if (value == null) {
            return null;
        }
        return new StringBuilder().append("%").append(value).toString();
    }

    public static String toEscapeCharacter(String value) {
        String result = value;

        result = StringUtils.replace(result, "%", new StringBuilder().append(ESCAPE_CHAR).append("%").toString());
        result = StringUtils.replace(result, "_", new StringBuilder().append(ESCAPE_CHAR).append("_").toString());

        return result;
    }

    public static <T> List<T> pagin(List<T> list, Integer page, Integer size) {
        final List<T> pagedList = list
                                      .stream()
                                      .sorted()
                                      .collect(Collectors.toList());

        if (pagedList != null && !pagedList.isEmpty()
            && page != null && size != null) {
            final List<List<T>> partitions = Lists.partition(pagedList, Math.min(size, 50));
            if (partitions.size() > page) {
                return partitions.get(page);
            } else {
                return Collections.emptyList();
            }
        }

        return pagedList;
    }

}
