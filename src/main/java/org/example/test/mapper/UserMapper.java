package org.example.test.mapper;

import org.apache.ibatis.annotations.*;
import org.example.test.pojo.User;

import java.util.ArrayList;

/**
 * 写mapper的xml映射文件更好，但时间有限，只能修改全部字段了,对性能有影响。
 */
@Mapper
public interface UserMapper {
    /**
     * 根据账号密码查询用户信息
     * @param login_account
     * @param login_pwd
     * @return
     */
    @Select("select * from user where login_account = #{login_account} " +
            "and login_pwd = #{login_pwd} and user_role = #{user_role}")
    User findUserByAccountAndPwd(String login_account, String login_pwd, String user_role);

    /**
     * 创建用户
     * @param user
     * @return
     */
    @Insert("insert into user (user_id, user_name, login_account, login_pwd, user_role, user_period, department, create_time, image, major_id)" +
            "values (#{user.user_id}, #{user.user_name}, #{user.login_account}, #{user.login_pwd}," +
            " #{user.user_role}, #{user.user_period}, #{user.department}, #{user.create_time}, #{user.image}, #{user.major_id})")
    boolean CreateAccount(@Param("user") User user);

    /**
     * 查询所有非管理员用户
     * @return
     */
    @Select("select * from user where user_role != '3'")
    ArrayList<User> displayAllUser();

    /**
     * 根据用户ID修改用户信息(没写xml映射文件，只能修改全部字段了,影响性能)
     * @param user
     * @return
     */
    @Update("update user set user_name=#{user.user_name}, login_account=#{user.login_account}" +
            ", login_pwd=#{user.login_pwd}, user_role=#{user.user_role}, user_period=#{user.user_period}" +
            ", department=#{user.department}, image=#{user.image}, state=#{user.state}, ban=#{user.ban}" +
            " where user_id=#{user.user_id}")
    boolean updateUser(@Param("user") User user);

    /**
     * 根据用户ID删除用户信息
     * @param user_id
     * @return
     */
    @Delete("delete from user where user_id=#{user_id}")
    boolean delUser(String user_id);
    @Select("select * from user where user_id=#{user_id}")
    User findUserById(String user_id);
}
