package org.example.test.service.impl;

import jakarta.annotation.Resource;
import org.example.test.mapper.CollegeMapper;
import org.example.test.pojo.College;
import org.example.test.service.CollegeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 学院服务类
 */
@Service
public class CollegeServiceImpl implements CollegeService {

    @Resource
    private CollegeMapper collegeMapper;
    @Override
    public College findCollegeById(Integer college_id) {
        return collegeMapper.findCollegeById(college_id);
    }

    @Override
    public boolean createCollege(Integer college_id, String college_name) {
        return collegeMapper.createCollege(college_id, college_name);
    }

    @Override
    public College checkCollegeExist(Integer college_id, String college_name) {
        return collegeMapper.checkCollegeExist(college_id, college_name);
    }

    @Override
    public ArrayList<College> getCollegeAll() {
        ArrayList<College> colleges = collegeMapper.getCollegeAll();
        // 联表获取学院人数再返回
        for(College college : colleges) {
            college.setPeople_num(
                    collegeMapper.getPeopleCountByCollegeId(college.getCollege_id()));
            college.setMajor_num(collegeMapper.getMajorCountByCollegeId(college.getCollege_id()));
        }
        return colleges;
    }

    @Override
    public Integer getPeopleCountByCollegeId(Integer college_id) {
        return collegeMapper.getPeopleCountByCollegeId(college_id);
    }
}
