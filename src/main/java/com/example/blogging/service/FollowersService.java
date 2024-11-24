package com.example.blogging.service;

import com.example.blogging.model.Followers;
import com.example.blogging.repository.FollowersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FollowersService {

    @Autowired
    private FollowersRepository followersRepository;

    public List<Followers> findAll() {
        return followersRepository.findAll();
    }

    public Optional<Followers> findById(Long id) {
        return followersRepository.findById(id);
    }

    public Followers save(Followers follower) {
        return followersRepository.save(follower);
    }

    public void deleteById(Long id) {
        followersRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return followersRepository.existsById(id);
    }

    public List<Followers> findByFollowerId(Long followerId) {
        return followersRepository.findByFollower_Id(followerId);
    }

    public List<Followers> findByFollowedId(Long followedId) {
        return followersRepository.findByFollowed_Id(followedId);
    }
}