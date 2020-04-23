package com.sandra.staffmanagement.pojo;

import java.util.Date;

/**
 * 员工表
 */
public class Employee {

    private Integer id;

    private String lastName;

    private String email;

    /**
     * 性别；数据库中会用0/1分别来代表；这里0：女；1：男
     */
    private Integer gender;

    private Department department;

    private Date birth;

    public Employee() {

    }

    /**
     * 自定义有参构造，让日期在内部生成
     *
     * @param id
     * @param lastName
     * @param email
     * @param gender
     * @param department
     */
    public Employee(Integer id, String lastName, String email, Integer gender,
        Department department) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.department = department;
        // 默认创建日期
        this.birth = new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Employee{" +
            "id=" + id +
            ", lastName='" + lastName + '\'' +
            ", email='" + email + '\'' +
            ", gender=" + gender +
            ", department=" + department +
            ", birth=" + birth +
            '}';
    }
}
