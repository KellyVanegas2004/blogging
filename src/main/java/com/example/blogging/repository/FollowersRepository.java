package com.example.blogging.repository;

import com.example.blogging.model.Followers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowersRepository extends JpaRepository<Followers, Long> {
    List<Followers> findByFollower_Id(Long followerId);
    List<Followers> findByFollowed_Id(Long followedId);
}