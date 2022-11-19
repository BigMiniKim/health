package com.health.dao;

import java.util.ArrayList;

import com.health.domain.HealthProVO;

public interface ProgramDAO {
		
		public boolean insert (HealthProVO pvo);	//프로그램 등록		
		public HealthProVO selectOne(int pid);		//등록 프로그램 조회(특정)
		public ArrayList<HealthProVO> selectAll();  //전체 틍록 프로그램 정보 조회
		public boolean update(HealthProVO pvo);     //등록 프로그램 정보 수정
		public void delete(int pid);				//등록 프로그램 삭제
	
}
