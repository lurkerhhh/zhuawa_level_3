package org.example.test;

import jakarta.annotation.Resource;
import org.example.test.service.CollegeService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestApplicationTests {

    private static final String PWD_REGEX = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,}$";

    @Resource
    private CollegeService collegeService;
    @Test
    void contextLoads() {
        System.out.println(collegeService.findCollegeById(15));
    }
}
