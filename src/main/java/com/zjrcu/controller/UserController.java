package com.zjrcu.controller;

import com.zjrcu.entity.User;
import com.zjrcu.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;

/**
 * web层，用户增删改查、批量新增、批量更新以及批量删除展示
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/select")
    @ResponseBody
    public ResponseEntity<List<User>> findAllUser() {
        return new ResponseEntity<>(userService.findAllUser(), HttpStatus.OK);
    }

    @RequestMapping("/insert")
    public boolean insertUser() {
        return userService.insertUser();
    }

    @RequestMapping("/update")
    public boolean updateUser() {
        return userService.updateUser();
    }

    @RequestMapping("/delete")
    public boolean deleteUser() {
        return userService.deleteUser();
    }

    @RequestMapping("/insertBatch")
    public boolean insertBatchUser() {
        return userService.insertBatchUser();
    }

    @RequestMapping("/updateBatch")
    public boolean updateBatchUser() {
        return userService.updateBatchUser();
    }

    @RequestMapping("/deleteBatch")
    public boolean deleteBatchUser() {
        return userService.deleteBatchUser();
    }

}
