package com.speingboot.notificationService.controller;


import com.speingboot.notificationService.dto.MemberDto;
import com.speingboot.notificationService.model.Member;
import com.speingboot.notificationService.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping
    public ResponseEntity<Member> addMember(@RequestBody MemberDto memberDto){
        return new ResponseEntity<>(memberService.addMember(memberDto), HttpStatus.CREATED);
    }
}
