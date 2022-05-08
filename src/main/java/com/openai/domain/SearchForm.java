package com.openai.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class SearchForm {

    @JsonProperty("documents")
    private ArrayList<String> documents;

    @JsonProperty("query")
    private String query;
}
