package com.asso.dao;

import com.asso.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberDao extends JpaRepository<Member, Integer> {
    Member findByPhoneNumber(String phoneNumber);

    List<Member> findByFunction(String function);
}
