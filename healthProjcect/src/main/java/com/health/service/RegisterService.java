package com.health.service;

import java.util.ArrayList;

import com.health.domain.HealthProVO;
import com.health.domain.RegisterDTO;

public interface RegisterService {
	
	public boolean register(RegisterDTO rdto); // 등록
	public boolean remove (String rid); // 등록 취소...register 등록 ID 값으로 삭제
	public ArrayList<HealthProVO> getProgram(int HealthNo); // 회원이용권을 이용한 조회

}
