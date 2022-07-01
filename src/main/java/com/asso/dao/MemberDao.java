package com.asso.dao;

import com.asso.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDao extends JpaRepository<Member, Integer> {
    Member findByPhoneNumber(String phoneNumber);
}
