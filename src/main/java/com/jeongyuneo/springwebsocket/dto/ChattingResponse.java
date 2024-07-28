package com.jeongyuneo.springwebsocket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
public class ChattingResponse {
    private String senderName;
    private String content;
    private LocalDateTime createdDate;

    public String getFormattedDate() {
        return createdDate.format(DateTimeFormatter.ofPattern("yyyy. M. d."));
    }

    public String getFormattedTime() {
        String time = createdDate.format(DateTimeFormatter.ofPattern("a h:mm"));
        return time.replace("AM", "오전").replace("PM", "오후");
    }

    public String getCreatedTime() {
        return getFormattedTime();
    }
}