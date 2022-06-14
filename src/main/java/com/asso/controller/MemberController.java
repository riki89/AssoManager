package com.asso.controller;

import com.asso.model.Member;
import com.asso.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping()
    public ResponseEntity<?> getMember(@RequestBody Member member) {
    	
        Member member1 = memberService.add(member);
       // System.out.println(member.getName());
        if (member1 != null) {
        	
            return new ResponseEntity<>(member1, HttpStatus.OK);
        } else
        return new ResponseEntity<>(member1, HttpStatus.BAD_REQUEST);
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

    @GetMapping("/test")
    public String test(){
        return "test ok";
    }
}
