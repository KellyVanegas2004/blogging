package com.example.blogging.service;

import com.example.blogging.model.TagItem;
import com.example.blogging.repository.TagItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagItemService {

    @Autowired
    private TagItemRepository tagItemRepository;

    public List<TagItem> findAll() {
        return tagItemRepository.findAll();
    }

    public Optional<TagItem> findById(Long id) {
        return tagItemRepository.findById(id);
    }

    public TagItem save(TagItem tagItem) {
        return tagItemRepository.save(tagItem);
    }

    public void deleteById(Long id) {
        tagItemRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return tagItemRepository.existsById(id);
    }
}

