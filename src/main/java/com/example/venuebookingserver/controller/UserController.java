package com.example.venuebookingserver.controller;


import com.example.venuebookingserver.common.R;
import com.example.venuebookingserver.entity.User;
import com.example.venuebookingserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 获取用户信息
     * @param session session
     * @return R
     */
    @ResponseBody
    @GetMapping("/getUserInfo")
    public R getUserInfo(HttpSession session) {
        return userService.getUserInfo(session);
    }

    /**
     * 更新用户信息
     * @param user 用户 (id)
     * @param session session
     * @return R
     */
    @ResponseBody
    @PutMapping("/updateUserInfo")
    public R updateUserInfo(@RequestBody User user,HttpSession session) {
        return userService.updateUserInfo(user,session);
    }

    /**
     * 新增用户信息
     * @param user 用户 （accountId,name,age,email）
     * @return R
     */
    @ResponseBody
    @PostMapping("/addUserInfo")
    public R addUserInfo(@RequestBody User user) {
        return userService.addUserInfo(user);
    }

    /**
     * 获取用户列表信息
     * @return R
     */
    @ResponseBody
    @GetMapping("/getDetails/{accountId}")
    public R getUser(@PathVariable Long accountId) {
        return userService.getUser(accountId);
    }
}
