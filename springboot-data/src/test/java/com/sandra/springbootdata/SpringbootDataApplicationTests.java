package com.sandra.springbootdata;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootDataApplicationTests {

	@Autowired
	DataSource dataSource;

	@Test
	void contextLoads() throws SQLException {

		// 查看默认的数据源：com.zaxxer.hikari.HikariDataSource == 类似dbcp，只是速度上有区别
		System.out.println(dataSource.getClass());

		// 获得数据库连接
		Connection connection = dataSource.getConnection();
		System.out.println(connection);

		// xxxx Template == springboot已经配置好的模板bean，开箱即用
		// jdbc
		// redis

		// 关闭连接
		connection.close();
	}

}
