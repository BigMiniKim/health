package com.health.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.health.domain.MemberVO;

import lombok.extern.log4j.Log4j;

@Repository("memberDAO")
@Log4j
public class MemberDAOImpl implements MemberDAO {

	
	private ArrayList<MemberVO> DB = new ArrayList<>();
	
	
	@Override
	public int insert(MemberVO vo) {
		int result = 0;
		log.info("DAO에서의 vo값 확인" + vo);
		
		//DB작업
		if(DB.add(vo)) {
			result = 1;
		};
		
		
		return result;
	}

	@Override
	public int selectLogin(String id, String pw) {
		int result = 0;
		
		for (MemberVO vo:DB) {
			if(vo.getId().equals(id)) {
				if(vo.getPassword().equals(pw)) {
					log.info("로그인 성공");
					result = 1;
				}else {
					log.info("로그인 실패(패스워드)");
				}
				
			}else {
				log.info("로그인 실패(id");
			}
		}
		
		return result;
	}

	@Override
	public int selectCheck(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
