package com.alura.forumhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.alura.forumhub.domain.topic.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long> {
}
