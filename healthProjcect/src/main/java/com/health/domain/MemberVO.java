package com.health.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MemberVO {
	
	private String id;
	private String password;
	private String name;
	private String phone;
	private String email;
	private String birthday;
	private String gender;
	private Date regDate;

}
