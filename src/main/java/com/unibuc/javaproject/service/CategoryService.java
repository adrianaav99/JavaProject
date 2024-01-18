package com.unibuc.javaproject.service;

import com.unibuc.javaproject.exception.EntityNotFoundException;
import com.unibuc.javaproject.model.Category;
import com.unibuc.javaproject.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public Category createCategory(Category category){ return categoryRepository.save(category);}

    public Category getById(Long id){
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if(categoryOptional.isEmpty()){
            throw new EntityNotFoundException("Category", id);
        }
        return categoryOptional.get();
    }

    public List<Category> getAll(){ return categoryRepository.findAll();}
}
