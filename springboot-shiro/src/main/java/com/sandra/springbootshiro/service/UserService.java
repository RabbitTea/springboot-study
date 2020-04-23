package com.sandra.springbootshiro.service;

import com.sandra.springbootshiro.pojo.User;
import org.springframework.stereotype.Service;

/**
 */
public interface UserService {

    User queryUserByName(String name);
}
