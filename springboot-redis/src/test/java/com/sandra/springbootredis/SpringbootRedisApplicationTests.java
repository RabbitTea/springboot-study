package com.sandra.springbootredis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sandra.springbootredis.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class SpringbootRedisApplicationTests {

	@Autowired
	@Qualifier("redisTemplate")  //多个同名bean时用其指定
	private RedisTemplate redisTemplate;

	@Test
	void contextLoads() {
		/**
		 * 企业开发中，一般不会使用下面原生的方式编写代码
		 * 会写成一个RedisUtils
		 */

		/**
		 * 每一个操作对应一个数据类型：
		 *
		 * opsForValue()操作字符串，类似String
		 * opsForList()操作list，类似List
		 * opsForSet()
		 * opsForHash()
		 * opsForGeo()
		 * opsForZSet()
		 * opsForHyperLogLog()
 		 */
		redisTemplate.opsForValue().set("mykey", "Sandra");

		System.out.println(redisTemplate.opsForValue().get("mykey"));

		/**
		 * redis的常用操作都可以直接通过redisTemplate使用；
		 *
		 * 如事务和基本的CRUD
		 */
		// 获取redis连接对象
		RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
		connection.flushDb();
		connection.flushAll();
	}

	@Test
	void test() throws JsonProcessingException {

		// 真实的开发一般都使用JSON来传递对象
		User user = new User("sandra", 7);
		// user序列化
		String jsonUser = new ObjectMapper().writeValueAsString(user);

		// 若直接传递user对象，如果user没有序列化，会报序列化的错误
		redisTemplate.opsForValue().set("user", jsonUser);
		System.out.println(redisTemplate.opsForValue().get("user"));
	}

}
