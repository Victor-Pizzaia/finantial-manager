package com.finantial.manager.transaction.usecase;

import com.finantial.manager.transaction.domain.Transaction;
import com.finantial.manager.transaction.domain.TransactionRequestDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TransactionUseCase {
    void registerTransaction(final TransactionRequestDTO transactionRequestDTO);
    Page<Transaction> findAllTransactions(final String startDate, final String endDate, final Pageable pageable);
}
