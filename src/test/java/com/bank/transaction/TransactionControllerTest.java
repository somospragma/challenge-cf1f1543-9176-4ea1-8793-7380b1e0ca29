package com.bank.transaction.service;

import com.bank.transaction.dto.TransactionRequest;
import com.bank.transaction.dto.TransactionResponse;
import com.bank.transaction.model.Transaction;
import com.bank.transaction.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import java.util.Optional;

@SpringBootTest
class TransactionServiceTest {

    @Autowired
    private TransactionService transactionService;

    @MockBean
    private TransactionRepository transactionRepository;

    @Test
    void createTransaction() {
        TransactionRequest request = new TransactionRequest();
        request.setAmount(100.0);
        request.setCurrency("USD");
        request.setDescription("Test transaction");

        Transaction transaction = new Transaction();
        transaction.setAmount(100.0);
        transaction.setCurrency("USD");
        transaction.setDescription("Test transaction");

        Mockito.when(transactionRepository.save(Mockito.any(Transaction.class))).thenReturn(transaction);

        TransactionResponse response = transactionService.createTransaction(request);

        assert response!= null;
        assert response.getAmount().equals(100.0);
        assert response.getCurrency().equals("USD");
        assert response.getDescription().equals("Test transaction");
    }

    @Test
    void getTransactionById() {
        Long id = 1L;

        Transaction transaction = new Transaction();
        transaction.setId(id);
        transaction.setAmount(100.0);
        transaction.setCurrency("USD");
        transaction.setDescription("Test transaction");

        Mockito.when(transactionRepository.findById(id)).thenReturn(Optional.of(transaction));

        TransactionResponse response = transactionService.getTransactionById(id);

        assert response!= null;
        assert response.getId().equals(id);
        assert response.getAmount().equals(100.0);
        assert response.getCurrency().equals("USD");
        assert response.getDescription().equals("Test transaction");
    }
}