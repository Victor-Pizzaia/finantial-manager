package com.finantial.manager.category.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CategoryRequestDTO(@NotNull @NotBlank String name, String description) {
}
