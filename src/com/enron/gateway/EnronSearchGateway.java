package com.enron.gateway;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.Map;

public interface EnronSearchGateway {
    Map<String, JsonNode> performMailSearch(String query);
}
