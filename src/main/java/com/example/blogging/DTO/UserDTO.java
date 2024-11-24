package com.example.blogging.DTO;


import com.example.blogging.model.Rol;

public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private String profilePicture;
    private String bio;
    private String password;
    private Rol rol;

    public UserDTO() {
        super();
    }

    public UserDTO(Long id, String username, String email, String profilePicture, String bio, String password, Rol rol) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.profilePicture = profilePicture;
        this.bio = bio;
        this.password = password;
        this.rol = rol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getPassword() {
        return password;
    }

    public Rol getRol() {
        return rol;
    }
}

