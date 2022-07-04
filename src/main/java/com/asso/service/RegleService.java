package com.asso.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import com.asso.dao.RegleDao;
import com.asso.model.RegleGroupe;


@Service
public class RegleService {
	 @Autowired
	    RegleDao regleDao;

	    public RegleGroupe add(RegleGroupe regle) {
	        return regleDao.save(regle);
	    }

	    public RegleGroupe getRegle(Integer id) {
	        return regleDao.findById(id).get();
	    }
	    
	    public List<RegleGroupe> getAll()
		{
			return regleDao.findAll();
		}
	    public RegleGroupe update(RegleGroupe regle) {
	        return regleDao.save(regle);
	    }
	    public void  deleteRegle(Integer id) {
	    	regleDao.deleteById(id);;
	    }
}
