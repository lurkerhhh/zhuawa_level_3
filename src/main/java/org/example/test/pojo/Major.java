package org.example.test.pojo;

import lombok.Data;

/**
 * 专业类
 */
@Data
public class Major {
    // 专业编号
    private Integer major_id;
    // 专业名称
    private String major_name;
    // 所属学院的id
    private Integer c_id;
}
