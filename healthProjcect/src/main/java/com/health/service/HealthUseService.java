package com.health.service;

import com.health.domain.HealthUseVO;

public interface HealthUseService {

	public boolean create(HealthUseVO hvo); // 이용권 생성
	public int use(int healthUseNo);		// 이용권 사용(회차차감)
	public boolean deprecated(int healthUseNo); // 이용권 소멸;
}
