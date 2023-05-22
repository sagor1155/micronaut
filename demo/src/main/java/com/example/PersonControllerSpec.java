package com.example;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@MicronautTest
public class PersonControllerSpec {

    @Inject
    EmbeddedServer embeddedServer;

    @Inject
    @Client("/person")
    HttpClient httpClient;

    @Test
    void testPersonCreated() {
        String response = httpClient.toBlocking().retrieve(HttpRequest.POST("/create", new Person(1, "sagor", 31)));
        Assertions.assertEquals(response, "{\"id\":1,\"name\":\"sagor\",\"age\":31}");
    }
}
