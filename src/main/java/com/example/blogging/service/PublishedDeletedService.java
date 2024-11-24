package com.example.blogging.service;

import com.example.blogging.model.PublishedDeleted;
import com.example.blogging.repository.PublishedDeletedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublishedDeletedService {

    @Autowired
    private PublishedDeletedRepository publishedDeletedRepository;

    public List<PublishedDeleted> findAll() {
        return publishedDeletedRepository.findAll();
    }

    public Optional<PublishedDeleted> findById(Long id) {
        return publishedDeletedRepository.findById(id);
    }

    public PublishedDeleted save(PublishedDeleted publishedDeleted) {
        return publishedDeletedRepository.save(publishedDeleted);
    }

    public void deleteById(Long id) {
        publishedDeletedRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return publishedDeletedRepository.existsById(id);
    }
}