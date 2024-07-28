package com.jeongyuneo.springwebsocket.service;

import com.jeongyuneo.springwebsocket.dto.ChattingRequest;
import com.jeongyuneo.springwebsocket.dto.ChattingResponse;
import com.jeongyuneo.springwebsocket.dto.ChattingRoomResponse;
import com.jeongyuneo.springwebsocket.entity.Chatting;
import com.jeongyuneo.springwebsocket.entity.ChattingRoom;
import com.jeongyuneo.springwebsocket.entity.Member;
import com.jeongyuneo.springwebsocket.repository.ChattingRepository;
import com.jeongyuneo.springwebsocket.repository.ChattingRoomRepository;
import com.jeongyuneo.springwebsocket.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ChattingService {

        private final MemberRepository memberRepository;
        private final ChattingRepository chattingRepository;
        private final ChattingRoomRepository chattingRoomRepository;

        @Transactional
        public void save(Long chattingRoomId, ChattingRequest chattingRequest) {
                Member sender = memberRepository.findById(chattingRequest.getSenderId())
                                .orElseThrow(() -> new IllegalArgumentException("Member not found"));
                ChattingRoom chattingRoom = chattingRoomRepository.findById(chattingRoomId)
                                .orElseThrow(() -> new IllegalArgumentException("Chatting room not found"));
                Chatting chatting = Chatting.builder()
                                .member(sender)
                                .chattingRoom(chattingRoom)
                                .content(chattingRequest.getContent())
                                .build();
                chattingRoom.createChatting(chatting);
                chattingRoomRepository.save(chattingRoom);
        }

        @Transactional(readOnly = true)
        public List<ChattingRoomResponse> getAllChattingRooms() {
                return chattingRoomRepository.findAll()
                                .stream()
                                .map(room -> ChattingRoomResponse.builder()
                                                .chattingRoomId(room.getId())
                                                .name(room.getName())
                                                .build())
                                .collect(Collectors.toList());
        }

        @Transactional(readOnly = true)
        public List<ChattingResponse> getChatMessages(Long chattingRoomId) {
                return chattingRepository.findByChattingRoomId(chattingRoomId)
                                .stream()
                                .map(chat -> new ChattingResponse(chat.getMember().getName(), chat.getContent(),
                                                chat.getCreatedDate()))
                                .collect(Collectors.toList());
        }

        @Transactional(readOnly = true)
        public List<Member> getAllMembers() {
                return memberRepository.findAll();
        }
}