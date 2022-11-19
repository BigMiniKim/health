package com.health.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.health.domain.HealthProVO;


@Repository("programDAO")
public class ProgramDAOImpl implements ProgramDAO {

	//DB
	ArrayList<HealthProVO> pDB = new ArrayList<>();
	
	private int id = 1;		//프로그램에 기본키 값 pid 값
	
	
	@Override
	public boolean insert(HealthProVO pvo) {
		boolean result = false;
		
		pvo.setPid(id); 	//기본키값 추가....
		result = pDB.add(pvo);
		id += 1;
		
		return result;
	}

	@Override
	public HealthProVO selectOne(int pid) {
		for (HealthProVO pvo : pDB) {
			if(pvo.getPid()== pid) {
				return pvo;
				
			}
		}
		return null;
	}

	@Override
	public ArrayList<HealthProVO> selectAll() {
		return pDB;
	}

	@Override
	public boolean update(HealthProVO pvo) {
		boolean result = false;
		for(HealthProVO vo:pDB) {
			if (vo.getPid() == pvo.getPid()) {
				vo.setDate(pvo.getDate());
				vo.setTimes(pvo.getTimes());
				vo.setTotalPerson(pvo.getTotalPerson());
				result = true;
				
			}
		}
		return result;
	}

	@Override
	public void delete(int pid) {
		int num = 0; //인덱스 값...
		for(HealthProVO pvo:pDB) {
			if ( pvo.getPid() == pid) {
				pDB.remove(num);
				break;
			}
			num +=1;
		}
		pDB.remove(num);

	}

}
