package com.jeongyuneo.springwebsocket.repository;

import com.jeongyuneo.springwebsocket.model.ChatMessage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatMessageRepository extends MongoRepository<ChatMessage, String> {
}