package com.health.dao;

import com.health.domain.MemberVO;

public interface MemberDAO {
	
	public int insert(MemberVO vo); //데이터 추가
	public int selectLogin(String id, String pw); //로그인 처리
	public int selectCheck(String id); //id 확인
	
}
