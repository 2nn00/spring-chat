package com.jeongyuneo.springwebsocket.controller;

import com.jeongyuneo.springwebsocket.dto.ChattingRequest;
import com.jeongyuneo.springwebsocket.service.ChattingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@RequiredArgsConstructor
@Controller
public class ChattingController {

    private final SimpMessagingTemplate simpMessagingTemplate;
    private final ChattingService chattingService;

    @MessageMapping("/chattings/{chattingRoomId}/messages")
    @PostMapping("/chattings/{chattingRoomId}/messages")
    public void chat(@PathVariable Long chattingRoomId, @RequestBody ChattingRequest chattingRequest) {
        simpMessagingTemplate.convertAndSend("/subscription/chattings/" + chattingRoomId, chattingRequest.getContent());
        chattingService.save(chattingRoomId, chattingRequest);
        log.info("Message [{}] send by member: {} to chatting room: {}", chattingRequest.getContent(),
                chattingRequest.getSenderId(), chattingRoomId);
    }

    @PostMapping("/private-chattings/{memberId}/messages")
    public void privateChat(@PathVariable Long memberId, @RequestBody ChattingRequest chattingRequest) {
        // 개별 채팅 로직 추가
        simpMessagingTemplate.convertAndSend("/subscription/private-chattings/" + memberId,
                chattingRequest.getContent());
        // chattingService.savePrivateMessage(memberId, chattingRequest); // 필요한 경우 저장
        // 로직 추가
        log.info("Private message [{}] sent by member: {} to member: {}", chattingRequest.getContent(),
                chattingRequest.getSenderId(), memberId);
    }
}