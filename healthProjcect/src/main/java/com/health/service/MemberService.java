package com.health.service;

import com.health.domain.MemberVO;

public interface MemberService {
	
	public int join(MemberVO vo); //회원 가입
	public int login(String id, String pw); //로그인
	public int idCheck(String id); //아이디 확인(존재여부 확인)
	//회원 정보 수정...
	//회원 탈퇴...
}
