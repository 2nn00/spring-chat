package com.jeongyuneo.springwebsocket.repository;

import com.jeongyuneo.springwebsocket.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByName(String name);
}