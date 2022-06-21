package com.asso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asso.dao.CotisationDao;
import com.asso.model.Cotisation;

@Service
public class CotisationService {
	@Autowired
	CotisationDao cotisationDao;
	
	public Cotisation add(Cotisation cotisation)
	{
		return cotisationDao.save(cotisation);
	}
	
	public Cotisation getCotisation(Integer id)
	{
		return cotisationDao.findById(id).get();
	}
	
	public List<Cotisation> getAllCotisation()
	{
		return cotisationDao.findAll();
	}
	
	public void deleteCotisation(Integer id)
	{
		cotisationDao.deleteById(id);
	}
	
	public Cotisation update(Cotisation cotisation)
	{
		return cotisationDao.save(cotisation);
	}
}
