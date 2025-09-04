package com.moredabuhamed.medical_symptom_checker.model;

public class ConditionResult {
    private String name;
    private int confidence;
    private String reason; // will be "" in first call, detailed in second call

    public ConditionResult(String name, int confidence, String reason) {
        this.name = name;
        this.confidence = confidence;
        this.reason = reason;
    }

    public String getName() {
        return name;
    }

    public int getConfidence() {
        return confidence;
    }

    public String getReason() {
        return reason;
    }
}
