package com.enron.service.dto;

import com.fasterxml.jackson.databind.JsonNode;

public class EnronMailDto {
    private String id;
    private JsonNode content;

    public String getId() {
        return this.id;
    }

    public EnronMailDto setId(String id) {
        this.id = id;

        return this;
    }

    public JsonNode getContent() {
        return this.content;
    }

    public EnronMailDto setContent(JsonNode content) {
        this.content = content;

        return this;
    }
}
