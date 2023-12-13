package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.MemberInfoDto;
import com.example.demo.service.MemberService;


@Controller
public class MemberController {

	@Autowired
	MemberService memberService;
	
	
	// 회원가입페이지 렌더링
	@GetMapping( "/signUp" )
	public String signUpRender () {
		
		return "signUp";
	}
	
	
	// 로그인페이지 렌더링
	@GetMapping( "/logIn" )
	public String logInRender () {
		
		return "logIn";
	}
	
	// 아이디 중복검사
	@PostMapping( "/checkId" )
	@ResponseBody
	public boolean checkId( @RequestParam String mid ) {
		
		return memberService.checkId( mid );
		
	}
	
	// 회원가입
	@PostMapping( "/postMember" )
	@ResponseBody
	public boolean signUp( @ModelAttribute MemberInfoDto memberInfo, Model model ) {
		
		return memberService.signUp( memberInfo );
	    
	}
	
	// 로그인
	@PostMapping( "/logIn" )
	@ResponseBody
	public boolean logIn( @RequestParam String mid, @RequestParam String mpwd ) {
		
		return memberService.logIn( mid, mpwd );
				
	}
	
	
	
	
	
	
	
	
	
}