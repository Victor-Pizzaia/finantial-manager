package com.finantial.manager.category.web;

import com.finantial.manager.category.domain.CategoryRequestDTO;
import com.finantial.manager.category.domain.CategoryResponseDTO;
import com.finantial.manager.category.usecase.CategoryUseCase;
import com.finantial.manager.transaction.domain.PageResponse;
import com.finantial.manager.transaction.domain.Transaction;
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
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryUseCase categoryUseCase;

    @PostMapping
    public ResponseEntity<Void> registerCategory(@Validated @RequestBody final CategoryRequestDTO categoryRequestDTO) {
        log.info("[Category] request received, {}", categoryRequestDTO);
        categoryUseCase.registerCategory(categoryRequestDTO);
        log.info("{} was registered with successfully", categoryRequestDTO.name());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> findAllCategories() {
        log.info("[Category] request received to list");
        return ResponseEntity.ok(categoryUseCase.findAllCategories());
    }
}
