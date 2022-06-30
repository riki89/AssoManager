package com.asso.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asso.model.Cotisation;
import com.asso.service.CotisationService;

@RestController
@RequestMapping("/cotisations")
public class CotisationController {
	@Autowired
	private CotisationService cotisationService;
	// La methode du controleur qui permet d'ajouter une cotisation
	@PostMapping()
	public ResponseEntity<?> add(@Valid @RequestBody Cotisation cotisation)
	{
		Cotisation cotisation1 = cotisationService.add(cotisation);
		if (cotisation1 != null) {
			return new ResponseEntity<>(cotisation,HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	// La methode du controleur qui permet de selectionner une cotisation à travers l'Id
	@GetMapping("/{id}")
    public ResponseEntity<Cotisation> getById(@PathVariable Integer id)
    {
		Cotisation cotisation = cotisationService.getById(id);
		if (cotisation != null) {
			 return new ResponseEntity<>(cotisation,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
    }
	// La methode du controleur qui permet de lister toutes les cotisations
	@GetMapping()
    public ResponseEntity<?> getAll()
    {
		List<Cotisation> cotisationList = cotisationService.getAll();
		return new ResponseEntity<>(cotisationList,HttpStatus.OK);
		
    }
	// La methode du controleur qui permet de supprimer une cotisation
	@DeleteMapping("/{id}")
    public ResponseEntity<Cotisation> deleteById(@PathVariable Integer id)
    {
			cotisationService.delete(id);
			return new ResponseEntity<Cotisation>(HttpStatus.OK);
		
    }
	// La methode du controleur qui permet de modifier une cotisation
	@PutMapping()
	public ResponseEntity<?> update(@RequestBody Cotisation cotisation)
	{
		Cotisation cotisation2 = cotisationService.update(cotisation);
		if (cotisation2 != null) {
			return new ResponseEntity<>(cotisation,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	 @GetMapping("/teste")
	    public String test(){
	        return "test ok";
	    }
}
