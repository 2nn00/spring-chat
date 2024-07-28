package com.jeongyuneo.springwebsocket.controller;

import com.jeongyuneo.springwebsocket.dto.ChattingRequest;
import com.jeongyuneo.springwebsocket.service.ChattingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class MessageController {

    private final ChattingService chattingService;

    @PostMapping("/messages")
    public void sendMessage(@RequestBody ChattingRequest chattingRequest) {
        chattingService.save(chattingRequest.getChattingRoomId(), chattingRequest);
        log.info("Message [{}] sent by member: {} to chatting room: {}", chattingRequest.getContent(),
                chattingRequest.getSenderId(), chattingRequest.getChattingRoomId());
    }
}