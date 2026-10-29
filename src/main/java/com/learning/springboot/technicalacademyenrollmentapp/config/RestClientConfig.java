package com.learning.springboot.technicalacademyenrollmentapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Bean
    public RestClient.Builder getRestClientBuilder(){
        return RestClient.builder();
    }

    @Bean
    public RestClient getRestClient(RestClient.Builder builder){
        return builder.build();
    }

}
