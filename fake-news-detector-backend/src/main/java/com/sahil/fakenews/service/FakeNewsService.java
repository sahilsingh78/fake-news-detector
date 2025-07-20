package com.sahil.fakenews.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class FakeNewsService {

    public String checkFakeNews(String text) {
        String flaskUrl = "http://localhost:5000/predict";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, String> request = new HashMap<>();
        request.put("text", text);

        HttpEntity<Map<String, String>> entity = new HttpEntity<>(request, headers);

        try {
            ResponseEntity<Map> response = restTemplate.postForEntity(flaskUrl, entity, Map.class);
            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
                return (String) response.getBody().get("prediction");
            } else {
                return "error";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
}
