package com.sandra.springbootdata.mapper;

import java.util.List;

import com.sandra.springbootdata.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Mapper   // 表示这是一个mybatis的mapper，使得在springboot启动时被启动；或者在主启动类中加@MapperScan注解，把包路径包含进去
@Repository  // 成为spring bean
public interface UserMapper {

    List<User> queryUserList();

    User queryUserById(int id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);
}
