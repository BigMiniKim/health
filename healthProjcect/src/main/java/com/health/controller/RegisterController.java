package com.health.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.health.domain.HealthProVO;
import com.health.domain.RegisterDTO;
import com.health.service.HealthUseService;
import com.health.service.ProgramService;
import com.health.service.RegisterService;

import lombok.extern.log4j.Log4j;
@Log4j
@Controller
@RequestMapping("/register/")
public class RegisterController {

	
	@Autowired
	private ProgramService pservice;
	
	@Autowired
	private RegisterService rservice;
	
	@Autowired
	private HealthUseService hservice;
	
	//health 이용권을 이용한 프로그램 등록 신청
	@RequestMapping("/register")
	public String regist(Model model) {
	
		ArrayList<HealthProVO> list = pservice.getList();
		
		//전달받은 db를 board
		
		model.addAttribute("programList",list);
		
		return "register/regList";
	}
	
	@RequestMapping("regCreate")
	public String regCreate(@RequestParam("pid") String pid, HttpSession session, RedirectAttributes RA) {
		
		//register DB에 저장하기 위해서 필요한것 HealthUseNo, pid
		
		String userId = (String) session.getAttribute("user_id");
		int healthUseNO = hservice.userInfo(userId).getHealthUseNo();
		System.out.println(healthUseNO);
		
		RegisterDTO rdto = new RegisterDTO();
		rdto.setHealthUseId(healthUseNO);
		rdto.setPId(Integer.parseInt(pid));
		
		//등록 처리
		if (rservice.register(rdto)) {
			RA.addFlashAttribute("msg", "수업 등록 성공");
			return "redirect:/register/rlist";
		}else {
			RA.addFlashAttribute("msg", "수업 등록 실패");
			return "redirect:/register/regist";
			
		}

	}
	//삭제
	@RequestMapping("/regDelete")
	public String regDelete(@RequestParam("pid")String pid) {
		rservice.remove(pid);
		
		return "redirect:/register/rlist";
	}
	
	
	@RequestMapping("/rlist")
	public String rlist(Model model, HttpSession session) {
		
		//프로그램등록확인
		String id = (String)session.getAttribute("user_id");
		int healthUseNo = hservice.userInfo(id).getHealthUseNo();
		log.info(id);
		log.info(healthUseNo);
		ArrayList<HealthProVO> list = new ArrayList<>();
		
		list = rservice.getProgram(healthUseNo);
		
		//전달 받은 DB를 ProgramList 이름으로 저장
		model.addAttribute("programList", list);	
		
		return "register/list";
	}
	
	
}
