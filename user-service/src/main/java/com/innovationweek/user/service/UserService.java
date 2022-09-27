package com.innovationweek.user.service;

import com.innovationweek.user.VO.Department;
import com.innovationweek.user.VO.ResponseTemplateVO;
import com.innovationweek.user.controller.UserController;
import com.innovationweek.user.entity.DeptUser;
import com.innovationweek.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public DeptUser saveUser(DeptUser deptUser) {
        log.info("inside saveUser of UserService");
      return   userRepository.save(deptUser);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("inside the getUserWithDepartment method in  UserService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        DeptUser deptUser = userRepository.findByUserId(userId);
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + deptUser.getDepartmentId(), Department.class);
        vo.setUser(deptUser);
        vo.setDepartment(department);

        return vo;
    }
}
