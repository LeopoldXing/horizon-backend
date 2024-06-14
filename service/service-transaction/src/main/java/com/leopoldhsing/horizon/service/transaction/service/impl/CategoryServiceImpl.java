package com.leopoldhsing.horizon.service.transaction.service.impl;

import com.leopoldhsing.horizon.model.dto.CategoryDto;
import com.leopoldhsing.horizon.model.entity.Category;
import com.leopoldhsing.horizon.service.transaction.mapper.CategoryMapper;
import com.leopoldhsing.horizon.service.transaction.repository.CategoryRepository;
import com.leopoldhsing.horizon.service.transaction.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.atomic.AtomicReference;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    @Override
    public CategoryDto saveOrCreateCategory(String categoryName) {
        AtomicReference<CategoryDto> categoryDto = new AtomicReference<>();
        categoryRepository.findByCategoryName(categoryName).ifPresentOrElse(
                category -> categoryDto.set(CategoryMapper.mapToCategoryDto(category)),
                () -> {
                    Category category = new Category();
                    category.setCategoryName(categoryName);
                    category.setCategoryCode(categoryName);
                    Category saved = categoryRepository.save(category);
                    categoryDto.set(CategoryMapper.mapToCategoryDto(saved));
                }
        );

        return categoryDto.get();
    }
}
