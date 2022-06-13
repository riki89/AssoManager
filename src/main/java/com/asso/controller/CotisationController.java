package com.asso.controller;

import com.asso.mapper.CotisationData;
import com.asso.mapper.CotisationMapper;
import com.asso.model.Cotisation;
import com.asso.model.Member;
import com.asso.service.CotisationService;
import com.asso.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/cotisation")
public class CotisationController {
    @Autowired
    private CotisationService cotisationService;

    @Autowired
    private MemberService memberService;

    @PostMapping()
    public ResponseEntity<?> add(@RequestBody CotisationData cotisationData) {
        Member member = memberService.getMember(cotisationData.getMember());
        Cotisation cotisation = CotisationMapper.toCotisationMapper(cotisationData, member);
        Cotisation cotisation1 = cotisationService.add(cotisation);
        if (cotisation1 != null) {
            return new ResponseEntity<>(cotisation1, HttpStatus.OK);
        } else
        return new ResponseEntity<>(cotisation1, HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Cotisation> cotisationList = cotisationService.getAll();
        return new ResponseEntity<>(cotisationList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cotisation> getCotisationById(@PathVariable Integer id) {
        Cotisation cotisation = cotisationService.getById(id);
        if (cotisation != null ) {
            return new ResponseEntity<>(cotisation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/phoneNumber")
    public ResponseEntity<?> getByPhoneNumber(@RequestParam String phoneNumber) {
        List<Cotisation> cotisation = cotisationService.getByMember(phoneNumber);
        if (cotisation != null ) {
            return new ResponseEntity<>(cotisation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/betweendate/{startDate}/{endDate}")
    public ResponseEntity<?> getByPhoneNumber(@PathVariable LocalDate startDate,
                                              @PathVariable LocalDate endDate) {
        List<Cotisation> cotisation = cotisationService.getByDateBetween(startDate, endDate);
        if (cotisation != null ) {
            return new ResponseEntity<>(cotisation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping()
    public ResponseEntity<?> partialUpdate(@RequestBody CotisationData cotisationData) {
        Member member = memberService.getMember(cotisationData.getMember());
        if (member != null){
            Cotisation cotisation = CotisationMapper.toCotisationMapper(cotisationData, member);
            Cotisation c = cotisationService.update(cotisation);
            if (c != null) {
                return new ResponseEntity<>(c, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
