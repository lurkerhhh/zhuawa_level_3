package org.example.test.controller;


import jakarta.annotation.Resource;
import org.example.test.mapper.UserMapper;
import org.example.test.pojo.College;
import org.example.test.pojo.Result;
import org.example.test.pojo.User;
import org.example.test.service.CollegeService;
import org.example.test.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 业务控制层(正常应该不同业务分开写，这里我直接全写一个控制层里了)
 */
@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*") // 解决CORS跨域问题，允许所有来源的请求跨域
public class TestController {
    // 验证密码的合法性（至少8个字符，包含大小写字母和数字）
    private static final String PWD_REGEX = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,}$";

    @Resource
    private UserService userService;

    @Resource
    private CollegeService collegeService;

    /**
     * 用户登录
     * @param account
     * @param password
     * @param user_role
     * @return
     */
    @PostMapping("/login")
    public Result<User> login(@RequestParam String account, @RequestParam String password,
    @RequestParam String user_role){
        if(!password.matches(PWD_REGEX)){ // 检验密码格式
            return Result.failure(401);
        }
        try {
            User user = userService.findUserByAccountAndPwd(account, password, user_role);
            if (user != null) {
                return Result.success(user);
            } else {
                return Result.failure(200, null);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.failure(400);
    }

    /**
     * 查询非管理员所有用户
     * @return
     */
    @GetMapping("/displayAllUser")
    public Result<ArrayList<User>> displayAllUser(){
        try {
           return Result.success(userService.displayAllUser());
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.failure(400);
    }

    @GetMapping("/findUserById")
    public Result<User> findUserById(@RequestParam String user_id){
        try {
            User user = userService.findUserById(user_id);
            return Result.success(user);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.failure(400);
    }

    /**
     * 创建用户
     * @param user
     * @return
     */
    @PostMapping("/createUser")
    public Result<String> createUser(@RequestBody User user){ // 实体类对象接收
        // System.out.println("收到请求：" + user.getUser_name());
        // 验证密码格式
        if (!user.getLogin_pwd().matches(PWD_REGEX)) {
            return Result.failure(400, "密码格式错误！密码必修包含大小写和数字且长度大于8");
        }
        try {
            boolean rs = userService.CreateAccount(user);
            if (rs){
                return Result.success("success");
            }else{
                return Result.success("failure");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.failure(400);
    }

    /**
     * 根据用户ID修改用户信息
     * @param user
     * @return
     */
    @PostMapping("/updateUser")
    public Result<String> updateUser(@RequestBody User user){ // 实体类对象接收
        // System.out.println("收到请求：" + user.getUser_name());
        // 验证密码格式
        if (!user.getLogin_pwd().matches(PWD_REGEX)) {
            return Result.failure(400, "密码格式错误！密码必修包含大小写和数字且长度大于8");
        }
        try {
            boolean rs = userService.updateUserByUserId(user);
            if (rs){
                return Result.success("success");
            }else{
                return Result.success("failure");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.failure(400);
    }

    /**
     * 根据用户ID删除用户信息
     * @param user_id
     * @return
     */
    @GetMapping("/delUser")
    public Result<String> updateUser(@RequestParam String user_id){ // 实体类对象接收
        // System.out.println("收到请求：" + user.getUser_name());
        try {
            boolean rs = userService.delUserById(user_id);
            if (rs){
                return Result.success("success");
            }else{
                return Result.success("failure");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.failure(400);
    }

    /**
     * 创建院系
     * @param college_id
     * @param college_name
     * @return
     */
    @GetMapping("/addCollege")
    public Result<String> addCollege(Integer college_id, String college_name){
        try {
            // 检测学院编号名称是否重复
            College college = collegeService.checkCollegeExist(college_id, college_name);
            if (college != null) return Result.failure(400,"学院名称/编号重复");
            boolean rs = collegeService.createCollege(college_id, college_name);
            if (rs){
                return Result.success("success");
            }else {
                return Result.failure(400);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.failure(400);
    }

    @GetMapping("/displayAllCollege")
    public Result<ArrayList<College>> displayAllCollege(){
        ArrayList<College> colleges = collegeService.getCollegeAll();
        return Result.success(colleges);
    }

}
