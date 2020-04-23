package com.sandra.springbootdata.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public class JDBCController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 查询数据库的所有信息；
     * 在没有实体类的情况下获取：万能的map
     */
    @GetMapping("/userList")
    public List<Map<String, Object>> userList() {
        String sql = "select * from user";
        return jdbcTemplate.queryForList(sql);
    }

    /**
     * add
     */
    @GetMapping("/addUser")
    public String addUser() {
        String sql = "insert into mybatis.user(id, name, pwd) values (6, '大黄', 'hhh')";
        jdbcTemplate.update(sql);
        return "add-ok";
    }

    /**
     * update
     */
    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id")int id) {

        // 带?号说明是个预编译SQL，后面需要把？的值传进去
        String sql = "update mybatis.user set name=?, pwd=? where id=" + id;

        // 封装数据
        Object[] objects = new Object[2];
        objects[0] = "茶花";
        objects[1] = "yyy";

        // update有很多重载方法
        jdbcTemplate.update(sql, objects);
        return "update-ok";
    }

    /**
     * delete
     */
    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id")int id) {

        String sql = "delete from mybatis.user where id = ?";
        jdbcTemplate.update(sql, id);

        return "delete-ok";
    }

}
