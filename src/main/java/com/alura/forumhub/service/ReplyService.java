package com.alura.forumhub.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.alura.forumhub.domain.reply.Reply;
import com.alura.forumhub.repository.ReplyRepository;
import com.alura.forumhub.domain.reply.ReplyRequestDTO;
import com.alura.forumhub.domain.reply.ReplyResponseDTO;
import com.alura.forumhub.repository.TopicRepository;

@Service
public class ReplyService {

    private final ReplyRepository replyRepository;
    private final TopicRepository topicRepository;


    public ReplyService(ReplyRepository replyRepository, TopicRepository topicRepository) {
        this.replyRepository = replyRepository;
        this.topicRepository = topicRepository;
    }

    @Transactional
    public ReplyResponseDTO createReply(ReplyRequestDTO request){

        var topic = topicRepository.findById(request.topicId())
                .orElseThrow(() -> new EntityNotFoundException("Topic not found with id: " + request.topicId()));

        var newReply = new Reply(request.message(), topic);
        replyRepository.save(newReply);
        return new ReplyResponseDTO(newReply);
    }


    public Page<ReplyResponseDTO> listReplies(Pageable pageable) {
        return replyRepository.findAll(pageable).map(ReplyResponseDTO::new);
    }
}
