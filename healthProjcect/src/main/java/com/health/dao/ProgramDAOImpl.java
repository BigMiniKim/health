package com.health.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.health.domain.HealthProVO;

import lombok.extern.log4j.Log4j;

@Repository("programDAO")
@Log4j
public class ProgramDAOImpl implements ProgramDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean insert(HealthProVO pvo) {

		boolean result = false;

		log.info("프로그램에서의 pvo값 확인" + pvo);

		String sql = "insert into program(name,date,times,totalPerson) values (?,?,?,?)";

		// DB작업
		/*
		 * if(DB.add(vo)) { result = 1; };
		 */

		int re = jdbcTemplate.update(sql,
				new Object[] { pvo.getName(), pvo.getDate(), pvo.getTimes(), pvo.getTotalPerson() });
		log.info("프로그램 insert 결과 : " + result);

		if (re == 1) {

			result = true;

		}

		return result;
	}

	@Override
	public HealthProVO selectOne(int pid) {
		
		String sql = "select * from program where id = ?";

		/* list<HelathPvoVO> result = null; */

		List<HealthProVO> result1 = jdbcTemplate.query(sql, new Object[] {pid}, new RowMapper<HealthProVO>() {
			@Override
			public HealthProVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				HealthProVO pvo = new HealthProVO();
				pvo.setName(rs.getString("name"));
				pvo.setDate(rs.getString("date"));
				pvo.setTimes(rs.getInt("times"));
				pvo.setTotalPerson(rs.getInt("totalPerson"));

				return pvo;
			}
		});
		

		return result1.get(0); 	
	}
	
	@Override
	public ArrayList<HealthProVO> selectAll() {
		
		String sql = "select * from program";
		
			List<HealthProVO> result = jdbcTemplate.query(sql, new RowMapper<HealthProVO>(){
				
			public HealthProVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				HealthProVO pvo = new HealthProVO();
				pvo.setPid(rs.getInt("id"));
				pvo.setName(rs.getString("name"));
				pvo.setDate(rs.getString("date"));
				pvo.setTimes(rs.getInt("times"));
				pvo.setTotalPerson(rs.getInt("totalPerson"));

				return pvo;				
			}
				});
		
		return (ArrayList<HealthProVO>)result;
	}

	@Override
	public boolean update(HealthProVO pvo) {
		boolean result = false;
		
		String sql = "update program set name = ?, date = ?, times = ?, totalPerson = ? where id = ?";
		
			int re = jdbcTemplate.update(sql,
					new Object[] { pvo.getName(), pvo.getDate(), pvo.getTimes(), pvo.getTotalPerson() });
			log.info("프로그램 insert 결과 : " + result);

			if (re == 1) {

				result = true;

			}

			return result;
		}
	

	@Override
	public void delete(int pid) {
		
		String sql = "delete from program where id = ?";
		jdbcTemplate.update(sql,new Object[] {pid});
	}
}