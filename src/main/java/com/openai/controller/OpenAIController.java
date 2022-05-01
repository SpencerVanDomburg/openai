package com.openai.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.openai.domain.CompletionForm;
import com.openai.domain.QuestionForm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class OpenAIController {

    @Value("${openai.api.key}")
    private String apiKey;

    private String OPEN_AI_URL = "https://api.openai.com";

    @CrossOrigin(origins = "*")
    @PostMapping("/v1/answers")
    public ResponseEntity<Object> getAnswer(
            @RequestBody QuestionForm questionForm
    ) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.setBearerAuth(apiKey);
        String reqBodyData = new ObjectMapper().writeValueAsString(questionForm);

        HttpEntity<String> requestEnty = new HttpEntity<>(reqBodyData, header);

        Object response
                = restTemplate.postForEntity(OPEN_AI_URL + "/v1/answers", requestEnty, Object.class);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/v1/engines/{engine}/completions")
    public ResponseEntity<Object> getCompletion(
            @PathVariable("engine") String engine,
            @RequestBody CompletionForm completionForm
    ) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.setBearerAuth(apiKey);
        String reqBodyData = new ObjectMapper().writeValueAsString(completionForm);

        HttpEntity<String> requestEnty = new HttpEntity<>(reqBodyData, header);

        Object response
                = restTemplate.postForEntity(OPEN_AI_URL + "/v1/engines/" + engine + "/completions", requestEnty, Object.class);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }


}
