package com.fernando.finance.controller;

import com.fernando.finance.model.dto.category.CategoryRequestDto;
import com.fernando.finance.model.dto.category.CategoryResponseDto;
import com.fernando.finance.model.dto.person.PersonRequestDto;
import com.fernando.finance.model.dto.person.PersonResponseDto;
import com.fernando.finance.service.CategoryService;
import com.fernando.finance.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@CrossOrigin
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    private ResponseEntity<List<CategoryResponseDto>> get() {
        return new ResponseEntity<>(categoryService.get(), HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<CategoryResponseDto> save(@RequestBody CategoryRequestDto categoryRequestDto) {
        return new ResponseEntity<>(categoryService.save(categoryRequestDto), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<CategoryResponseDto> update(
            @PathVariable int id,
            @RequestBody CategoryRequestDto categoryRequestDto
    ) {
        return new ResponseEntity<>(categoryService.update(id, categoryRequestDto), HttpStatus.OK);
    }
}
