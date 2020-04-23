package com.sandra.springbootdata.controller;

import java.util.List;

import com.sandra.springbootdata.mapper.UserMapper;
import com.sandra.springbootdata.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/queryUserList")
    public List<User> queryUserList() {
        List<User> users = userMapper.queryUserList();

        for (User user : users) {
            System.out.println(user);
        }

        return users;
    }

    @GetMapping("/addUser")
    public String addUser() {
        userMapper.addUser(new User(6, "茶花", "mmm"));
        return "add-ok";
    }

    @GetMapping("/updateUser")
    public String updateUser() {
        userMapper.updateUser(new User(6, "福福", "vvv"));
        return "update-ok";
    }

    @GetMapping("/deleteUser")
    public String deleteUser() {
        userMapper.deleteUser(6);
        return "delete-ok";
    }
}
