package com.yogi.config;


import com.yogi.common.FileScannerApi;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class TestConfigApi {
    @Autowired
    TestProperties testProperties;

    @Bean
    public HttpClient httpClient() {
        return HttpClientBuilder.create().build();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate(new HttpComponentsClientHttpRequestFactory(httpClient()));
    }

    @Bean
    public FileScannerApi fileScannerApi() {
        return new FileScannerApi(testProperties.getFileScannerBaseURL() , restTemplate());
    }


}