package com.health.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.health.domain.MemberVO;
import com.health.service.MemberService;

import lombok.extern.log4j.Log4j;


@Controller
@RequestMapping("/member/")
@Log4j
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	//회원가입 페이지
	@RequestMapping("/join") //이 url로 들어오면...
	public void join() {
		
		
	}
	
	//회원가입 확인
	@PostMapping("/joinForm")
	public String joinForm(MemberVO vo,RedirectAttributes RA) {
		
		log.info(vo);
		int result = 0;
		result = service.join(vo);
		log.info("Controller - 조인 실행결과(0-실패,1-성공) : " + result);
		
		if (result ==1) { //가입처리를 기준으로 메시지 발송
			//로그인 성공
			RA.addFlashAttribute("msg","회원가입 성공");
			
		}else {
			//로그인 실패
			RA.addFlashAttribute("msg","회원가입 실패");			
		}
		
		return "redirect:/member/join_result";
		
		
		
	}
	
	//조인결과
	@RequestMapping("join_result")
	public void join_result() {
		
	}
	
	//로그인 화면 처리
	@RequestMapping("/login")
	public String login() {
		
		
		return "member/login";
	}

	//로그인 처리
	@PostMapping("/loginForm")
	public String loginForm(MemberVO vo, HttpSession session, RedirectAttributes RA) {
		
		log.info("로그인 : " + vo);
		int result = service.login(vo.getId(), vo.getPassword());
		if (result == 1) {
			//로그인 성공시 동작
			session.setAttribute("user_id", vo.getId());
			return "redirect:/";
			
		}else {
			//로그인 실패시 동작
			RA.addFlashAttribute("msg","아이디 혹은 비밀번호를 확인하세요"); //ra.addFlashAttribute는 1회성 메시지를 전달
			return "redirect:/member/login";
		}
	}
	
	@GetMapping("/mypage")
	public String mypage(HttpSession session) {
		
		String id = (String)session.getAttribute("user_id");
		//user_id값을 이용하여 회원정보를 얻어와야한다. mypage()인자도 추가 해야함
		
		return "member/mypage";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		//session.remove(); 일부만
		return "redirect:/";
	}
	
}
