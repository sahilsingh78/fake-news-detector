package com.sahil.fakenews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sahil.fakenews.service.FakeNewsService;

import java.util.Map;

@RestController
@RequestMapping("/api/news")
@CrossOrigin(origins = "*")
public class FakeNewsController {

    @Autowired
    private FakeNewsService fakeNewsService;

    @PostMapping(value = "/check", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> checkNews(@RequestBody Map<String, String> request) {
        String text = request.get("text");

        if (text == null || text.isEmpty()) {
            return ResponseEntity.badRequest().body("Missing 'text' field");
        }

        String result = fakeNewsService.checkFakeNews(text);
        return ResponseEntity.ok(Map.of("prediction", result, "status", "success"));
    }
}
