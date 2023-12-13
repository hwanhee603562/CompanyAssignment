package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.mappers.MemberMapper;
import com.example.demo.model.MemberInfoDto;

@Service
public class MemberService {
		
	@Autowired
	MemberMapper memberMapper;

	// 회원가입
	@Transactional
	public Boolean signUp( @ModelAttribute MemberInfoDto memberInfo ) {
		
		memberMapper.postMember(
				memberInfo.getMname(), 
				memberInfo.getMid(), 
				memberInfo.getMpwd(), 
				memberInfo.getMemail()
			);
		
		
		return true;  
		
	}
	
	
}
