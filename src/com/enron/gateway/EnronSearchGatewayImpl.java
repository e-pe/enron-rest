package com.enron.gateway;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EnronSearchGatewayImpl
        extends ElasticSearchGateway
        implements EnronSearchGateway {

    private static String ENRON_INDEX_NAME = "enron";
    private static String ENRON_MAIL_TYPE_NAME = "mail";

    public EnronSearchGatewayImpl(ElasticSearchGatewayOptions options) {
        super(options);
    }

    public Map<String, JsonNode> performMailSearch(String query) {
        HashMap<String, JsonNode> results = new HashMap<>();

        try {
            Client client = this.getClient();

            QueryBuilder matchQuery =
                    QueryBuilders.matchQuery("_all", query);

            SearchRequestBuilder searchRequest =
                    client.prepareSearch(ENRON_INDEX_NAME)
                            .setTypes(ENRON_MAIL_TYPE_NAME)
                            .setQuery(matchQuery)
                            .setSize(100)
                            .setExplain(true);

            SearchResponse searchResponse = searchRequest.get();

            for (SearchHit searchHit : searchResponse.getHits()) {
                JsonNode searchHitContent = new ObjectMapper().readTree(
                        searchHit.getSourceAsString());

                results.put(searchHit.getId(), searchHitContent);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return results;
    }
}
