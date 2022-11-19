package com.health.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.health.domain.HealthUseVO;
import com.health.service.HealthUseService;
import com.health.service.MemberService;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/health/")
@Log4j


public class HealthUseController {

	@Autowired
	private MemberService service;
	
	@Autowired
	private HealthUseService hservice;

	@GetMapping("/healthusebuy")
	private void buy() {
		
	}
	
	@PostMapping("/create")
	public String create(String id, String pw, String useRight, RedirectAttributes RA) {
		log.info("이용권 생성");
		log.info("아이디 : " + id + ", 패스워드: " + pw + ", 사용권 여부 : " + useRight);
		int result = service.login(id, pw); //결제 로그인...
		
		int HealthNo = 0;
				
		if (result == 1) { //1인 경우 결제 성공
			RA.addFlashAttribute("msg", "회원권 결제에 성공했습니다");
			
						
			//사용권 등록 정보 생성
			HealthUseVO vo = null;			
			if(useRight.equals("C")) {		
				vo = new HealthUseVO(HealthNo, "이용권.." + useRight, "2022-11-01","20222-11-30", 10, id);
				
			} else if(useRight.equals("B")) {
				vo = new HealthUseVO(HealthNo, "이용권.." + useRight, "2022-10-01","20222-12-31", 30, id);				
			} else if(useRight.equals("A")) {
				vo = new HealthUseVO(HealthNo, "이용권.." + useRight, "2022-07-01","20222-12-31", 60, id);
			} else if(useRight.equals("S")) {
				vo = new HealthUseVO(HealthNo, "이용권.." + useRight, "2022-01-01","20222-12-31", 120, id);
			}
			log.info("선택한 이용권 : " + vo);
			/*
			 * vo.setHealthUseNo(HealthNo); // 이용권 번호 vo.setName("이용권.." + useRight); // 이용권
			 * 이름 vo.setStartDate("2022-11-01"); //시작 날짜.... vo.setEndDate("20222-11-30");
			 * // 끝 날짜... vo.setUsingHealth(10); // 월 회차 정보 vo.setMemId(id); //계정 정보...
			 */			
			if(hservice.create(vo)) log.info("이용권 생성 성공");
			HealthNo += 1; // 이용권 번호 증가
			//useRight를 이용하여 healthUseVO를 생성...
		}else { //결제 실패
			RA.addFlashAttribute("msg", "회원권 결제에 실패했습니다");
		}
		
		return "redirect:/health/result";
		
	}
	
	@RequestMapping ("/result")
	public void result() {
			
		
	}
	
	
	
}
