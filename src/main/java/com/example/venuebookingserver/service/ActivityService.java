package com.example.venuebookingserver.service;

import com.example.venuebookingserver.common.R;
import com.example.venuebookingserver.entity.Activity;
import com.example.venuebookingserver.vo.ActivityQuery;

public interface ActivityService {
    R addActivity(Activity activity);

    R getActivity(ActivityQuery param);

    R updateActivity(Activity activity);

    R deleteActivityById(Long id);

}
