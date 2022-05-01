package com.openai.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class QuestionForm {

    @JsonProperty("documents")
    private ArrayList<String> documents;

    @JsonProperty("question")
    private String question;

    @JsonProperty("search_model")
    private String searchModel;

    @JsonProperty("model")
    private String model;

    @JsonProperty("examples")
    private ArrayList<ArrayList<String>> examples;

    @JsonProperty("examples_context")
    private String examplesContext;

    @JsonProperty("max_tokens")
    private int maxTokens;

    @JsonProperty("stop")
    private ArrayList<String> stop;
}
