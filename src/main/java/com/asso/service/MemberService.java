package com.asso.service;

import com.asso.dao.MemberDao;
import com.asso.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    MemberDao memberDao;
// Mahmood Diallo
    public Member add(Member member) {
        return memberDao.save(member);
    }

    public Member getMember(Integer id) {
        return memberDao.findById(id).get();
    }
}
