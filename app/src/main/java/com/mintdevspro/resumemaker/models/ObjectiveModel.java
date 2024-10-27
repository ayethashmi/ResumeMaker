package com.mintdevspro.resumemaker.models;

public class ObjectiveModel {
    private String cvobective;

    public String getCvobective() {
        return this.cvobective;
    }

    public void setCvobective(String str) {
        this.cvobective = str;
    }

    public ObjectiveModel(String str) {
        this.cvobective = str;
    }
}
