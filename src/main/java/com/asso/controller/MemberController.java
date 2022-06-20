package com.asso.controller;

import com.asso.model.Member;
import com.asso.service.MemberService;

import java.util.List;

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
    @GetMapping("/add")
    public ResponseEntity<?> getMember(@RequestBody Member member) {
    	
        Member member1 = memberService.add(member);
        if (member1 != null) {
            return new ResponseEntity<>(member1, HttpStatus.OK);
        } else
        return new ResponseEntity<>(member1, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/select/{id}")
    public ResponseEntity<Member> getMember(@PathVariable Integer id) {
        Member member = memberService.getMember(id);
        if (member != null ) {
            return new ResponseEntity<>(member, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/List")
    public ResponseEntity<List<Member>> getAllMember(@RequestBody Member member)
    {
		List<Member> member2 = memberService.getAllMember();
		if (member != null) {
			 return new ResponseEntity<>(member2,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
    }

   
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Member> deleteById(@PathVariable Integer id)
    {
			memberService.deleteMember(id);
			return new ResponseEntity<Member>(HttpStatus.OK);
		
    }
    
    
    @PutMapping("/update")
	public ResponseEntity<?> updateMember(@RequestBody Member member)
	{
		Member member2 = memberService.update(member);
		if (member2 != null) {
			return new ResponseEntity<>(member,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

    @GetMapping("/test")
    public String test(){
        return "test ok";
    }
}
