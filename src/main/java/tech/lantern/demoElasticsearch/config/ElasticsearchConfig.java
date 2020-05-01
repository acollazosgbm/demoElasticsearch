package tech.lantern.demoElasticsearch.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = { "tech.lantern.demoElasticsearch.repository" })
public class ElasticsearchConfig {
	@Value("${elasticsearch.host:192.168.1.31}")
	public String host;
	@Value("${elasticsearch.port:9200}")
	public int port;

	public String getHost() {
		return host;
	}

	public int getPort() {
		return port;
	}

	// private int timeout = 60;

	@Bean
	public RestHighLevelClient client() {
		System.out.println("host:" + host + "port:" + port);

		RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost(host, port, "http")));

		return client;
	}
}
