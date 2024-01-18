package com.unibuc.javaproject.controller;

import com.unibuc.javaproject.dto.CategoryRequest;
import com.unibuc.javaproject.mapper.CategoryMapper;
import com.unibuc.javaproject.model.Category;
import com.unibuc.javaproject.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.*;

@RestController
@Validated
@RequestMapping("/categories")
public class CategoryController {
    private CategoryService categoryService;
    private CategoryMapper categoryMapper;
    public CategoryController(CategoryService categoryService, CategoryMapper categoryMapper){
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@Valid @RequestBody CategoryRequest categoryRequest){
        Category category = categoryMapper.map(categoryRequest);
        Category createdCategory = categoryService.createCategory(category);
        return ResponseEntity
                .created(URI.create("/categories/" + createdCategory.getId()))
                .body(createdCategory);
    }

    @GetMapping
    public List<Category> getAll(){ return categoryService.getAll();}

    @GetMapping("/id/{id}")
    public Category getCategory(@PathVariable Long id){ return categoryService.getById(id);}
}
