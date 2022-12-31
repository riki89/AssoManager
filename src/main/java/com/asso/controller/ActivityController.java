package com.asso.controller;

import com.asso.model.Activity;
import com.asso.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @GetMapping
    public ResponseEntity<?> getActivities() {
        return new ResponseEntity<>(activityService.getActivities(), HttpStatus.OK);
    }

//    @GetMapping
//    public ResponseEntity<?> getByType(@PathVariable("type") String type) {
//        List<Activity> activities = activityService.getBy(type);
//        if (activities != null){
//            return new ResponseEntity<>(activities, HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestBody Activity activity) {
        Activity act = activityService.update(activity);
        if (act != null){
            return new ResponseEntity<>(act, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping()
    public ResponseEntity<?> addActivity(@RequestBody Activity activity) {
        Activity activity1 = activityService.add(activity);
        if (activity1 != null) {
            return new ResponseEntity<>(activity1, HttpStatus.OK);
        } else
        return new ResponseEntity<>(activity1, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Activity> getActivity(@PathVariable Integer id) {
        Activity activity = activityService.getActivity(id);
        if (activity != null ) {
            return new ResponseEntity<>(activity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/test")
    public String test(){
        return "test ok";
    }
}
