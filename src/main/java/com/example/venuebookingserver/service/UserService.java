package com.example.venuebookingserver.service;

import com.example.venuebookingserver.common.R;
import com.example.venuebookingserver.entity.User;

import javax.servlet.http.HttpSession;

public interface UserService {
    R getUserInfo(HttpSession session);

    R updateUserInfo(User user, HttpSession session);

    R addUserInfo(User user);
    R getUser(Long accountId);
}
