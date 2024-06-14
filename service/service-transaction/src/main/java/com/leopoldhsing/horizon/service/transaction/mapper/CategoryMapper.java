package com.leopoldhsing.horizon.service.transaction.mapper;

import com.leopoldhsing.horizon.model.dto.CategoryDto;
import com.leopoldhsing.horizon.model.entity.Category;
import org.springframework.beans.BeanUtils;

public class CategoryMapper {

    public static Category mapToCategory(CategoryDto categoryDto) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryDto, category);
        return category;
    }

    public static CategoryDto mapToCategoryDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        BeanUtils.copyProperties(category, categoryDto);
        return categoryDto;
    }

    private CategoryMapper() {}

}
