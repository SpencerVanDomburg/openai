package com.openai.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class QuestionForm {

    private String exampleContext;
    private String searchModel;
    private String question;
    private ArrayList<Example> examples;
    private ArrayList<String> stop;
    private ArrayList<String> documents;
    private int maxTokens;
    private String model;
}
