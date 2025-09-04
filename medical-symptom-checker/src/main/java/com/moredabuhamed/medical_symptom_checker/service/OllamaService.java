package com.moredabuhamed.medical_symptom_checker.service;

import com.moredabuhamed.medical_symptom_checker.model.ConditionResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class OllamaService {

    private final String url = "http://localhost:11434/api/generate";
    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * First call → list of conditions (no confidence, just names).
     */
    public List<ConditionResult> askOllamaBasic(String prompt) {
        Map<String, Object> request = Map.of(
                "model", "deepseek-r1:1.5b",
                "prompt", "User symptoms: " + prompt +
                        "\nList 5 to 7 possible medical conditions related to these symptoms. " +
                        "Do NOT include confidence percentages. " +
                        "Format strictly as:\nCondition",
                "stream", false
        );

        Map response = restTemplate.postForObject(url, request, Map.class);
        List<ConditionResult> results = new ArrayList<>();

        if (response == null || !response.containsKey("response")) {
            return results;
        }

        String raw = response.get("response").toString();
        raw = raw.replaceAll("(?s)<think>.*?</think>", "").trim();

        String[] lines = raw.split("\\n");
        for (String line : lines) {
            if (!line.trim().isEmpty()) {
                results.add(new ConditionResult(line.trim(), 0, "")); // confidence always 0
            }
        }
        return results;
    }

    /**
     * Second call → detailed explanation for one condition.
     */
    public ConditionResult askOllamaDetails(String condition, String symptoms) {
        Map<String, Object> request = Map.of(
                "model", "deepseek-r1:1.5b",
                "prompt", "User symptoms: " + symptoms +
                        "\nProvide a detailed medical explanation for this condition: " + condition +
                        "\nWrite 3–5 sentences including causes, symptoms, and why it relates to the input. " +
                        "\nReturn plain text only.",
                "stream", false
        );

        Map response = restTemplate.postForObject(url, request, Map.class);

        if (response == null || !response.containsKey("response")) {
            return new ConditionResult(condition, 0, "No details found.");
        }

        String raw = response.get("response").toString();
        raw = raw.replaceAll("(?s)<think>.*?</think>", "").trim();

        return new ConditionResult(condition, 0, raw);
    }
}
