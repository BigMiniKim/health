package com.health.dao;

import com.health.domain.HealthUseVO;

public interface HealthUseDAO {
	public boolean insert(HealthUseVO hvo); //이용권 생성
	public int updateUse(int HealthUseNo); //이용권 고유 번호를 이용하여 차감
	public boolean delete(int HealthUseNo);//이용권 고유 번호를 이용하여 소멸 
	public HealthUseVO selectUser(String userId); //userId(memID)를 이용한 조회
}
