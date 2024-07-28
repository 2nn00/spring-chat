
package com.jeongyuneo.springwebsocket.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChattingRoomResponse {
    private Long chattingRoomId;
    private String name;
}
