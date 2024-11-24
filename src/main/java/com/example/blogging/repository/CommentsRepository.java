package com.example.blogging.repository;

import com.example.blogging.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Long> {
    List<Comments> findByPost_Id(Long postId);
    List<Comments> findByApproved(Boolean approved);
}
