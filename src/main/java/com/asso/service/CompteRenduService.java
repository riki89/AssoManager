package com.asso.service;

import java.util.Optional;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asso.dao.CompteRenduDao;
import com.asso.model.CompteRendu;



@Service
public class CompteRenduService {
    @Autowired
    CompteRenduDao compteRenduDao;
 
    public CompteRendu add(CompteRendu compteRendu) {
		return compteRenduDao.save(compteRendu);
    	
    }
    public CompteRendu update(CompteRendu compteRendu) {
    	return compteRenduDao.save(compteRendu);
    }
    public CompteRendu getCompteRendu(Integer id) {
        Optional compteRenduOpt = compteRenduDao.findById(id);
        return (CompteRendu) compteRenduOpt.get();
    }
    public java.util.List<CompteRendu> getAll() {
    	return compteRenduDao.findAll();
    }
    public void delete(Integer id) {
    	compteRenduDao.deleteById(id);
    }
}
