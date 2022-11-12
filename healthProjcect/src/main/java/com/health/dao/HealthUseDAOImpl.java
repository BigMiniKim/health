package com.health.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.health.domain.HealthUseVO;


@Repository("healthUseDAO")
public class HealthUseDAOImpl implements HealthUseDAO {

	ArrayList<HealthUseVO> hDB = new ArrayList<>();

	@Override
	public boolean insert(HealthUseVO hvo) {
		boolean result = false;

		result = hDB.add(hvo);

		return result;
	}

	@Override
	public int updateUse(int healthUseNo) {
		int result = 0;

		for (HealthUseVO hvo : hDB) {
			if (hvo.getHealthUseNo() == healthUseNo) {
				int use = hvo.getUsingHealth();
				hvo.setUsingHealth(use - 1);
				if (hvo.getUsingHealth() + 1 == use) {

				}

			}

		}
		return result;
	}

	@Override
	public boolean delete(int HealthUseNo) {
		boolean result = false;
		
		for(HealthUseVO hvo : hDB) {
			if (hvo.getHealthUseNo() == HealthUseNo) {
				result = hDB.remove(hvo);
			}
			
		}
		return result;
	}

}
