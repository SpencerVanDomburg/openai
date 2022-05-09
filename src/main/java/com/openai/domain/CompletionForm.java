package com.openai.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CompletionForm {

    @JsonProperty("prompt")
    private String prompt;

    @JsonProperty("max_tokens")
    private int maxTokens;

    @JsonProperty("temperature")
    private double temperature;

    @JsonProperty("top_p")
    private double topP;

    @JsonProperty("n")
    private int n;

    @JsonProperty("stream")
    private boolean stream;

    @JsonProperty("logprobs")
    private String logProbs;

    @JsonProperty("stop")
    private String stop;


}
