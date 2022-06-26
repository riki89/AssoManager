package com.asso.controller;

import com.asso.model.Member;
import com.asso.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping()
    public ResponseEntity<?> add(@RequestBody Member member) {
        Member member1 = memberService.add(member);
        if (member1 != null) {
            return new ResponseEntity<>(member1, HttpStatus.OK);
        } else
        return new ResponseEntity<>(member1, HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Member> memberList = memberService.getAll();
        return new ResponseEntity<>(memberList, HttpStatus.OK);
    }

    @GetMapping("/byNumber/{phoneNumber}")
    public ResponseEntity<?> getByPhone(@PathVariable String phoneNumber) {
        Member member = memberService.getByPhoneNumber(phoneNumber);
        if (member != null) {
            return new ResponseEntity<>(member, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> getMember(@PathVariable Integer id) {
        Member member = memberService.getMember(id);
        if (member != null ) {
            return new ResponseEntity<>(member, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/{phoneNumber}/{newPhoneNumber}")
    public ResponseEntity<Member> partialUpdate(@PathVariable String phoneNumber, @PathVariable String newPhoneNumber) {
        Member member = memberService.getByPhoneNumber(phoneNumber);
        if (member != null) {
            member.setPhoneNumber(newPhoneNumber);
            Member newMember = memberService.update(member);
            return new ResponseEntity<>(newMember, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping()
    public ResponseEntity<Member> fullUpdate(@RequestBody Member member) {
        Member newMember = memberService.update(member);
        if (newMember != null){
            return new ResponseEntity<>(newMember, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
