package com.asso.dao;

import com.asso.model.Cotisation;
import com.asso.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CotisationDao extends JpaRepository<Cotisation, Integer> {
    List<Cotisation> findByMember(Member member);

    List<Cotisation> findByDateBetween(LocalDate  startDate, LocalDate endDate);

}
