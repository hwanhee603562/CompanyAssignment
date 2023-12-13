package com.example.demo.service;


import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.servlet.http.HttpSession;

@Service
public class SendEmailService {

	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	SimpleMailMessage message;
	@Autowired
	HttpSession session;
	
	// 이메일 전송
	@Transactional
	public boolean sendEmail( @RequestBody String toEmail ) {
		
		try {
			
			// 송신자 
			message.setFrom("abb258@naver.com");
			
			// 수신자
			message.setTo( (toEmail.replace("%40", "@")) );
			// 제목
			message.setSubject("(주)아로아소프트 이메일 인증요청입니다");
			
			// 이메일 인증번호 난수 생성
			String emailCheckNo = "";	// 인증번호를 저장할 문자열
			for(int i=0; i<6; i++) {
				
				Random random = new Random();
				emailCheckNo += random.nextInt(10);
				
			}
			
			// 내용
			message.setText(emailCheckNo);
			// 이메일 전송
			javaMailSender.send(message);
			
			
			// 난수 세션 임시 저장
			session.setAttribute("emailNo", emailCheckNo);

			return true;
			
		} catch (Exception e) {
			System.out.println(e);
			
		}
		
		return false;
		
	}
	
	
	// 이메일 인증정보 확인
	@Transactional
	public boolean checkEmail( @RequestBody String inputEmail ) {
		
		String email = (String)session.getAttribute("emailNo");
		
		System.out.println("input : "+inputEmail);
		System.out.println("session no : "+ email);
		
		// 이메일 인증정보 동일할 시
		if( inputEmail.equals(email) ) return true;
		
		return false;
	}
	
	
	
	
	
	
	
	

}










