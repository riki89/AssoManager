package com.asso.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asso.model.CompteRendu;

public interface CompteRenduDao extends JpaRepository<CompteRendu, Integer> {
        CompteRendu findByordreJ(String phoneNumber);
}
