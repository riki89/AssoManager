package com.asso.dao;

import com.asso.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityDao extends JpaRepository<Activity, Integer> {
}
