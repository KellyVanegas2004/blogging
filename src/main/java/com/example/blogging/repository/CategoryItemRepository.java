package com.example.blogging.repository;

import com.example.blogging.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryItemRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
}
