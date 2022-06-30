package com.asso.controller;

import com.asso.model.Member;
import com.asso.service.MemberService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping()
    public ResponseEntity<?> add(@RequestBody @Valid Member member) {
        Member member1 = memberService.add(member);
        if (member1 != null) {
            return new ResponseEntity<>(member1, HttpStatus.OK);
        } else
        return new ResponseEntity<>(member1, HttpStatus.BAD_REQUEST);
    }

    @GetMapping()
    public ResponseEntity<List<Member>> getAll()
    {
      List<Member> member = memberService.getAll();
      if (member != null) {
         return new ResponseEntity<>(member,HttpStatus.OK);
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

    @GetMapping("/byNumber/{phoneNumber}")
    public ResponseEntity<?> getByPhone(@PathVariable String phoneNumber) {
        Member member = memberService.getByPhoneNumber(phoneNumber);
        if (member != null) {
            return new ResponseEntity<>(member, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Member> deleteById(@PathVariable Integer id)
    {
        memberService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
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
