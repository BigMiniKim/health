package com.health.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.health.domain.RegisterDTO;

@Repository("registerDAO")
public class RegisterDAOImpl implements RegisterDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public boolean insert(RegisterDTO rdto) {
		
		boolean result = false;
		
		String sql = "insert into register (healthUseId, pId) values (?,?)";
		int re = jdbcTemplate.update(sql, new Object[] {
				rdto.getHealthUseId(),
				rdto.getPId()
		});
		
		if (re ==1) {
			
			result =true;
		}
		return result;
	}

	@Override
	public int personCount(int pid) {
		String sql = "select * from register where pId = ? ";
		List<RegisterDTO> list = jdbcTemplate.query(sql, new Object[] {pid}, new RowMapper<RegisterDTO>() {

			@Override
			public RegisterDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				RegisterDTO rdto = new RegisterDTO();	
				rdto.setPId(rs.getInt("pid"));
				
				return rdto;
			}
			
			
		});
		return list.size();
	}

	@Override
	public boolean delete(int rid) {
		
		boolean result =false;
		String sql = "delete from register where id = ?";
		int re = jdbcTemplate.update(sql,new Object[] {rid});
		if (re == 1) result = true;
		return result;
	}

	@Override
	public ArrayList<RegisterDTO> select(int healthUseNo) {
		String sql = "select * from register where healthUseId = ?";
		List<RegisterDTO> list = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<RegisterDTO>() {

			@Override
			public RegisterDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				RegisterDTO rdto = new RegisterDTO();
				rdto.setId(rs.getInt("id"));
				rdto.setHealthUseId(rs.getInt("healthUseId"));
				rdto.setPId(rs.getInt("pId"));
				return rdto;
			}
			
			
			
		});
		return (ArrayList<RegisterDTO>) list;
	}

}
