package com.finantial.manager.category.usecase.impl;

import com.finantial.manager.category.domain.Category;
import com.finantial.manager.category.domain.CategoryRequestDTO;
import com.finantial.manager.category.domain.CategoryResponseDTO;
import com.finantial.manager.category.infrastructure.CategoryRepository;
import com.finantial.manager.category.usecase.CategoryUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryUseCaseImpl implements CategoryUseCase {

    private final CategoryRepository categoryRepository;

    @Override
    @Transactional
    public void registerCategory(final CategoryRequestDTO categoryRequestDTO) {
        Category newCategory = new Category(
                categoryRequestDTO.name(),
                categoryRequestDTO.description());

        categoryRepository.save(newCategory);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryResponseDTO> findAllCategories() {
        return categoryRepository.findAll().stream()
                .map(CategoryResponseDTO::from)
                .toList();
    }
}
