package com.example.blogging.controller;

import com.example.blogging.DTO.PublishedDeletedDTO;
import com.example.blogging.model.PublishedDeleted;
import com.example.blogging.service.PublishedDeletedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/published-deleted")
public class PublishedDeletedController {

    @Autowired
    private PublishedDeletedService publishedDeletedService;

    @GetMapping
    public List<PublishedDeleted> getAllPublishedDeleted() {
        return publishedDeletedService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublishedDeleted> getPublishedDeletedById(@PathVariable Long id) {
        Optional<PublishedDeleted> publishedDeleted = publishedDeletedService.findById(id);
        return publishedDeleted.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public PublishedDeleted createPublishedDeleted(@RequestBody PublishedDeletedDTO publishedDeletedDTO) {
        PublishedDeleted publishedDeleted = new PublishedDeleted();
        publishedDeleted.setPublished(publishedDeletedDTO.getPublished());
        publishedDeleted.setDeleted(publishedDeletedDTO.getDeleted());
        publishedDeleted.setPost(publishedDeletedDTO.getPost());
        return publishedDeletedService.save(publishedDeleted);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PublishedDeleted> updatePublishedDeleted(@PathVariable Long id, @RequestBody PublishedDeletedDTO publishedDeletedDTO) {
        Optional<PublishedDeleted> publishedDeleted = publishedDeletedService.findById(id);

        if (publishedDeleted.isPresent()) {
            PublishedDeleted updatedPublishedDeleted = publishedDeleted.get();
            updatedPublishedDeleted.setPublished(publishedDeletedDTO.getPublished());
            updatedPublishedDeleted.setDeleted(publishedDeletedDTO.getDeleted());
            updatedPublishedDeleted.setPost(publishedDeletedDTO.getPost());
            return ResponseEntity.ok(publishedDeletedService.save(updatedPublishedDeleted));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePublishedDeleted(@PathVariable Long id) {
        if (publishedDeletedService.existsById(id)) {
            publishedDeletedService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
