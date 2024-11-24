package com.example.blogging.DTO;


import com.example.blogging.model.Post;
import com.example.blogging.model.Tag;

public class TagItemDTO {
    private Long id;
    private Long postId;
    private String postTitle; // Título del post asociado, opcional para mayor información
    private Long tagId;
    private String tagName; // Nombre del tag asociado
    private  Post post;
    private Tag tag;


    public TagItemDTO() {
        super();
    }

    public TagItemDTO(Long id, Long postId, String postTitle, Long tagId, String tagName,Post post, Tag tag) {
        this.id = id;
        this.postId = postId;
        this.postTitle = postTitle;
        this.tagId = tagId;
        this.tagName = tagName;
        this.post = post;
        this.tag = tag;
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

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Post getPost() {
        return post;
    }

    public Tag getTag() {
        return tag;
    }
}
