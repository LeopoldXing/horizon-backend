package com.leopoldhsing.horizon.service.transaction.api;

import com.leopoldhsing.horizon.model.dto.CategoryDto;
import com.leopoldhsing.horizon.service.transaction.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/inner/transaction/category")
public class CategoryFeignApi {

    @Autowired
    private ICategoryService categoryService;

    @PostMapping("/save/{category}")
    public CategoryDto save(@PathVariable String category) {
        return categoryService.saveOrCreateCategory(category);
    }
}
