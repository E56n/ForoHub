// src/main/java/com/forum/repository/TopicRepository.java
package com.forum.repository;

import com.forum.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {
}

// src/main/java/com/forum/repository/UserRepository.java
package com.forum.repository;

import com.forum.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
