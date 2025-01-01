// src/main/java/com/forum/service/TopicService.java
package com.forum.service;

import com.forum.dto.TopicRequest;
import com.forum.model.Topic;
import com.forum.model.User;
import com.forum.repository.TopicRepository;
import com.forum.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class TopicService {
    private final TopicRepository topicRepository;
    private final UserRepository userRepository;

    public TopicService(TopicRepository topicRepository, UserRepository userRepository) {
        this.topicRepository = topicRepository;
        this.userRepository = userRepository;
    }

    public List<Topic> findAll() {
        return topicRepository.findAll();
    }

    public Topic create(TopicRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        Topic topic = new Topic();
        topic.setTitle(request.getTitle());
        topic.setMessage(request.getMessage());
        topic.setUser(user);

        return topicRepository.save(topic);
    }

    public void delete(Long id) {
        Topic topic = topicRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Topic not found"));

        topicRepository.delete(topic);
    }
}
