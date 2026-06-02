package com.bank.transaction.controller;

import com.bank.transaction.dto.TransactionRequest;
import com.bank.transaction.dto.TransactionResponse;
import com.bank.transaction.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.reactive.function.WebTestClient.bindToController;
import static org.springframework.test.web.reactive.function.WebTestClient.bindToRouterFunction;

@SpringBootTest
class TransactionControllerTest {

    @Autowired
    private TransactionController transactionController;

    @MockBean
    private TransactionService transactionService;

    @Test
    void createTransaction() {
        TransactionRequest request = new TransactionRequest();
        request.setAmount(100.0);
        request.setCurrency("USD");
        request.setDescription("Test transaction");

        TransactionResponse response = new TransactionResponse();
        response.setId(1L);
        response.setAmount(100.0);
        response.setCurrency("USD");
        response.setDescription("Test transaction");

        when(transactionService.createTransaction(request)).thenReturn(response);

        WebTestClient webTestClient = bindToController(transactionController).build();

        webTestClient.post()
               .uri("/transactions")
               .bodyValue(request)
               .exchange()
               .expectStatus().isOk()
               .expectBody(TransactionResponse.class)
               .isEqualTo(response);
    }

    @Test
    void getTransactionById() {
        Long id = 1L;

        TransactionResponse response = new TransactionResponse();
        response.setId(id);
        response.setAmount(100.0);
        response.setCurrency("USD");
        response.setDescription("Test transaction");

        when(transactionService.getTransactionById(id)).thenReturn(response);

        WebTestClient webTestClient = bindToController(transactionController).build();

        webTestClient.get()
               .uri("/transactions/{id}", id)
               .exchange()
               .expectStatus().isOk()
               .expectBody(TransactionResponse.class)
               .isEqualTo(response);
    }
}