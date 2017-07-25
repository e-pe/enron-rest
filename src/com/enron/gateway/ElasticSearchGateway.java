package com.enron.gateway;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

public abstract class ElasticSearchGateway {
     private Client client;
     private ElasticSearchGatewayOptions gatewayOptions;

     public ElasticSearchGateway(ElasticSearchGatewayOptions gatewayOptions) {
         this.gatewayOptions = gatewayOptions;
     }

     protected Client getClient() {
          if (this.client == null) {
               this.client = this.createClient();
          }

          return this.client;
     }

     private Client createClient() {
          TransportClient transportClient = null;

          try {
               transportClient = new PreBuiltTransportClient(Settings.EMPTY)
                       .addTransportAddress(
                               new InetSocketTransportAddress(
                                       InetAddress.getByName(this.gatewayOptions.getHost()),
                                       this.gatewayOptions.getPort()));

          } catch (UnknownHostException e) {
               e.printStackTrace();
          }

          return transportClient;
     }
}
