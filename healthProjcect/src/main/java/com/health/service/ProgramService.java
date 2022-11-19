package com.health.service;

import java.util.ArrayList;

import com.health.domain.HealthProVO;

public interface ProgramService {

	public boolean createProgram(HealthProVO pvo);		//프로그램 등록
	public HealthProVO search(int pid);					//특정프로그램 조회
	public ArrayList<HealthProVO> getList();			//모든 프로그램 조회
	public boolean modify(HealthProVO pvo);				//프로그램 정보 수정
	public void removeProgram(int pid);					//프로그램 정보 삭제
	
}
