package com.jeongyuneo.springwebsocket.service;

import com.jeongyuneo.springwebsocket.entity.Member;
import com.jeongyuneo.springwebsocket.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Member findById(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));
    }

    @Transactional(readOnly = true)
    public Member findByName(String name) {
        return memberRepository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));
    }
}