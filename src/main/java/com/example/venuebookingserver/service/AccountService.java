package com.example.venuebookingserver.service;

import com.example.venuebookingserver.common.R;
import com.example.venuebookingserver.entity.Account;

import javax.servlet.http.HttpSession;

public interface AccountService {
    R login(Account account, HttpSession session);

    R register(Account account);

    R logout(HttpSession session);

    R update(Account account);

    R getList();
}
