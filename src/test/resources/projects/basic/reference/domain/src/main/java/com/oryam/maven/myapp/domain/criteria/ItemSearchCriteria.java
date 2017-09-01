package com.oryam.maven.myapp.domain.criteria;

public class ItemSearchCriteria {

    private final String code;

    public ItemSearchCriteria(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
