package com.jeongyuneo.springwebsocket.controller;

import com.jeongyuneo.springwebsocket.entity.Member;
import com.jeongyuneo.springwebsocket.service.ChattingService;
import com.jeongyuneo.springwebsocket.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class HomeController {

    private final ChattingService chattingService;
    private final MemberService memberService;

    @GetMapping("/")
    public String homePage(Model model) {
        // "이다라"라는 사용자를 기본으로 설정
        Member defaultMember = memberService.findByName("이다라");
        model.addAttribute("members", chattingService.getAllMembers());
        model.addAttribute("chatMessages", chattingService.getChatMessages(1L)); // 예시로 채팅방 ID 1의 메시지 가져오기
        model.addAttribute("defaultMember", defaultMember); // 기본 사용자 추가
        return "home"; // home.html 파일을 사용하도록 설정
    }
}