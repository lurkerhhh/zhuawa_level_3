package org.example.test.service.impl;

import jakarta.annotation.Resource;
import org.example.test.mapper.UserMapper;
import org.example.test.pojo.User;
import org.example.test.service.UserService;
import org.example.test.tools.TimeTool;
import org.example.test.tools.UUIDTool;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class UserServiceimpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public boolean login(String account, String pwd, String user_role) {
        User user = userMapper.findUserByAccountAndPwd(account, pwd, user_role);
        if (user != null)
        {
            return true;
        }else {
            return false;
        }
    }

    @Override
    public User findUserByAccountAndPwd(String account, String pwd, String user_role) {
        return userMapper.findUserByAccountAndPwd(account, pwd, user_role);
    }

    @Override
    public User findUserById(String user_id) {
        return userMapper.findUserById(user_id);
    }

    @Override
    public ArrayList<User> displayAllUser() { // 非管理员
        return userMapper.displayAllUser();
    }

    @Override
    public boolean CreateAccount(User user) {
        user.setUser_id(UUIDTool.getUUID()); // 生成唯一id序列
        user.setCreate_time(TimeTool.getTime()); // 获取当前系统时间
        String m = user.getDepartment().toString().substring(2, 4); // 转换为string获取前两位数为
        user.setMajor_id(Integer.parseInt(m)); // 切割完再转换回去
        return userMapper.CreateAccount(user);
    }

    @Override
    public boolean updateUserByUserId(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public boolean delUserById(String user_id) {
        return userMapper.delUser(user_id);
    }
}
