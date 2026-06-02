package com.bank.transaction.client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class ExternalServiceClient {

    private final WebClient webClient;

    public ExternalServiceClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public String callExternalService() {
        return webClient.get()
               .uri("http://localhost:8082/external-service")
               .retrieve()
               .bodyToMono(String.class)
               .block();
    }
}