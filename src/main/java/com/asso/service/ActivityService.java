package com.asso.service;

import com.asso.dao.ActivityDao;
import com.asso.model.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {
    @Autowired
    ActivityDao activityDao;

    public Activity add(Activity activity) {
        return activityDao.save(activity);
    }

    public List<Activity> getActivities() {
        return activityDao.findAll();
    }

    public Activity getActivity(Integer id) {
        Optional opt = activityDao.findById(id);
        if (opt.isPresent()) {
            return activityDao.findById(id).get();
        } else return (Activity) Optional.empty().get();

    }

    public Activity update(Activity activity) { return activityDao.save(activity);}

    public List<Activity> getBy(String type) {
        return activityDao.findByType(type);
    }
}
