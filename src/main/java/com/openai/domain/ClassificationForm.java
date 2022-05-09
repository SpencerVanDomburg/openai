package com.openai.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class ClassificationForm {

    @JsonProperty("examples")
    private ArrayList<ArrayList<String>> examples;

    @JsonProperty("labels")
    private ArrayList<String> labels;

    @JsonProperty("query")
    private String query;

    @JsonProperty("search_model")
    private String searchModel;

    @JsonProperty("model")
    private String model;
}
