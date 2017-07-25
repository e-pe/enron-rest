package com.enron.service.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EnronMailDtoResultUtility {
    public static String toJson(EnronMailDtoResult dtoResult) {
        String dtoResultJson = "{}";

        try {
            dtoResultJson = new ObjectMapper()
                .writeValueAsString(dtoResult);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return dtoResultJson;
    }
}
