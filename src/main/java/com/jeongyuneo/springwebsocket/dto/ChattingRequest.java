
package com.jeongyuneo.springwebsocket.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChattingRequest {
    private Long senderId;
    private String content;
}
