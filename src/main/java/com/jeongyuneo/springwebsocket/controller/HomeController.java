package com.jeongyuneo.springwebsocket.controller;

import com.jeongyuneo.springwebsocket.service.ChattingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class HomeController {

    private final ChattingService chattingService;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("members", chattingService.getAllMembers());
        model.addAttribute("chatMessages", chattingService.getChatMessages(1L)); // 채팅방 ID 1의 메시지 가져오기 예시
        return "home"; // home.html 파일을 사용하도록 설정
    }
}