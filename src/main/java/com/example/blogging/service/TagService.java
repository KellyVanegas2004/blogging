package com.example.blogging.service;

import com.example.blogging.model.Tag;
import com.example.blogging.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    public Optional<Tag> findById(Long id) {
        return tagRepository.findById(id);
    }

    public Tag save(Tag tag) {
        return tagRepository.save(tag);
    }

    public void deleteById(Long id) {
        tagRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return tagRepository.existsById(id);
    }

    public Tag findByName(String name) {
        return tagRepository.findByName(name);
    }
}