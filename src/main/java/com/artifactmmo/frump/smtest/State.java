package com.artifactmmo.frump.smtest;

import java.util.List;

public class State {
    private String name;
    private String type;
    private List<Transition> pre_transitions;
    private List<Transition> post_transitions;

    private String action;//if action != null, do action until transition takes us away
    private String args;//null if no args

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public List<Transition> getPre_transitions() {
        return pre_transitions;
    }

    public List<Transition> getPreTransitions() {
        return pre_transitions;
    }

    public void setPre_transitions(List<Transition> pre_transitions) {
        this.pre_transitions = pre_transitions;
    }

    public List<Transition> getPost_transitions() {
        return post_transitions;
    }

    public List<Transition> getPostTransitions() {
        return post_transitions;
    }

    public void setPost_transitions(List<Transition> post_transitions) {
        this.post_transitions = post_transitions;
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }
}