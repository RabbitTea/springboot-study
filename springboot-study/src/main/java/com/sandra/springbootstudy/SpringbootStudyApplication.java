package com.sandra.springbootstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 程序的主入口；
 * 本身就是Spring的一个组件；
 *
 * @SpringBootApplication 标注这个类是一个springboot的应用；
 */
@SpringBootApplication
public class SpringbootStudyApplication {

	/**
	 * 这里可以点击启动一个Springboot项目
	 * @param args
	 */
	public static void main(String[] args) {

		// 将springboot应用启动
		SpringApplication.run(SpringbootStudyApplication.class, args);
	}

}
