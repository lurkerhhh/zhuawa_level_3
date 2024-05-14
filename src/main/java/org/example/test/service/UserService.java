package org.example.test.service;

import jakarta.annotation.Resource;
import org.example.test.mapper.UserMapper;
import org.example.test.pojo.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


public interface UserService {
    boolean login(String account, String pwd, String user_role);

    User findUserByAccountAndPwd(String account, String pwd, String user_role);

    ArrayList<User> displayAllUser();
    boolean CreateAccount(User user);

    boolean updateUserByUserId(User user);

    boolean delUserById(String user_id);

    User findUserById(String user_id);
}
