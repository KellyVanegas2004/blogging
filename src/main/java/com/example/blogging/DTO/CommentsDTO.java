package com.example.blogging.DTO;

import com.example.blogging.model.Post;
import com.example.blogging.model.User;

import java.time.LocalDateTime;

public class CommentsDTO {
    private Long id;
    private String content;
    private Boolean approved;
    private LocalDateTime createdAt;
    private Long postId;
    private String username;
    private User user;
    private Post post;

    public CommentsDTO() {
        super();
    }

    public CommentsDTO(Long id, String content, Boolean approved, LocalDateTime createdAt, Long postId, String username, User user, Post post) {
        this.id = id;
        this.content = content;
        this.approved = approved;
        this.createdAt = createdAt;
        this.postId = postId;
        this.username = username;
        this.user = user;
        this.post = post;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Post getPost() {
        return post;
    }

    public User getUser() {
        return user;
    }
}

