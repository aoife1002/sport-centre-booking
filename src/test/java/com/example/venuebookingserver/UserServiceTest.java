package com.example.venuebookingserver;

import com.example.venuebookingserver.common.R;
import com.example.venuebookingserver.entity.User;
import com.example.venuebookingserver.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserService userService;


    @Test
    public void testAddUserInfo() {
        User user = new User();
        user.setAccountId(1787139641558102019L);
        user.setAge(1);
        user.setEmail("test");
        user.setName("test");
        R r = userService.addUserInfo(user);
        System.out.println(r);
    }

}
