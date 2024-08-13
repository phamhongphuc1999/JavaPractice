package com.kafka;

import java.net.URI;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.opensearch.client.RestClient;
import org.opensearch.client.RestHighLevelClient;

import com.kafka.config.Constance;

public class CreateOpenSearchClient {
  public static RestHighLevelClient create() {
    RestHighLevelClient restHighLevelClient;
    URI connUri = URI.create(Constance.OPEN_SEARCH_URL);
    String userInfo = connUri.getUserInfo();

    if (userInfo == null) {
      restHighLevelClient = new RestHighLevelClient(
          RestClient.builder(new HttpHost(connUri.getHost(), connUri.getPort())));
    } else {
      String[] auth = userInfo.split(":");
      CredentialsProvider cp = new BasicCredentialsProvider();
      cp.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(auth[0], auth[1]));

      restHighLevelClient = new RestHighLevelClient(
          RestClient.builder(new HttpHost(connUri.getHost(), connUri.getPort(), connUri.getScheme()))
              .setHttpClientConfigCallback(httpAsyncClientBuilder -> httpAsyncClientBuilder
                  .setDefaultCredentialsProvider(cp).setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy())));
    }
    return restHighLevelClient;
  }
}
