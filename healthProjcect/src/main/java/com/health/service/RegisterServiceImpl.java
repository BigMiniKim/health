package com.health.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.health.dao.HealthUseDAO;
import com.health.dao.ProgramDAO;
import com.health.dao.RegisterDAO;
import com.health.domain.HealthProVO;
import com.health.domain.RegisterDTO;

@Service("registerService")
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private RegisterDAO rdao;
	
	@Autowired
	private HealthUseDAO hdao;
	
	@Autowired
	private ProgramDAO pdao;
	
	
	@Override
	@Transactional // 처리하면 2개다
	public boolean register(RegisterDTO rdto) {
		//등록....1.프로그램 조회. 인원수 확인.
		//		 2.프로그램의 제한 인원 확인 미달이면 등록 처리, 아니면 등록 실패
		//		회원관리 사용회수 차감
		boolean result = false;
				
		int limitPerson = pdao.selectOne(rdto.getPId()).getTotalPerson();
		
		
		if (limitPerson > rdao.personCount(rdto.getPId())) {	//personCount() 는 pid를 통해서 등록 사용자를 알아옴.
			result = rdao.insert(rdto);							//insert 는 등록 처리
			hdao.updateUse(rdto.getHealthUseId());
		}
					
		return result;
	}

	@Override
	public boolean remove(String rid) {
		
		return rdao.delete(Integer.parseInt(rid)); 	//삭제
	}

	@Override
	public ArrayList<HealthProVO> getProgram(int HealthNo) {
		ArrayList<HealthProVO> pvo = new ArrayList<HealthProVO>();
		
		for (RegisterDTO rdto : rdao.select(HealthNo)){
			
			pvo.add(pdao.selectOne(rdto.getPId()));
		}
		
		
		return pvo;
	}

}
