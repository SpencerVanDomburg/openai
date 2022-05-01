package com.openai.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class QuestionForm {

    private ArrayList<String> documents;

    private String question;

    @JsonProperty("search_model")
    private String searchModel;

    private String model;

    private ArrayList<ArrayList<String>> examples;

    @JsonProperty("examples_context")
    private String examplesContext;

    @JsonProperty("max_tokens")
    private int maxTokens;

    private ArrayList<String> stop;
}
