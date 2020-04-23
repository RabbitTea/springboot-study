package com.sandra.springbootstudy;

import com.sandra.springbootstudy.pojo.Dog;
import com.sandra.springbootstudy.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 单元测试
 */
@SpringBootTest
class SpringbootStudyApplicationTests {

	@Autowired
	private Dog dog;

	@Autowired
	private Person person;

	@Test
	void contextLoads() {

		System.out.println(person);

		System.out.println(dog);
	}

}
