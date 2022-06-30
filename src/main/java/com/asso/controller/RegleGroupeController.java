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

import com.asso.model.Member;
import com.asso.model.RegleGroupe;
import com.asso.service.RegleService;



@RestController
@RequestMapping("/regle")
public class RegleGroupeController {
	@Autowired
    private RegleService regleService;

    @PostMapping()
    @GetMapping("/add")
    public ResponseEntity<?> getRegle(@RequestBody RegleGroupe regle) {
    	
    	RegleGroupe regle1 = regleService.add(regle);
        if (regle1 != null) {
            return new ResponseEntity<>(regle1, HttpStatus.OK);
        } else
        return new ResponseEntity<>(regle1, HttpStatus.BAD_REQUEST);
    }
    
    @GetMapping("/select/{id}")
    public ResponseEntity<RegleGroupe> getRegle(@PathVariable Integer id) {
    	RegleGroupe regle = regleService.getRegle(id);
        if (regle != null ) {
            return new ResponseEntity<>(regle, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/List")
    public ResponseEntity<List<RegleGroupe>> getAllRegle(@RequestBody RegleGroupe regle)
    {
		List<RegleGroupe> regle2 = regleService.getAllRegle();
		if (regle != null) {
			 return new ResponseEntity<>(regle2,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<RegleGroupe> deleteById(@PathVariable Integer id)
    {
    		regleService.deleteRegle(id);
			return new ResponseEntity<RegleGroupe>(HttpStatus.OK);
		
    }
    
    
    @PutMapping("/update")
	public ResponseEntity<?> updateRegle(@RequestBody RegleGroupe regle)
	{
    	RegleGroupe regle2 = regleService.update(regle);
		if (regle2 != null) {
			return new ResponseEntity<>(regle,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}