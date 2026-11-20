package com.finantial.manager.transaction.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record TransactionRequestDTO(
        @NotNull @NotBlank String description,
        @NotNull Recurrence recurrence,
        @NotNull Double amount,
        @NotNull short installments,
        @NotNull short categoryId,
        @NotNull Date createdAt
) {
}
