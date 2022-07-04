package com.asso.controller;

import java.util.List;

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

import com.asso.model.CompteRendu;
import com.asso.model.Member;
import com.asso.service.CompteRenduService;

@RestController
@RequestMapping("/compteRendu")
public class CompteRenduController {
	@Autowired
	private CompteRenduService compteRenduService;
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody CompteRendu compteRendu) {
		CompteRendu compteRendu1 = compteRenduService.add(compteRendu);
		if(compteRendu1 != null) {
			return new ResponseEntity<>(compteRendu1, HttpStatus.OK);
		} else 
			return new ResponseEntity<>(compteRendu1, HttpStatus.BAD_REQUEST);
		}
	 @GetMapping("/{id}")
	    public ResponseEntity<CompteRendu> getCompteRendu(@PathVariable Integer id) {
	        CompteRendu compteRendu = compteRenduService.getCompteRendu(id);
	        if (compteRendu != null ) {
	            return new ResponseEntity<>(compteRendu, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

		
	@GetMapping
		public ResponseEntity<?> getAll() {
		List<CompteRendu> compteRList = compteRenduService.getAll();
		return new ResponseEntity<>(compteRList, HttpStatus.OK);
		}
	 @PutMapping()
	    public ResponseEntity<CompteRendu> fullUpdate(@RequestBody CompteRendu compteRendu) {
	        CompteRendu newCompteRendu = compteRenduService.update(compteRendu);
	        if (newCompteRendu != null){
	            return new ResponseEntity<>(newCompteRendu, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }
	    }
	 @DeleteMapping("/{id}")
	 public ResponseEntity<?> deleteById(@PathVariable Integer id){
		 compteRenduService.delete(id);
		 return new ResponseEntity<>(HttpStatus.OK);
		 
	 }
	   
	}

	

		
		
	


