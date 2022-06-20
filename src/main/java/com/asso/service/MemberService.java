package com.asso.service;

import com.asso.dao.MemberDao;
import com.asso.model.Member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    MemberDao memberDao;

    public Member add(Member member) {
        return memberDao.save(member);
    }

    public Member getMember(Integer id) {
        return memberDao.findById(id).get();
    }
    
    public List<Member> getAllMember()
	{
		return memberDao.findAll();
	}
    public Member update(Member member) {
        return memberDao.save(member);
    }
    public void  deleteMember(Integer id) {
         memberDao.deleteById(id);;
    }
}
