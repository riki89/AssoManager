package com.asso.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asso.model.Cotisation;

@Repository
public interface CotisationDao extends JpaRepository<Cotisation, Integer> 
{
	
}
