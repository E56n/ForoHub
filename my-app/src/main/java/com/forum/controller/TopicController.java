// src/main/java/com/forum/controller/TopicController.java
package com.forum.controller;

import com.forum.dto.TopicRequest;
import com.forum.model.Topic;
import com.forum.service.TopicService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicController {
    private final TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping
    public ResponseEntity<List<Topic>> listTopics() {
        return ResponseEntity.ok(topicService.findAll());
    }

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Topic> createTopic(@RequestBody TopicRequest request) {
        Topic topic = topicService.create(request);
        return ResponseEntity.status(201).body(topic);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Void> deleteTopic(@PathVariable Long id) {
        topicService.delete(id);
        return ResponseEntity.ok().build();
    }
}
