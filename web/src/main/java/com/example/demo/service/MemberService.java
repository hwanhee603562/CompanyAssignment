package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.MemberInfoDto;

@Service
public class MemberService {
		


	// 회원가입
	@PostMapping( "/postMember" )
	public String signUp( @ModelAttribute MemberInfoDto memberInfo ) {
			
		return "login";  
		
	}
	
	
}
