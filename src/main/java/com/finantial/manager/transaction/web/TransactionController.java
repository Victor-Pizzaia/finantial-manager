package com.finantial.manager.transaction.web;

import com.finantial.manager.transaction.domain.PageResponse;
import com.finantial.manager.transaction.domain.Transaction;
import com.finantial.manager.transaction.domain.TransactionRequestDTO;
import com.finantial.manager.transaction.usecase.TransactionUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionUseCase transactionUseCase;

    @PostMapping
    public ResponseEntity<Void> registerTransaction(@Validated @RequestBody final TransactionRequestDTO transactionRequestDTO) {
        log.info("[Transaction] request received, {}", transactionRequestDTO);
        transactionUseCase.registerTransaction(transactionRequestDTO);
        log.info("[Transaction] {} was registered with successfully", transactionRequestDTO.description());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<PageResponse<Transaction>> getTransactions(@RequestParam(required = false) String startDate,
                                                                     @RequestParam(required = false) String endDate,
                                                                     @PageableDefault(size = 50) Pageable pageable) {
        log.info("[Transaction] request received to list");
        Page<Transaction> retrievedTransactions = transactionUseCase.findAllTransactions(startDate, endDate, pageable);
        log.info("[Transaction] success retrieving transactions");
        return new ResponseEntity<>(PageResponse.from(retrievedTransactions), HttpStatus.OK);
    }
}
