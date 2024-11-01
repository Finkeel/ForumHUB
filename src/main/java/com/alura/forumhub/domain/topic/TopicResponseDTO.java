package com.alura.forumhub.domain.topic;

import com.alura.forumhub.domain.course.CourseResponseDTO;

import java.time.LocalDateTime;
public record TopicResponseDTO(Long topicId, String title, String message, LocalDateTime createdAt, CourseResponseDTO course, String authorName) {
    public TopicResponseDTO(Topic topic) {
        this(topic.getTopicId(), topic.getTitle(), topic.getMessage(), topic.getCreatedAt(), new CourseResponseDTO(topic.getCourse()), topic.getAuthor().getUsername());
    }
}
