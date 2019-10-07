package com.example.consumer.config;

import com.example.consumer.service.RetrievePersonService;
import com.example.consumer.service.WelcomeService;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class JerseyService extends ResourceConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public JerseyService() {
        register(WelcomeService.class);
        register(RetrievePersonService.class);
    }
}
