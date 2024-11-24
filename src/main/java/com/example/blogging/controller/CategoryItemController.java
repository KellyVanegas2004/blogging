package com.example.blogging.controller;

import com.example.blogging.DTO.CategoryItemDTO;
import com.example.blogging.model.CategoryItem;
import com.example.blogging.service.CategoryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/category-items")
public class CategoryItemController {

    @Autowired
    private CategoryItemService categoryItemService;

    @GetMapping
    public List<CategoryItem> getAllCategoryItems() {
        return categoryItemService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryItem> getCategoryItemById(@PathVariable Long id) {
        Optional<CategoryItem> categoryItem = categoryItemService.findById(id);
        return categoryItem.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public CategoryItem createCategoryItem(@RequestBody CategoryItemDTO categoryItemDTO) {
        CategoryItem categoryItem = new CategoryItem();
        categoryItem.setPost(categoryItemDTO.getPost());
        categoryItem.setCategory(categoryItemDTO.getCategory());
        return categoryItemService.save(categoryItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryItem> updateCategoryItem(@PathVariable Long id, @RequestBody CategoryItemDTO categoryItemDTO) {
        Optional<CategoryItem> categoryItem = categoryItemService.findById(id);

        if (categoryItem.isPresent()) {
            CategoryItem updatedCategoryItem = categoryItem.get();
            updatedCategoryItem.setPost(categoryItemDTO.getPost());
            updatedCategoryItem.setCategory(categoryItemDTO.getCategory());
            return ResponseEntity.ok(categoryItemService.save(updatedCategoryItem));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoryItem(@PathVariable Long id) {
        if (categoryItemService.existsById(id)) {
            categoryItemService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}