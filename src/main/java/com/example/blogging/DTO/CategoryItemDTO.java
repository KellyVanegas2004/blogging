package com.example.blogging.DTO;

import com.example.blogging.model.Category;
import com.example.blogging.model.Post;

public class CategoryItemDTO {
    private Long id;
    private Long postId;
    private String postTitle;
    private Long categoryId;
    private String categoryName; // Nombre de la categoría asociada
    private Category category;
    private Post post;

    public CategoryItemDTO() {
        super();
    }

    public CategoryItemDTO(Long id, Long postId, String postTitle, Long categoryId, String categoryName, Category category, Post post) {
        this.id = id;
        this.postId = postId;
        this.postTitle = postTitle;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.category = category;
        this.post = post;
    }

    // Métodos getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Post getPost() {
        return post;
    }

    public Category getCategory() {
        return category;
    }
}
