package com.unibuc.javaproject.mapper;

import com.unibuc.javaproject.dto.CategoryRequest;
import com.unibuc.javaproject.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public Category map(CategoryRequest categoryRequest){
        Category category = new Category();
        category.setName(categoryRequest.getName());
        category.setDescription(categoryRequest.getDescription());
        category.setColor(categoryRequest.getColor());
        category.setEvents(categoryRequest.getEvents());
        return category;
    }
}
