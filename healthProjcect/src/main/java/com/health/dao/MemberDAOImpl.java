package com.health.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.health.domain.MemberVO;

import lombok.extern.log4j.Log4j;

@Repository("memberDAO")
@Log4j
public class MemberDAOImpl implements MemberDAO {

	/* private ArrayList<MemberVO> DB = new ArrayList<>() */;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int insert(MemberVO vo) {
		int result = 0;
		log.info("DAO에서의 vo값 확인" + vo);

		String sql = "insert into member(id,password,name,phone,email,birthday,gender) " + "values(?,?,?,?,?,?,?)";

		// DB작업
		/*
		 * if(DB.add(vo)) { result = 1; };
		 */
		result = jdbcTemplate.update(sql, new Object[] { vo.getId(), vo.getPassword(), vo.getName(), vo.getPhone(),
				vo.getEmail(), vo.getBirthday(), vo.getGender() });
		log.info("insert결과 : " + result);
		return result;
	}

	@Override
	public int selectLogin(String id, String pw) {
		int result = 0;

		
		/*
		 * for (MemberVO vo:DB) { if(vo.getId().equals(id)) {
		 * if(vo.getPassword().equals(pw)) { log.info("로그인 성공"); result = 1; }else {
		 * log.info("로그인 실패(패스워드)"); }
		 * 
		 * }else { log.info("로그인 실패(id"); } }
		 */
		String sql = "select * from member where id = ? and password = ? ";
		/*
		 * query() 파라미터의 의미 (매개변수)
		 * - sql: sql쿼리를 의미. ?를 사용하는 preparedStatement 용 쿼리를 사용함...
		 * - new Object[] (값1,값2) : sql의 물음표에 셋팅할 값을 저장함...(바인딩)
		 * - new RowMapper<Type>() : 조회결과 ResultSet으로부터 데이터를 읽어와 Type 데이터를 생성
		 * 		-> 익명클래스를 사용...
		 * 		->mapRow() 매서드는 ResultSet에서 읽어온 값을 처리한 후 리턴합니다
		 */
		 List<MemberVO> list = jdbcTemplate.query(sql,  new Object[] {id,pw}, new RowMapper<MemberVO>() {

			@Override
			public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setPhone(rs.getString("phone"));
				vo.setEmail(rs.getString("email"));
				vo.setBirthday(rs.getString("birthDay"));
				vo.setGender(rs.getString("gender"));
				
				return vo;
			}
		}); 
		result = list.size();
		log.info("로그인 결과 : " + result );
		 
		return result;
	}

	@Override
	public int selectCheck(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
