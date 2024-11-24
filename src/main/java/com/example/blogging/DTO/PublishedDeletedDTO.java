package com.example.blogging.DTO;


import com.example.blogging.model.Post;

public class PublishedDeletedDTO {
    private Long id;
    private Boolean published;
    private Boolean deleted;
    private Long postId; //
    private Post post;

    public PublishedDeletedDTO() {
        super();
    }

    public PublishedDeletedDTO(Long id, Boolean published, Boolean deleted, Long postId, Post post) {
        this.id = id;
        this.published = published;
        this.deleted = deleted;
        this.postId = postId;
        this.post = post;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Post getPost() {
        return post;
    }
}

