package com.enron.gateway;

public class ElasticSearchGatewayOptions {
    private String host;
    private Integer port;

    public String getHost() {
        return this.host;
    }

    public ElasticSearchGatewayOptions setHost(String host) {
        this.host = host;

        return this;
    }

    public Integer getPort() {
        return this.port;
    }

    public ElasticSearchGatewayOptions setPort(Integer port) {
        this.port = port;

        return this;
    }
}
