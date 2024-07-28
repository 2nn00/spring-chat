
package com.jeongyuneo.springwebsocket.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "chatMessages")
public class ChatMessage {
    @Id
    private String id;
    private String sender;
    private String content;
    private String timestamp;
}
