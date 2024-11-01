package com.alura.forumhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.alura.forumhub.domain.reply.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
}
