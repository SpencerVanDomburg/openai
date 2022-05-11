package com.openai.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditForm {

    @JsonProperty("input")
    private String input;

    @JsonProperty("instruction")
    private String instruction;

    @JsonProperty("temperature")
    private double temperature;

    @JsonProperty("top_p")
    private double topP;
}
