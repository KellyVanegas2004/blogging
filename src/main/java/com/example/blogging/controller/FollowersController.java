package com.example.blogging.controller;

import com.example.blogging.DTO.FollowersDTO;
import com.example.blogging.model.Followers;
import com.example.blogging.service.FollowersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/followers")
public class FollowersController {

    @Autowired
    private FollowersService followersService;

    @GetMapping
    public List<Followers> getAllFollowers() {
        return followersService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Followers> getFollowerById(@PathVariable Long id) {
        Optional<Followers> follower = followersService.findById(id);
        return follower.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Followers createFollower(@RequestBody FollowersDTO followersDTO) {
        Followers follower = new Followers();
        follower.setFollower(followersDTO.getFollowerUser());
        follower.setFollowed(followersDTO.getFollowedUser());
        return followersService.save(follower);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Followers> updateFollower(@PathVariable Long id, @RequestBody FollowersDTO followersDTO) {
        Optional<Followers> follower = followersService.findById(id);

        if (follower.isPresent()) {
            Followers updatedFollower = follower.get();
            updatedFollower.setFollower(followersDTO.getFollowerUser());
            updatedFollower.setFollowed(followersDTO.getFollowedUser());
            return ResponseEntity.ok(followersService.save(updatedFollower));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFollower(@PathVariable Long id) {
        if (followersService.existsById(id)) {
            followersService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}