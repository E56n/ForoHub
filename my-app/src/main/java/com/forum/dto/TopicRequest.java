// src/main/java/com/forum/dto/TopicRequest.java
package com.forum.dto;

import lombok.Data;

@Data
public class TopicRequest {
    private String title;
    private String message;
    private Long userId;
}

// src/main/java/com/forum/dto/LoginRequest.java
package com.forum.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
