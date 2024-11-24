package com.example.blogging.controller;

import com.example.blogging.DTO.TagItemDTO;
import com.example.blogging.model.TagItem;
import com.example.blogging.service.TagItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/tag-items")
public class TagItemController {

    @Autowired
    private TagItemService tagItemService;

    @GetMapping
    public List<TagItem> getAllTagItems() {
        return tagItemService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TagItem> getTagItemById(@PathVariable Long id) {
        Optional<TagItem> tagItem = tagItemService.findById(id);
        return tagItem.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public TagItem createTagItem(@RequestBody TagItemDTO tagItemDTO) {
        TagItem tagItem = new TagItem();
        tagItem.setPost(tagItemDTO.getPost());
        tagItem.setTag(tagItemDTO.getTag());
        return tagItemService.save(tagItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TagItem> updateTagItem(@PathVariable Long id, @RequestBody TagItemDTO tagItemDTO) {
        Optional<TagItem> tagItem = tagItemService.findById(id);

        if (tagItem.isPresent()) {
            TagItem updatedTagItem = tagItem.get();
            updatedTagItem.setPost(tagItemDTO.getPost());
            updatedTagItem.setTag(tagItemDTO.getTag());
            return ResponseEntity.ok(tagItemService.save(updatedTagItem));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTagItem(@PathVariable Long id) {
        if (tagItemService.existsById(id)) {
            tagItemService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}