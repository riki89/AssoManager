package com.asso.dao;

import com.asso.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityDao extends JpaRepository<Activity, Integer> {
    List<Activity> findByType(String type);
}
