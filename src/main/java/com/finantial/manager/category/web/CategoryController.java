package com.finantial.manager.category.web;

import com.finantial.manager.category.domain.CategoryRequestDTO;
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
@RequestMapping("/categories")
public class CategoryController {

    @PostMapping
    public ResponseEntity<Void> registerCategory(@Validated @RequestBody CategoryRequestDTO categoryRequestDTO) {
        log.info("[Category] request received, {}", categoryRequestDTO);
        log.info("{} was registered with successfully", categoryRequestDTO.name());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
