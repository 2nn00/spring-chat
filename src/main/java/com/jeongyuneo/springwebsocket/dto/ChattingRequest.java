package com.jeongyuneo.springwebsocket.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChattingRequest {
    private Long senderId;
    private String content;
    private Long chattingRoomId; // 이 부분을 추가합니다.
}