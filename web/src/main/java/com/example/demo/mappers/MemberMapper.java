package com.example.demo.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.model.MemberInfoDto;

@Mapper
public interface MemberMapper {
	
	
	// 파라미터 전달  ( @Param("text") String text )
	List<MemberInfoDto> getMember();
	
	// 아이디 중복검사
	Integer checkId( @Param("mid") String mid );
	
	// 회원가입
	Integer postMember( 
			@Param("mname") String mname , 
			@Param("mid") String mid , 
			@Param("mpwd") String mpwd, 
			@Param("memail") String memail );
	
	// 로그인
	MemberInfoDto logIn(
			@Param("mid") String mid,
			@Param("mpwd") String mpwd );
			
	
	
}
