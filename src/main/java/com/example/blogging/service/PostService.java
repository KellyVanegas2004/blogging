package com.example.blogging.service;

import com.example.blogging.model.Post;
import com.example.blogging.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    public Post save(Post post) {
        return postRepository.save(post);
    }

    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return postRepository.existsById(id);
    }

    public List<Post> findByPublished(Boolean published) {
        return postRepository.findByPublished(published);
    }

    public List<Post> findByUserId(Long userId) {
        return postRepository.findByUser_Id(userId);
    }

    public List<Post> searchByTitleOrContent(String keyword) {
        return postRepository.findByTitleContainingOrContentContaining(keyword, keyword);
    }
}