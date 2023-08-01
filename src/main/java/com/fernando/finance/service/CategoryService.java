package com.fernando.finance.service;

import com.fernando.finance.model.dbmo.Category;
import com.fernando.finance.model.dto.category.CategoryRequestDto;
import com.fernando.finance.model.dto.category.CategoryResponseDto;

import java.util.List;

public interface CategoryService {
    List<CategoryResponseDto> get();
    CategoryResponseDto save(CategoryRequestDto categoryRequestDto);
    CategoryResponseDto update(int id, CategoryRequestDto categoryRequestDto);
}
