package com.pragma.productservice.client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class OtherServiceClient {

    private final WebClient webClient;

    public OtherServiceClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://other-service").build();
    }

    public void callOtherService() {
        // Implementar la lógica de llamada al otro servicio
    }
}