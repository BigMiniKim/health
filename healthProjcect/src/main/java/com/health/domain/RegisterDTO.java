package com.health.domain;

import lombok.Data;

@Data
public class RegisterDTO {
	
	private int id;				//고유값(기본값)
	private int healthUseId;	//이용권 번호
	private int pId;			//프로그램 아이디값
	

}
