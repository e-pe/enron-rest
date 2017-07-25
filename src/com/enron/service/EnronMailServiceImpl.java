package com.enron.service;

import com.enron.gateway.EnronSearchGateway;
import com.enron.service.dto.EnronMailDto;
import com.enron.service.dto.EnronMailDtoResult;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.Map;

public class EnronMailServiceImpl implements EnronMailService {
    private EnronSearchGateway searchGateway;

    public EnronMailServiceImpl(EnronSearchGateway gateway) {
        this.searchGateway = gateway;
    }

    public EnronMailDtoResult searchMails(String query) {
        EnronMailDtoResult dtoResult = new EnronMailDtoResult();

        Map<String, JsonNode> results = this.searchGateway.performMailSearch(query);

        for (Map.Entry<String, JsonNode> entry : results.entrySet()) {
            EnronMailDto mailDto = new EnronMailDto()
                    .setId(entry.getKey())
                    .setContent(entry.getValue());

            dtoResult.getMails().add(mailDto);
        }

        dtoResult.setCount(results.size());

        return dtoResult;
    }
}
