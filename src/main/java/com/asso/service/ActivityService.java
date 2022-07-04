package com.asso.service;

import com.asso.dao.ActivityDao;
import com.asso.model.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {
    @Autowired
    ActivityDao activityDao;

    public Activity add(Activity activity) {
        return activityDao.save(activity);
    }

    public Activity getActivity(Integer id) {
        return activityDao.findById(id).get();
    }
}
