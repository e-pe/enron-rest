package com.enron.rest;

import com.enron.service.EnronMailService;
import com.enron.service.EnronMailServiceImpl;
import com.enron.gateway.ElasticSearchGatewayOptions;
import com.enron.gateway.EnronSearchGatewayImpl;
import com.enron.service.dto.EnronMailDtoResult;
import com.enron.service.dto.EnronMailDtoResultUtility;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/mails")
public class EnronMailControllerImpl implements EnronMailController {
    private EnronMailService mailService;

    public EnronMailControllerImpl() {
        this.mailService = new EnronMailServiceImpl(
            new EnronSearchGatewayImpl(
                    new ElasticSearchGatewayOptions()
                        .setHost("127.0.0.1")
                        .setPort(9300)
            ));
    }

    @GET
    @Path("/search")
    @Produces("application/json")
    public Response searchMails(@QueryParam("q") String query) {
        EnronMailDtoResult dtoResult = this.mailService.searchMails(query);

        String dtoResultJson = EnronMailDtoResultUtility.toJson(dtoResult);

        return Response.status(200)
                .header("Access-Control-Allow-Origin", "*")
                .entity(dtoResultJson)
                .build();
    }
}
