package com.health.JDBCTest;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")
public class jdbcTemplateTest {
	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Test
	public void testTemplate() {
		try {
			Connection conn = dataSource.getConnection();
			log.info(">>>>>>>>>>>>>>Connection 출력 : " + conn);
			
			log.info(">>>>>>>>>>>> 템플릿 객체 생성 : " + "jdbcTemplate");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
