package com.health.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.dao.ProgramDAO;
import com.health.domain.HealthProVO;


@Service("programService")
public class ProgramServiceImpl implements ProgramService {

	@Autowired
	private ProgramDAO pdao;
	
	@Override
	public boolean createProgram(HealthProVO pvo) {
		
		return pdao.insert(pvo);
	}

	@Override
	public HealthProVO search(int pid) {
		HealthProVO pvo = null;
		pvo = pdao.selectOne(pid);
		return pvo;
	}

	@Override
	public ArrayList<HealthProVO> getList() {
		
		return pdao.selectAll();
	}

	@Override
	public boolean modify(HealthProVO pvo) {
		return pdao.update(pvo);		
	}

	@Override
	public void removeProgram(int pid) {
		pdao.delete(pid);

	}

}
