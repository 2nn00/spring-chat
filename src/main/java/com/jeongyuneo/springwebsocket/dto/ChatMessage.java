
package com.jeongyuneo.springwebsocket.dto;

import lombok.Data;

@Data
public class ChatMessage {
    private String sender;
    private String content;
    private String timestamp;
}
