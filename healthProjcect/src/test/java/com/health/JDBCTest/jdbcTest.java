package com.health.JDBCTest;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class jdbcTest {

	String url = "jdbc:mysql://127.0.0.1:3306/health?serverTimezone=Asia/Seoul";
	String user = "pt";
	String password = "pt";

	@Test
	public void JdbcTest() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection conn = DriverManager.getConnection(url, user, password);

			log.info(">>>>>>Connection 객체 생성 : " + conn);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
