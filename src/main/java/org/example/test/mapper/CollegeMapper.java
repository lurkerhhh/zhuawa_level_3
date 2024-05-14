package org.example.test.mapper;


import org.apache.ibatis.annotations.*;
import org.example.test.pojo.College;
import org.example.test.pojo.Major;

import java.util.ArrayList;
import java.util.List;

/**
 * 如果写xml映射文件的话直接联表查询更快
 * sql：SELECT c.college_id, c.college_name, m.major_id, m.major_name FROM college c
 * LEFT JOIN major m ON c.college_id = m.c_id WHERE m.c_id=15
 */
@Mapper
public interface CollegeMapper {

    @Select("SELECT college_id, college_name FROM college WHERE college_id = #{college_id}")
    @Results({
            @Result(property = "college_id", column = "college_id"),
            @Result(property = "college_name", column = "college_name"),
            @Result(property = "major_list", javaType = ArrayList.class, column = "college_id",
                    many = @Many(select = "findMajorsByCollegeId"))
    })
    College findCollegeById(Integer college_id);

    @Select("SELECT major_id, major_name, c_id FROM major WHERE c_id = #{college_id}")
    @Results({
            @Result(property = "major_id", column = "major_id"),
            @Result(property = "major_name", column = "major_name"),
            @Result(property = "c_id", column = "c_id")
    })
    ArrayList<Major> findMajorsByCollegeId(Integer college_id);

    @Insert("insert into college(college_id, college_name) values(#{college_id}, #{college_name})")
    boolean createCollege(Integer college_id, String college_name);

    @Select("select * from college where college_id=#{college_id} or college_name=#{college_name}")
    College checkCollegeExist(Integer college_id, String college_name);
    @Select("select * from college")
    ArrayList<College> getCollegeAll();

    @Select("SELECT COUNT(*) AS major_count " +
            "FROM college c " +
            "LEFT JOIN major m ON c.college_id = m.c_id " +
            "WHERE c.college_id = #{college_id};")
    Integer getMajorCountByCollegeId(Integer college_id);

    @Select("SELECT COUNT(*) AS people_count " +
            "FROM college c " +
            "LEFT JOIN major m ON c.college_id = m.c_id " +
            "LEFT JOIN user u ON u.major_id = m.major_id " +
            "WHERE c.college_id = #{college_id};")
    Integer getPeopleCountByCollegeId(Integer college_id);
}
