package com.asso.controller;

import com.asso.model.Activity;
import com.asso.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @PostMapping()
    public ResponseEntity<?> getActivity(@RequestBody Activity activity) {
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
