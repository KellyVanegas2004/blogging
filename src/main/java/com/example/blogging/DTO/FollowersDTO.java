package com.example.blogging.DTO;

import com.example.blogging.model.User;

public class FollowersDTO {
    private Long id;
    private Long followerId;
    private String followerUsername;
    private Long followedId;
    private String followedUsername;
    private User followedUser;
    private User followerUser;

    public FollowersDTO() {
        super();
    }

    public FollowersDTO(Long id, Long followerId, String followerUsername, Long followedId, String followedUsername, User followedUser, User followerUser) {
        this.id = id;
        this.followerId = followerId;
        this.followerUsername = followerUsername;
        this.followedId = followedId;
        this.followedUsername = followedUsername;
        this.followedUser = followedUser;
        this.followerUser = followerUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFollowerId() {
        return followerId;
    }

    public void setFollowerId(Long followerId) {
        this.followerId = followerId;
    }

    public String getFollowerUsername() {
        return followerUsername;
    }

    public void setFollowerUsername(String followerUsername) {
        this.followerUsername = followerUsername;
    }

    public Long getFollowedId() {
        return followedId;
    }

    public void setFollowedId(Long followedId) {
        this.followedId = followedId;
    }

    public String getFollowedUsername() {
        return followedUsername;
    }

    public void setFollowedUsername(String followedUsername) {
        this.followedUsername = followedUsername;
    }

    public User getFollowerUser() {
        return followerUser;
    }

    public User getFollowedUser() {
        return followedUser;
    }
}
