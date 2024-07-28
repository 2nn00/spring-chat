
package com.jeongyuneo.springwebsocket.controller;

import com.jeongyuneo.springwebsocket.dto.ChattingResponse;
import com.jeongyuneo.springwebsocket.dto.ChattingRoomResponse;
import com.jeongyuneo.springwebsocket.service.ChattingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ChattingRoomController {

    private final ChattingService chattingService;

    @GetMapping("/chatting-rooms")
    public ResponseEntity<List<ChattingRoomResponse>> getAll() {
        return ResponseEntity.ok().body(chattingService.getAllChattingRooms());
    }

    @GetMapping("/chatting-rooms/{chattingRoomId}/messages")
    public ResponseEntity<List<ChattingResponse>> getChatMessages(@PathVariable("chattingRoomId") Long chattingRoomId) {
        return ResponseEntity.ok().body(chattingService.getChatMessages(chattingRoomId));
    }

    @GetMapping("/chatting")
    public String chattingPage(Model model) {
        model.addAttribute("members", chattingService.getAllMembers());
        model.addAttribute("chatMessages", chattingService.getChatMessages(1L)); // 채팅방 ID 1의 메시지 가져오기 예시
        return "home"; // home.html 파일을 사용하도록 설정
    }
}
