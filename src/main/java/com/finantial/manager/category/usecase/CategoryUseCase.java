package com.finantial.manager.category.usecase;

import com.finantial.manager.category.domain.CategoryRequestDTO;
import com.finantial.manager.category.domain.CategoryResponseDTO;

import java.util.List;

public interface CategoryUseCase {
    void registerCategory(final CategoryRequestDTO dessertRequestDTO);
    List<CategoryResponseDTO> findAllCategories();
}
