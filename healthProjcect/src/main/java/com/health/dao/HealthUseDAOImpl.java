package com.health.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.health.domain.HealthUseVO;

import lombok.extern.log4j.Log4j;


@Repository("healthUseDAO")
@Log4j
public class HealthUseDAOImpl implements HealthUseDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean insert(HealthUseVO hvo) {
		int result = 0;
		boolean resultCheck = false;
		log.info("HealthUseDAO 확인" + hvo);
		
		
		String sql = "insert into useHealth(name,startDate,endDate,usinghealth,memId) " + "values(?,?,?,?,?)";

		result = jdbcTemplate.update(sql, new Object[] { hvo.getName(),hvo.getStartDate(), hvo.getEndDate(),
				hvo.getUsingHealth(), hvo.getMemId() });
		log.info("HealthUse Insert 결과 : "  +  result);
		
		if(result > 0 ) {
			resultCheck = true;
			
		}else {
			resultCheck = false;
		}
		
		return resultCheck;
	}

	@Override
	public int updateUse(int healthUseNo) {
		
		int result = 0;
		log.info("이용권 차감 횟수 확인 : " + healthUseNo);
		/*
		 * for (HealthUseVO hvo : hDB) { if (hvo.getHealthUseNo() == healthUseNo) { int
		 * use = hvo.getUsingHealth(); hvo.setUsingHealth(use - 1); if
		 * (hvo.getUsingHealth() + 1 == use) {
		 * 
		 * }
		 * 
		 * }
		 * 
		 * }
		 */
		
		
		
		return result;
	}

	@Override
	public boolean delete(int HealthUseNo) {
		boolean result = false;
		
		/*
		 * for(HealthUseVO hvo : hDB) { if (hvo.getHealthUseNo() == HealthUseNo) {
		 * result = hDB.remove(hvo); }
		 * 
		 * }
		 */
		return result;
	}

	@Override
	public HealthUseVO selectUser(String userId) {
		String sql = "select * from usehealth where memid = ?";
		List<HealthUseVO> result = jdbcTemplate.query(sql, new Object[] {userId},new RowMapper<HealthUseVO>() {
			@Override
			public HealthUseVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				HealthUseVO hvo = new HealthUseVO();
				hvo.setHealthUseNo(rs.getInt("id"));
				hvo.setName(rs.getString("name"));
				hvo.setStartDate(rs.getString("StartDate"));
				hvo.setEndDate(rs.getString("EndDate"));
				hvo.setUsingHealth(rs.getInt("UsingHealth"));
				hvo.setMemId(rs.getString("memId"));



				return hvo;
			}
		});
				
				
		
		return  result.get(0);
	}

}
