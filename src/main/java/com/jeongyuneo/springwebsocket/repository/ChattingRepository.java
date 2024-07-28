
package com.jeongyuneo.springwebsocket.repository;

import com.jeongyuneo.springwebsocket.entity.Chatting;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ChattingRepository extends JpaRepository<Chatting, Long> {
    List<Chatting> findByChattingRoomId(Long chattingRoomId);
}