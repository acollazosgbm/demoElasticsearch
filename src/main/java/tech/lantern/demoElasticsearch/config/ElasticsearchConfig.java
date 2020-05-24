package tech.lantern.demoElasticsearch.config;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestClientBuilder.HttpClientConfigCallback;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = { "tech.lantern.demoElasticsearch.repository" })
public class ElasticsearchConfig {

	// https://71201f5747c140588f36ddbb2f50ad78.us-east-1.aws.found.io:9243

	@Value("${elasticsearch.host:71201f5747c140588f36ddbb2f50ad78.us-east-1.aws.found.io}")
	public String host;
	@Value("${elasticsearch.port:9243}")
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

		HttpHost targetHost = new HttpHost(host, port, "https");
		
		RestClientBuilder restClient = getRestClientBuilder(targetHost);

		RestHighLevelClient client = new RestHighLevelClient(restClient);

		return client;
	}

	private RestClientBuilder getRestClientBuilder(HttpHost httpHost) {

		final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
		credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials("acollazos", "Andr3sco2020"));

		RestClientBuilder builder = RestClient.builder(httpHost)
				.setHttpClientConfigCallback(new HttpClientConfigCallback() {
					@Override
					public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpClientBuilder) {
						return httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
					}
				});

		return builder;

	}

}
