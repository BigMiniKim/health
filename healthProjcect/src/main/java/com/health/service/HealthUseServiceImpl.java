package com.health.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.dao.HealthUseDAO;
import com.health.domain.HealthUseVO;

import lombok.extern.log4j.Log4j;


@Service("healthUseService")
@Log4j
public class HealthUseServiceImpl implements HealthUseService {

	@Autowired
	private HealthUseDAO hdao;

	
	@Override
	public boolean create(HealthUseVO hvo) {
		boolean result = false;
		
		result = hdao.insert(hvo);
		
		
		return result;
	}

	@Override
	public int use(int healthUseNo) {
		int result = 0;
		result = hdao.updateUse(healthUseNo);
		return result;
		
	}

	@Override
	public boolean deprecated(int healthUseNo) {
		
		boolean result = false;
		result = hdao.delete(healthUseNo);
		return result;
	}

	@Override
	public HealthUseVO userInfo(String userId) {
		
		return hdao.selectUser(userId);
	}

}
