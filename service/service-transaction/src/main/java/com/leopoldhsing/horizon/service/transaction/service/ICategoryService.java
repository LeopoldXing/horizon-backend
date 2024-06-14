package com.leopoldhsing.horizon.service.transaction.service;

import com.leopoldhsing.horizon.model.dto.CategoryDto;

public interface ICategoryService {

    CategoryDto saveOrCreateCategory(String category);
}
