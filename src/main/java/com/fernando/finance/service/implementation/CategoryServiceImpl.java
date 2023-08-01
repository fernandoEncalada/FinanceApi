package com.fernando.finance.service.implementation;

import com.fernando.finance.model.dbmo.Category;
import com.fernando.finance.model.dto.category.CategoryRequestDto;
import com.fernando.finance.model.dto.category.CategoryResponseDto;
import com.fernando.finance.model.repository.CategoryRepository;
import com.fernando.finance.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryResponseDto> get() {
        return categoryRepository.findAll().stream().map(this::mapToDto).toList();
    }

    @Override
    public CategoryResponseDto save(CategoryRequestDto categoryRequestDto) {
        Category category = new Category();
        category.setName(categoryRequestDto.getName());
        category = categoryRepository.save(category);

        return mapToDto(category);
    }

    @Override
    public CategoryResponseDto update(int id, CategoryRequestDto categoryRequestDto) {
        Category category = categoryRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Error at update Category"));
        category.setName(categoryRequestDto.getName());
        category = categoryRepository.save(category);

        return mapToDto(category);
    }

    private CategoryResponseDto mapToDto(Category category) {
        CategoryResponseDto categoryResponseDto = new CategoryResponseDto();
        categoryResponseDto.setId(category.getId());
        categoryResponseDto.setName(category.getName());

        return categoryResponseDto;
    }
}
