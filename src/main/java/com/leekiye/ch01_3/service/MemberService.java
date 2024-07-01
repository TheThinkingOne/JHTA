package com.leekiye.ch01_3.service;

import com.leekiye.ch01_3.dto.Member;
import com.leekiye.ch01_3.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    // repository
    private final MemberRepository memberRepository;

    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

    public List<Member> findAllMember() {
        return memberRepository.findAll();
    }

    public Optional<Member> infoMember(int idx) {
        return  memberRepository.findById(idx);
    }
}
