package com.asso.service;

import com.asso.dao.MemberDao;
import com.asso.model.Member;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class MemberService {
    @Autowired
    MemberDao memberDao;

    public Member add(Member member) {
        return memberDao.save(member);
    }

    public List<Member> getAll() {
        return memberDao.findAll();
    }
    public Member getMember(Integer id) {
        Optional memberOpt = memberDao.findById(id);
        if (memberOpt.isPresent()) {
            return (Member) memberOpt.get();
        } else { return null; }
    }

    public Member update(Member member) { return memberDao.save(member); }

    public Member getByPhoneNumber(String phoneNumber) { return memberDao.findByPhoneNumber(phoneNumber); }
    
    public void  delete(Integer id) { memberDao.deleteById(id); }

    public List<Member> getByFunction(String function) {
        return memberDao.findByFunction(function);
    }
    
    public List<Member> getByType(String function) {
        return memberDao.findByType(function);
    }
    
    public List<Member> getBySex(String sex) {
        return memberDao.findBySex(sex);
    }
}
