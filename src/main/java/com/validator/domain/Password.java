package com.validator.domain;

import java.util.ArrayList;
import java.util.List;

public class Password {
    private String text;
    private Boolean valid;
    private List<String> errorsList = new ArrayList<>();

    public Password(String text){
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public void appendError(String error){
        errorsList.add(error);
    }

    public List<String> getErrorsList() {
        return errorsList;
    }
}
