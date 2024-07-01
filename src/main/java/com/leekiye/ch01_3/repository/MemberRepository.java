package com.leekiye.ch01_3.repository;

import com.leekiye.ch01_3.dto.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemberRepository {
    private static final Map<Integer, Member> memberMap =
            new HashMap<>();
    private static int seq =  0;

    public Member save(Member member) {
        member.setIdx(++seq);
        memberMap.put(member.getIdx(), member);
        System.out.println("saveMember = " + member);
        return member;
    }

    public List<Member> findAll() {
        return new ArrayList<>(memberMap.values());
    }

    public Optional<Member> findById(int idx) {
        Optional<Member> findedMember = Optional.ofNullable(memberMap.get(idx));
        return findedMember;
    }

}
