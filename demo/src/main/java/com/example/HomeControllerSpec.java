package com.example;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
public class HomeControllerSpec {

    @Inject
    EmbeddedServer embeddedServer;

    @Inject
    @Client("/")
    HttpClient httpClient;

    @Test
    void testHomeResponse() {
        String response = httpClient.toBlocking().retrieve(HttpRequest.GET("/"));
        assertEquals("<div><h1 align=\"center\">This is your Home</h1></div>", response);
    }
}
