package com.finantial.manager.category.domain;

import java.util.UUID;

public record CategoryResponseDTO(UUID id, String name) {
    public static CategoryResponseDTO from(final Category category) {
        return new CategoryResponseDTO(category.getId(), category.getName());
    }
}
