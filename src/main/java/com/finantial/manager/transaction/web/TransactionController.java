package com.finantial.manager.transaction.web;

import com.finantial.manager.transaction.domain.TransactionRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/transactions")
public class TransactionController {

    @PostMapping
    public ResponseEntity<Void> registerTransaction(@Validated @RequestBody TransactionRequestDTO transactionRequestDTO) {
        log.info("[Transaction] request received, {}", transactionRequestDTO);
//        dessertUseCase.registerDessert(dessertRequestDTO, getOwnerId(authentication));
        log.info("{} was registered with successfully", transactionRequestDTO.description());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
