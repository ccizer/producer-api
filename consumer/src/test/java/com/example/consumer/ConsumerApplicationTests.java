package com.example.consumer;

import com.example.consumer.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureStubRunner(stubsMode = StubRunnerProperties.StubsMode.REMOTE,
        repositoryRoot = "http://172.17.0.3:8081/artifactory/libs-snapshot-local",
        ids = "com.ccizer:producer:+:stubs:9090"
)
public class ConsumerApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void shouldRetrievePerson() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json");

        ResponseEntity<Person> personResponseEntity = restTemplate.exchange(
                "http://localhost:" + port + "/api/welcome",
                HttpMethod.GET,
                new HttpEntity<>(httpHeaders),
                Person.class
        );

        assertThat(personResponseEntity, is(notNullValue()));
        assertThat(personResponseEntity.getStatusCode(), is(equalTo(HttpStatus.OK)));
        assertThat(personResponseEntity.getBody(),
                allOf(
                        hasProperty("name", is(equalTo("Can"))),
                        hasProperty("surname", is(equalTo("Cizer")))
                )
        );
    }

}
