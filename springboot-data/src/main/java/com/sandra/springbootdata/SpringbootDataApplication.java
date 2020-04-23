package com.sandra.springbootdata;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.sandra.mapper")  //表示扫描包路径
public class SpringbootDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDataApplication.class, args);
	}

}
