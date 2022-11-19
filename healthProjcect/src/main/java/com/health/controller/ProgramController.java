package com.health.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.health.domain.HealthProVO;
import com.health.service.ProgramService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/program/")
@Log4j
public class ProgramController {
	
	@Autowired
	private ProgramService pServ;
	
	//프로그램 등록 화면 처리
	@GetMapping("/create")
	public String createProgram() {
		return "program/create";
	}
	
	
	//프로그램 등록 요청 처리
	@PostMapping("/createForm")
	public String createPro(HealthProVO vo, RedirectAttributes RA) {
		boolean rs = false;
		rs = pServ.createProgram(vo);
		if (rs) {
			//등록성공
			log.info("등록 성공");
			return "redirect:/program/pList";	// redirect 를 통해 정보를 갖고 간다
			
		}else {
			//등록 실패
			RA.addFlashAttribute("msg","등록 실패");
			return "redirect:/program/create";
			
		}
	}
	
	@RequestMapping("/pList")
	public void getList(Model model) {
		//프로그램 정보를 저장할 공간...
		ArrayList<HealthProVO> list = pServ.getList();
		
		model.addAttribute("programList",list);
		
	}
	
	@RequestMapping("/programDelete")
	public String deleteProString(@RequestParam("num") String num) {
		int pid = Integer.parseInt(num);	//파싱
		pServ.removeProgram(pid);
		
		
		return "redirect:/program/pList";
	}
	
}
