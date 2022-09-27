package com.innovationweek.user.controller;

import com.innovationweek.user.VO.ResponseTemplateVO;
import com.innovationweek.user.entity.DeptUser;
import com.innovationweek.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public DeptUser saveUser(@RequestBody DeptUser deptUser){
        log.info("inside saveUser of User controller");
        return userService.saveUser(deptUser);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId){
        log.info("Inside getUserWithDepartment of User Controller");
        return userService.getUserWithDepartment(userId);
    }
}
