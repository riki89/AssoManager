package com.asso.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asso.model.RegleGroupe;

@Repository
public interface RegleDao extends JpaRepository<RegleGroupe, Integer>{

}
