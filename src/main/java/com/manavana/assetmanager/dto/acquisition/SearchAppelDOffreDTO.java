package com.manavana.assetmanager.dto.acquisition;

import java.util.List;

public class SearchAppelDOffreDTO {
    private String text;

    private List<String> fields;

    private Integer limit;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getFields() {
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
