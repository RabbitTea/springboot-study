package com.sandra.springbootstudy.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 */
@Component
@ConfigurationProperties(prefix = "dog")
public class Dog {

    private String firstName;

    private Integer age;

    public Dog() {

    }

    public Dog(String firstName, Integer age) {
        this.firstName = firstName;
        this.age = age;
    }

    public String getName() {
        return firstName;
    }

    public void setName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
            "name='" + firstName + '\'' +
            ", age=" + age +
            '}';
    }
}
