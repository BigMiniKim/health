package com.health.dao;

import java.util.ArrayList;

import com.health.domain.RegisterDTO;

public interface RegisterDAO {
	
	public boolean insert(RegisterDTO rdto);
	public int personCount(int pid);
	public boolean delete(int rid);
	public ArrayList<RegisterDTO> select(int HealthUseNo);
	

}
