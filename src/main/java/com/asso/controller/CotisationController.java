package com.asso.controller;

import com.asso.mapper.CotisationData;
import com.asso.mapper.CotisationMapper;
import com.asso.model.Cotisation;
import com.asso.model.Member;
import com.asso.service.CotisationService;
import com.asso.service.MemberService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/cotisations")
public class CotisationController {
    @Autowired
    private CotisationService cotisationService;

    @Autowired
    private MemberService memberService;

    @PostMapping()
    public ResponseEntity<?> add(@Valid @RequestBody CotisationData cotisationData, BindingResult bindingResult) {
        System.out.println(bindingResult);
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
    public ResponseEntity<Cotisation> getById(@PathVariable Integer id) {
        Cotisation cotisation = cotisationService.getById(id);
        if (cotisation != null ) {
            return new ResponseEntity<>(cotisation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/phoneNumber/{phoneNumber}")
    public ResponseEntity<?> getByPhoneNumber(@PathVariable String phoneNumber) {
        List<Cotisation> cotisation = cotisationService.getByMember(phoneNumber);
        if (cotisation != null ) {
            return new ResponseEntity<>(cotisation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/betweendate/{startDate}/{endDate}")
    public ResponseEntity<?> getByDateBetween(@PathVariable LocalDate startDate,
                                              @PathVariable LocalDate endDate) {
        List<Cotisation> cotisation = cotisationService.getByDateBetween(startDate, endDate);
        if (cotisation != null ) {
            return new ResponseEntity<>(cotisation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping()
    public ResponseEntity<?> fullUpdate(@RequestBody CotisationData cotisationData) {
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

    @GetMapping("/total/{id}")
    public ResponseEntity<?> getTotal(@PathVariable Integer id)
    {
        Member member = memberService.getMember(id);
        if (member != null && member.getPhoneNumber() != null) {
            member.setCotisationList(cotisationService.getByMember(member.getPhoneNumber()));
            return new ResponseEntity<>(member.cotisationTotale(),HttpStatus.OK);
        }else { return new ResponseEntity<>(HttpStatus.NOT_FOUND); }
    }

    @GetMapping("/totalActivity/{date}")
    public ResponseEntity<?> getTotalActivity(@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date) {
        List<Cotisation> cotisationList = cotisationService.getByDate(date);
        System.out.println(cotisationList);
        double total = 0.0;
        for (Cotisation c: cotisationList) {
            total += c.getAmount();
        }
        return new ResponseEntity<>(total, HttpStatus.OK);
    }
}
