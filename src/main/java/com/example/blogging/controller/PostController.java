package com.example.blogging.controller;


import com.example.blogging.DTO.PostDTO;
import com.example.blogging.model.Post;
import com.example.blogging.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public List<Post> getAllPosts() {
        return postService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        Optional<Post> post = postService.findById(id);
        return post.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Post createPost(@RequestBody PostDTO postDTO) {
        Post post = new Post();
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setPublished(postDTO.getPublished());
        post.setDeleted(postDTO.getDeleted());
        post.setCreatedAt(postDTO.getCreatedAt());
        post.setUpdatedAt(postDTO.getUpdatedAt());
        post.setUser(postDTO.getUser());
        return postService.save(post);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody PostDTO postDTO) {
        Optional<Post> post = postService.findById(id);

        if (post.isPresent()) {
            Post updatedPost = post.get();
            updatedPost.setTitle(postDTO.getTitle());
            updatedPost.setContent(postDTO.getContent());
            updatedPost.setPublished(postDTO.getPublished());
            updatedPost.setDeleted(postDTO.getDeleted());
            updatedPost.setCreatedAt(postDTO.getCreatedAt());
            updatedPost.setUpdatedAt(postDTO.getUpdatedAt());
            updatedPost.setUser(postDTO.getUser());
            return ResponseEntity.ok(postService.save(updatedPost));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        if (postService.existsById(id)) {
            postService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}