package com.finantial.manager.transaction.usecase.impl;

import com.finantial.manager.transaction.domain.Transaction;
import com.finantial.manager.transaction.domain.TransactionRequestDTO;
import com.finantial.manager.transaction.infrastructure.TransactionRepository;
import com.finantial.manager.transaction.usecase.TransactionUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionUseCaseImpl implements TransactionUseCase {

    private final TransactionRepository transactionRepository;

    @Override
    @Transactional
    public void registerTransaction(final TransactionRequestDTO transactionRequestDTO) {
        Transaction newTransaction = new Transaction(
                transactionRequestDTO.description(),
                transactionRequestDTO.recurrence(),
                transactionRequestDTO.amount(),
                transactionRequestDTO.installments(),
                transactionRequestDTO.categoryId()
        );

        transactionRepository.save(newTransaction);
    }

    @Override
    public Page<Transaction> findAllTransactions(final String startDate, final String endDate, final Pageable pageable) {
        throw new RuntimeException("Not implemented yet");
    }
}
