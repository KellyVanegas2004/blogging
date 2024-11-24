package com.example.blogging.service;


import com.example.blogging.model.Comments;
import com.example.blogging.repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentsService {

    @Autowired
    private CommentsRepository commentsRepository;

    public List<Comments> findAll() {
        return commentsRepository.findAll();
    }

    public Optional<Comments> findById(Long id) {
        return commentsRepository.findById(id);
    }

    public Comments save(Comments comment) {
        return commentsRepository.save(comment);
    }

    public void deleteById(Long id) {
        commentsRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return commentsRepository.existsById(id);
    }

    public List<Comments> findByPostId(Long postId) {
        return commentsRepository.findByPost_Id(postId);
    }

    public List<Comments> findByApproved(Boolean approved) {
        return commentsRepository.findByApproved(approved);
    }
}

