package com.example.venuebookingserver.service.impl;

import com.example.venuebookingserver.entity.Account;
import com.example.venuebookingserver.entity.Activity;
import com.example.venuebookingserver.service.ActivityService;
import com.example.venuebookingserver.vo.ActivityQuery;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;

import java.sql.Timestamp;

@SpringBootTest
class ActivityServiceImplTest {
    @Autowired
    ActivityService activityService;


    static MockHttpSession mockHttpSession;

    @BeforeAll
    public static void setUp() {

        Account account = new Account();
        account.setId(1L);
        account.setType(1);
        account.setUserName("test");
        account.setPassword("test");

        mockHttpSession = new MockHttpSession();
        mockHttpSession.setAttribute("accountInfo",account);
    }

    @Test
    public void testAddActivity() {
        Activity activity = new Activity();
        activity.setActivityType(1);
        activity.setStartTime(new Timestamp(System.currentTimeMillis()));
        activity.setEndTime(new Timestamp(System.currentTimeMillis()));
        activityService.addActivity(activity);
    }

    @Test
    public void testGetActivity() {
        ActivityQuery param = new ActivityQuery();
        param.setType(1);
        param.setEndTime(new Timestamp(System.currentTimeMillis()));
        param.setStartTime(new Timestamp(System.currentTimeMillis()));
        activityService.getActivity(param);

    }

    @Test
    public void testUpdateActivity() {
        Activity activity = new Activity();
        activity.setId(1L);
        activity.setActivityType(1);
        activity.setStartTime(new Timestamp(System.currentTimeMillis()));
        activity.setEndTime(new Timestamp(System.currentTimeMillis()));
        activityService.updateActivity(activity);

    }

    @Test
    public void testDeleteActivityById() {
        activityService.deleteActivityById(1L);
    }
}