package com.example.venuebookingserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.venuebookingserver.common.R;
import com.example.venuebookingserver.dao.AccountMapper;
import com.example.venuebookingserver.dao.UserMapper;
import com.example.venuebookingserver.entity.Account;
import com.example.venuebookingserver.entity.User;
import com.example.venuebookingserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    AccountMapper accountMapper;

    /**
     * 获取用户信息
     *
     * @param session session
     * @return R
     */
    @Override
    public R getUserInfo(HttpSession session) {
        Account accountInfo = (Account) session.getAttribute("accountInfo");
        if (Objects.isNull(accountInfo)) {
            return R.error("Not logged in");
        }
        if (Objects.isNull(accountInfo.getId())) {
            return R.error("User does not exist");
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account_id", accountInfo.getId());
        User user = userMapper.selectOne(queryWrapper);
        if (Objects.isNull(user)) {
            return R.error("User does not exist");
        }
        return R.success("User info", user);
    }

    /**
     * 更新用户信息
     *
     * @param user    用户
     * @param session session
     * @return R
     */
    @Override
    public R updateUserInfo(User user, HttpSession session) {
        Account accountInfo = (Account) session.getAttribute("accountInfo");
        if (Objects.isNull(accountInfo)) {
            return R.error("Not logged in");
        }
        if (Objects.isNull(accountInfo.getId())) {
            return R.error("User does not exist");
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account_id", accountInfo.getId());
        User queryUser = userMapper.selectOne(queryWrapper);
        if (Objects.isNull(queryUser)) {
            return R.error("User does not exist");
        }
        if (accountInfo.getType().equals(1)) {
            if (Objects.equals(queryUser.getId(), user.getId())) {
                if (userMapper.updateById(user) > 0) {
                    return R.success("User info updated successfully");
                }
                return R.error("User info update failed");
            }
        } else if (accountInfo.getType().equals(0)) {
            if (userMapper.updateById(user) > 0) {
                return R.success("User info updated successfully");
            }
            return R.error("User info update failed");
        }
        return R.error("User does not exist");
    }

    @Override
    public R addUserInfo(User user) {
        if (user == null) {
            return R.error("User info cannot be empty");
        }
        if (user.getAccountId() == null) {
            return R.error("accountId cannot be empty");
        }
        QueryWrapper<Account> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", user.getAccountId());
        Account account = accountMapper.selectOne(queryWrapper);
        if (account == null) {
            return R.error("Account does not exist");
        }
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("account_id", user.getAccountId());
        if (userMapper.exists(userQueryWrapper)) {
            return R.error("User already exists");
        }
        if (userMapper.insert(user) > 0) {
            return R.success("User info added successfully");
        }
        return R.error("User info added failed");
    }

    @Override
    public R getUser(Long accountId) {
        User users = userMapper.selectOne(new QueryWrapper<User>().eq("account_id", accountId));
        if (users != null) {
            return R.success("User info", users);
        }
        return R.error("User does not exist");
    }
}

// session 是用来保存（获取）用户的登陆状态的
// 是否还有其他方法来保存用户的登陆状态呢？
// 1. 使用cookie保存用户的登陆状态
// 2. 使用token保存用户的登陆状态
// 3. 使用session保存用户的登陆状态
// 4. 使用jwt保存用户的登陆状态
// 5. 使用redis保存用户的登陆状态
// 6. 使用数据库保存用户的登陆状态
// 7. threadlocal保存用户的登陆状态
