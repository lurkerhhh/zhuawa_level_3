package org.example.test.service;

import org.example.test.pojo.College;

import java.util.ArrayList;

public interface CollegeService {

    College findCollegeById(Integer college_id);

    boolean createCollege(Integer college_id, String college_name);

    College checkCollegeExist(Integer college_id, String college_name);

    ArrayList<College> getCollegeAll();

    Integer getPeopleCountByCollegeId(Integer college_id);

}
