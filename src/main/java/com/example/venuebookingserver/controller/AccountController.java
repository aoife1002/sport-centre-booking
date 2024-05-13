package com.example.venuebookingserver.controller;

import com.example.venuebookingserver.common.R;
import com.example.venuebookingserver.entity.Account;
import com.example.venuebookingserver.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@RequestMapping("/account")
@Controller
public class AccountController {

    @Autowired
    AccountService accountService;

    /**
     * 登录
     * @param account account (username, password)
     * @param session session
     * @return R
     */
    @ResponseBody
    @RequestMapping("/login")
    public R login(@RequestBody Account account, HttpSession session){
        return accountService.login(account, session);
    }

//    {
//        "code": 200,
//        "msg": "登录成功",
//        "data": {
//            "id": 1,
//            "username": "admin",
//            "password": "admin",
//            "type": 1
//        }
//    }

    /**
     * 退出登录
     * @param session session
     * @return R
     */
    @ResponseBody
    @RequestMapping("/logout")
    public R loginOut(HttpSession session){
        return accountService.logout(session);
    }


    /**
     * 注册 管理员账户是默认后台添加的 or 在管理员注册界面传type 1
     * @param account (username, password,type)
     * @return
     */
    @ResponseBody
    @RequestMapping("/register")
    public R register(@RequestBody Account account){
        return accountService.register(account);
    }

    /**
     * 更新用户信息
     * @param account account (id, (可选 username, password,type))
     * @return R
     */
    @ResponseBody
    @RequestMapping("/update")
    public R update(@RequestBody Account account){
        return accountService.update(account);
    }

    /**
     * 获取账户列表信息
     * @return R
     */
    @ResponseBody
    @GetMapping("/getList")
    public R getList() {
        return accountService.getList();
    }
}
