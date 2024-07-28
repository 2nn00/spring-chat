
package com.jeongyuneo.springwebsocket.service;

import com.jeongyuneo.springwebsocket.model.ChatMessage;
import com.jeongyuneo.springwebsocket.repository.ChatMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ChatService {
    private final ChatMessageRepository chatMessageRepository;

    public void saveMessage(ChatMessage chatMessage) {
        chatMessageRepository.save(chatMessage);
    }
}