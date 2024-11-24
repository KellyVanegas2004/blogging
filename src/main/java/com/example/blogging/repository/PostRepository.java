package com.example.blogging.repository;

import com.example.blogging.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByPublished(Boolean published);
    List<Post> findByUser_Id(Long userId);
    List<Post> findByTitleContainingOrContentContaining(String title, String content);
}