package org.example.test.pojo;

import lombok.Data;

import java.util.ArrayList;

/**
 * 学院类
 */
@Data
public class College {
    // 学院id
    private Integer college_id;
    // 学院名称
    private String college_name;
    // 存储该学院下所有的专业（也可从中获取专业数）
    private ArrayList<Major> major_list;
    // 专业人数（直接联表获取）
    private Integer people_num;
    // 学院数量
    private Integer major_num;
}
