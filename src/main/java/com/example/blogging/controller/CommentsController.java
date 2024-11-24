package com.example.blogging.controller;


import com.example.blogging.DTO.CommentsDTO;
import com.example.blogging.model.Comments;
import com.example.blogging.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comments")
public class CommentsController {

    @Autowired
    private CommentsService commentsService;

    @GetMapping
    public List<Comments> getAllComments() {
        return commentsService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comments> getCommentById(@PathVariable Long id) {
        Optional<Comments> comment = commentsService.findById(id);
        return comment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Comments createComment(@RequestBody CommentsDTO commentsDTO) {
        Comments comment = new Comments();
        comment.setContent(commentsDTO.getContent());
        comment.setApproved(commentsDTO.getApproved());
        comment.setCreatedAt(commentsDTO.getCreatedAt());
        comment.setPost(commentsDTO.getPost());
        comment.setUser(commentsDTO.getUser());
        return commentsService.save(comment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comments> updateComment(@PathVariable Long id, @RequestBody CommentsDTO commentsDTO) {
        Optional<Comments> comment = commentsService.findById(id);

        if (comment.isPresent()) {
            Comments updatedComment = comment.get();
            updatedComment.setContent(commentsDTO.getContent());
            updatedComment.setApproved(commentsDTO.getApproved());
            updatedComment.setCreatedAt(commentsDTO.getCreatedAt());
            updatedComment.setPost(commentsDTO.getPost());
            updatedComment.setUser(commentsDTO.getUser());
            return ResponseEntity.ok(commentsService.save(updatedComment));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        if (commentsService.existsById(id)) {
            commentsService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}