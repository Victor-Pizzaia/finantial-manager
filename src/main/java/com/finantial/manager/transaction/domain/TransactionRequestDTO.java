package com.finantial.manager.transaction.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record TransactionRequestDTO(
        @NotNull @NotBlank String description,
        @NotNull Recurrence recurrence,
        @NotNull BigDecimal amount,
        @NotNull short installments,
        @NotNull UUID categoryId
) {
}
