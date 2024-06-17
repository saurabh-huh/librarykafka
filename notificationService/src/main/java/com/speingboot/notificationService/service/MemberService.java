package com.speingboot.notificationService.service;

import com.speingboot.notificationService.Repository.MemberRepository;
import com.speingboot.notificationService.dto.MemberDto;
import com.speingboot.notificationService.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public Member addMember(MemberDto memberDto){
        Member member = new Member();
        member.setFirstName(memberDto.getFirstName());
        member.setLastName(memberDto.getLastName());
        member.setEmail(memberDto.getEmail());
        memberRepository.save(member);
        return member;
    }
}
