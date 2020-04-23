package com.sandra.springbootshiro.mapper;

import com.sandra.springbootshiro.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
@Mapper
public interface UserMapper {

    User queryUserByName(String name);
}
