package com.asso.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.asso.dao.CotisationDao;
import com.asso.dao.MemberDao;
import com.asso.model.Cotisation;
import com.asso.model.Member;
import java.time.LocalDate;
import java.util.Collections;

@Service
public class CotisationService {
    @Autowired
    CotisationDao cotisationDao;
    @Autowired
    MemberDao memberDao;

    public Cotisation add(Cotisation cotisation) {
        return cotisationDao.save(cotisation);
    }

    public List<Cotisation> getAll() {
        return cotisationDao.findAll();
    }

    public Cotisation getById(Integer id) {
        return cotisationDao.findById(id).get();
    }

    public List<Cotisation> getByMember(String phoneNumber) 
    {
        Member member = memberDao.findByPhoneNumber(phoneNumber);
        if (member != null) {
            return cotisationDao.findByMember(member);
        } else
        {
            return Collections.emptyList();
        }
    }
    
    public void delete(Integer id)
	{
		cotisationDao.deleteById(id);
	}

    public List<Cotisation> getByDateBetween(LocalDate startDate, LocalDate endDate) 
    {
        return cotisationDao.findByDateBetween(startDate, endDate);
    }

    public Cotisation update(Cotisation cotisation) 
    {
        return cotisationDao.save(cotisation);
    }

    public List<Cotisation> getByDate(LocalDate date) 
    { 
    	return cotisationDao.findByDate(date); 
    }
    
    public List<Cotisation> getByMeanOfPayment(String meanOfPayment)
    { 
    	return cotisationDao.findByMeanOfPayment(meanOfPayment);
    }
    
    public List<Cotisation> getBymonth(int month) 
    { 
    	return cotisationDao.findBymonth(month); 
    }
    
    
    public List<Cotisation> getByamount(double amount) 
    { 
    	return cotisationDao.findByamount(amount); 
    }
}
