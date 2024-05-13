package com.example.venuebookingserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.venuebookingserver.common.R;
import com.example.venuebookingserver.dao.AccountMapper;
import com.example.venuebookingserver.entity.Account;
import com.example.venuebookingserver.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountMapper accountMapper;

    /**
     * 登录
     *
     * @param account 账户
     * @param session session
     * @return R
     */
    @Override
    public R login(Account account, HttpSession session) {
        String userName = account.getUserName();
        String password = account.getPassword();
        if (userName == null || password == null) {
            return R.error("Username and password cannot be empty");
        }
        Account queryAccount = accountMapper.queryAccount(userName, password);
        if (queryAccount == null) {
            return R.error("Incorrect username or password");
        }
        if (account.getType() != null) {
            if ((account.getType() == 1 && !queryAccount.isUser()) ||
                    (account.getType() == 0 && !queryAccount.isAdmin())) {
                return R.error("You do not have permission to log in");
            }
        }
        if (queryAccount != null) {
            session.setAttribute("accountInfo", queryAccount);
            return R.success("Login successfully");
        }
        return R.error("Incorrect username or password");
    }

    /**
     * 注册
     *
     * @param account 账户
     * @return R
     */
    @Override
    public R register(Account account) {
        //todo 验证用户名和密码是否合规
        if (account.getUserName() == null || account.getPassword() == null || account.getType() == null) {
            return R.error("Username and password and type cannot be empty");
        }
        account.setType(account.getType());
        synchronized (this) {
            QueryWrapper<Account> wrapper = new QueryWrapper<>();
            wrapper.eq("user_name", account.getUserName());
            if (accountMapper.exists(wrapper)) {
                return R.error("The username already exists");
            } else {
                // todo 密码加密 password = MD5(password) 优化方向
                accountMapper.insert(account);
                return R.success("Registration success");
            }
        }
    }

    /**
     * 退出
     *
     * @param session session
     * @return R
     */
    @Override
    public R logout(HttpSession session) {
        session.removeAttribute("accountInfo");
        return R.success("Successfully exited");
    }

    /**
     * 更新
     *
     * @param account 账户
     * @return R
     */
    @Override
    public R update(Account account) {
        if (account.getUserName() == null || account.getPassword() == null) {
            return R.error("Username and password cannot be empty");
        }
        synchronized (this) {
            QueryWrapper<Account> wrapper = new QueryWrapper<>();
            // 查询用户名
            wrapper.eq("user_name", account.getUserName());
            Account selectOne = accountMapper.selectOne(wrapper);
            if (selectOne != null) {
                selectOne.setPassword(account.getPassword());
                accountMapper.updateById(selectOne);
                return R.success("Update success");
            } else {
                return R.error("The username does not exist");
            }
        }
    }

    @Override
    public R getList() {
        List<Account> accounts = accountMapper.selectList(null);
        if (accounts != null){
            return R.success("Get success",accounts);
        }
        return R.error("Get failed");
    }
}
