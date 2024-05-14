package org.example.test.pojo;

import ch.qos.logback.core.joran.action.PreconditionValidator;
import lombok.Data;

/**
 * 用户基本信息实体类,用@Data注解，省去写get/set方法
 */
@Data
public class User {
    // 人员唯一id
    private String user_id;
    // 人员名称
    private String user_name;
    // 登录账号
    private String login_account;
    // 登录密码
    private String login_pwd;
    // 人员角色
    private Integer user_role;
    // 人员届号
    private Integer user_period;
    // 人员所属部门（教师与学生公用，获取专业/班级/学号时只需转为string再切割）
    private Integer department;
    // 创建时间
    private String create_time;

    // 人员头像，头像大小不能超过16MB
    private String image;
    // 异常状态
    private Integer state; // 1正常0异常，默认为1
    // 封禁状态
    private Integer ban; // 1未封禁0封禁，默认为1
    // 专业ID
    private Integer major_id;
}
