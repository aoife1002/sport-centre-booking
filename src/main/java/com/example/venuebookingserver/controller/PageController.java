package com.example.venuebookingserver.controller;

import com.example.venuebookingserver.entity.Account;
import com.example.venuebookingserver.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping
@Controller
public class PageController {

    @RequestMapping("/login-page")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/error-page")
    public String toError(){
        return "error";
    }

    @RequestMapping("/register-page")
    public String toRegister(){
        return "register";
    }

    @RequestMapping("/index-page")
    public String toIndex(HttpServletRequest request, HttpServletResponse response, Model model){
        Account account = (Account) request.getSession().getAttribute("accountInfo");
        if (account!=null){
            String page = "";
            if (account.isAdmin()){
                page = "/index0";
            }
            if (account.isUser()){
                page = "/index1";
            }
            return page;
        }
        return "login";
    }

}
