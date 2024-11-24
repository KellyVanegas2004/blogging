package com.example.blogging.repository;

import com.example.blogging.model.TagItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagItemRepository extends JpaRepository<TagItem, Long> {
}
