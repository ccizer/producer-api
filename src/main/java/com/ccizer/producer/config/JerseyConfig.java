package com.ccizer.producer.config;

import com.ccizer.producer.service.HelloService;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(HelloService.class);
    }
}
