package com.moredabuhamed.medical_symptom_checker.controller;

import com.moredabuhamed.medical_symptom_checker.model.ConditionResult;
import com.moredabuhamed.medical_symptom_checker.service.OllamaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class SymptomApiController {

    @Autowired
    private OllamaService ollamaService;

    /**
     * First call → get list of conditions (names only).
     */
    @PostMapping("/check-symptoms")
    public List<ConditionResult> checkSymptoms(@RequestBody Map<String, String> body) {
        String symptoms = body.get("symptoms");
        return ollamaService.askOllamaBasic(symptoms);
    }

    /**
     * Second call → get detailed explanation for one condition.
     */
    @PostMapping("/condition-details")
    public ConditionResult getConditionDetails(@RequestBody Map<String, String> body) {
        String condition = body.get("condition");
        String symptoms = body.get("symptoms");
        return ollamaService.askOllamaDetails(condition, symptoms);
    }
}
