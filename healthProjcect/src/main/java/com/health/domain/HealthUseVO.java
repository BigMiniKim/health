package com.health.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HealthUseVO {

	private int healthUseNo;
	private String name;
	private String startDate;		//시작날짜
	private String endDate;			//마감날짜
	private int usingHealth;		//이용횟수
	private String memId;			//멤버id FK
	
}
