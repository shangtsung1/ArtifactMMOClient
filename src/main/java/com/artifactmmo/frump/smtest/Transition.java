package com.artifactmmo.frump.smtest;

import java.util.List;

public class Transition {
    private List<String> conditions;
    private String targetState;

    // Getters and Setters
    public List<String> getConditions() {
        return conditions;
    }

    public void setConditions(List<String> conditions) {
        this.conditions = conditions;
    }

    public String getTargetState() {
        return targetState;
    }

    public void setTargetState(String targetState) {
        this.targetState = targetState;
    }
}