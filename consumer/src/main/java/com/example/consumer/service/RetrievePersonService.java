package com.example.consumer.service;

import com.example.consumer.model.Person;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RetrievePersonService {

    private final RestTemplate restTemplate;

    public RetrievePersonService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Person retrieve() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json");

        ResponseEntity<Person> personResponseEntity = restTemplate.exchange(
                "http://localhost:9090/api/hello",
                HttpMethod.GET,
                new HttpEntity<>(httpHeaders),
                Person.class
        );

        return personResponseEntity.getBody();
    }
}
