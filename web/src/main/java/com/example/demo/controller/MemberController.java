package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	// 회원가입
	@PostMapping( "/postMember" )
	public String signUp( @ModelAttribute MemberInfoDto memberInfo ) {
		
	    return memberService.signUp( memberInfo );  
	    
	}
	
	
	
	
	
	
	
	
	
	
	
}