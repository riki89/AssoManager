package com.asso.controller;

import com.asso.model.Member;
import com.asso.service.MemberService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/members")
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

    @GetMapping()
    public ResponseEntity<List<Member>> getAll()
    {
      List<Member> member = memberService.getAll();
      if (member != null) { return new ResponseEntity<>(member,HttpStatus.OK); }
      else { return new ResponseEntity<>(HttpStatus.NOT_FOUND); }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Member> getMember(@PathVariable Integer id) {
        Member member = memberService.getMember(id);
        if (member != null ) { return new ResponseEntity<>(member, HttpStatus.OK); }
        else { return new ResponseEntity<>(HttpStatus.NOT_FOUND); }
    }

    @GetMapping("/byNumber/{phoneNumber}")
    public ResponseEntity<?> getByPhone(@PathVariable String phoneNumber) {
        Member member = memberService.getByPhoneNumber(phoneNumber);
        if (member != null) { return new ResponseEntity<>(member, HttpStatus.OK); }
        else { return new ResponseEntity<>(HttpStatus.NOT_FOUND); }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Member> deleteById(@PathVariable Integer id)
    {
        memberService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping()
    public ResponseEntity<Member> fullUpdate(@Valid @RequestBody Member member) {
        Member newMember = memberService.update(member);
        if (newMember != null){
            return new ResponseEntity<>(newMember, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
     }
    
    @GetMapping("/total/{id}")
    public ResponseEntity<?> getTotal(@PathVariable Integer id)
    {
    	Member member = memberService.getMember(id);
    	if (member != null) {		
        return new ResponseEntity<>(member.cotisationTotale(),HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }

    @PatchMapping("/{phoneNumber}/{newPhoneNumber}")
    public ResponseEntity<Member> partialUpdate(@PathVariable String phoneNumber, @PathVariable String newPhoneNumber)
    {
        Member member = memberService.getByPhoneNumber(phoneNumber);
        if (member != null) {
            member.setPhoneNumber(newPhoneNumber);
            Member newMember = memberService.update(member);
            return new ResponseEntity<>(newMember, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
     //get member by function
    @GetMapping("/getByFunction/{function}")
    public ResponseEntity<?> getByFunction(@PathVariable String function) {
        List<Member> memberList = memberService.getByFunction(function);
        if (memberList != null) {
            return new ResponseEntity<>(memberList, HttpStatus.OK);
        }else
        return new ResponseEntity<List<Member>>(HttpStatus.NOT_FOUND);
    }
    
    //get member by type (bureau, simple)
    @GetMapping("/getByType/{type}")
    public ResponseEntity<?> getByType(@PathVariable String type) {
    	List<Member> memberList = memberService.getByType(type);
    	if(memberList != null)
    	{
    		return new ResponseEntity<>(memberList, HttpStatus.OK);
    	}else
    	return new ResponseEntity<List<Member>>(HttpStatus.NOT_FOUND);
    	
    }

    //get members by sex
    @GetMapping("/getBySex/{sex}")
    public ResponseEntity<?> getBySex(@PathVariable String sex) {
    	List<Member> memberList = memberService.getBySex(sex);
    	if(memberList != null)
    	{
    		return new ResponseEntity<>(memberList, HttpStatus.OK);
    	}else
    	return new ResponseEntity<List<Member>>(HttpStatus.NOT_FOUND);
    }
}
