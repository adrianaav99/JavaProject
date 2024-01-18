package com.unibuc.javaproject.unit.service;

import com.unibuc.javaproject.exception.EntityNotFoundException;
import com.unibuc.javaproject.model.Category;
import com.unibuc.javaproject.repository.CategoryRepository;
import com.unibuc.javaproject.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {
    @InjectMocks
    CategoryService categoryService;
    @Mock
    CategoryRepository categoryRepository;

    @Test
    void whenCategoryExists_getById_returnsTheCategory(){
        Category category = new Category();
        category.setId(1);
        when(categoryRepository.findById(1L)).thenReturn(Optional.of(category));
        Category result = categoryService.getById(1L);
        assertNotNull(result);
        assertEquals(category.getId(), result.getId());
    }

    @Test
    void whenCategoryDoesntExist_getById_throwsEntityNotFoundException(){
        when(categoryRepository.findById(1L)).thenReturn(Optional.empty());
        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, ()->
                categoryService.getById(1L));

        assertEquals("Category with id 1 doesn't exist.", exception.getMessage());
    }
}
