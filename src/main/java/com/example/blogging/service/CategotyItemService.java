package com.example.blogging.service;

import com.example.blogging.model.CategoryItem;
import com.example.blogging.repository.CategoryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryItemService {

    @Autowired
    private CategoryItemRepository categoryItemRepository;

    public List<CategoryItem> findAll() {
        return categoryItemRepository.findAll();
    }

    public Optional<CategoryItem> findById(Long id) {
        return categoryItemRepository.findById(id);
    }

    public CategoryItem save(CategoryItem categoryItem) {
        return categoryItemRepository.save(categoryItem);
    }

    public void deleteById(Long id) {
        categoryItemRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return categoryItemRepository.existsById(id);
    }
}
