package org.example.web.dto;

import javax.validation.constraints.NotBlank;

public class BookRegexToRemove {

    @NotBlank(message = "Regex is not empty")
    private String regexValue;

    public String getRegexValue() {
        return regexValue;
    }

    public void setRegexValue(String regexValue) {
        this.regexValue = regexValue;
    }
}
