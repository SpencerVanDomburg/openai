package com.openai.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.openai.domain.QuestionForm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

    @CrossOrigin(origins = "*")
    @PostMapping("/v1/answers")
    public ResponseEntity<Object> getAnswer(
//            @RequestBody QuestionForm questionForm
    ) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.setBearerAuth(apiKey);
        Map<String, String> bodyParamMap = new HashMap<String, String>();

        //Set your request body params
//        bodyParamMap.put("documents", questionForm.getDocuments().toString());
//        bodyParamMap.put("question", questionForm.getQuestion());
//        bodyParamMap.put("search_model", questionForm.getSearchModel());
//        bodyParamMap.put("model", questionForm.getModel());
//        bodyParamMap.put("examples_context", questionForm.getExampleContext());
//        bodyParamMap.put("examples", questionForm.getExamples().toString());
//        bodyParamMap.put("max_tokens", String.valueOf(questionForm.getMaxTokens()));
//        bodyParamMap.put("stop", questionForm.getStop().toString());

        String reqBodyData = new ObjectMapper().writeValueAsString(bodyParamMap);
        String reqBodyData2 = "{\n" +
                "    \"documents\": [\"Puppy A is happy.\", \"Puppy B is sad.\"],\n" +
                "    \"question\": \"which puppy is happy?\",\n" +
                "    \"search_model\": \"ada\",\n" +
                "    \"model\": \"curie\",\n" +
                "    \"examples_context\": \"In 2017, U.S. life expectancy was 78.6 years.\",\n" +
                "    \"examples\": [[\"What is human life expectancy in the United States?\",\"78 years.\"]],    \n" +
                "    \"max_tokens\": 5,\n" +
                "    \"stop\": [\"\\n\", \"<|endoftext|>\"]\n" +
                "  }";

        HttpEntity<String> requestEnty = new HttpEntity<>(reqBodyData2, header);


        Object response
                = restTemplate.postForEntity("https://api.openai.com/v1/answers", requestEnty, Object.class);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }
}
