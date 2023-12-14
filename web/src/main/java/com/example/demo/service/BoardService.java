package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.mappers.BoardMapper;
import com.example.demo.model.BoardDto;
import com.example.demo.model.MemberInfoDto;

import jakarta.servlet.http.HttpSession;


@Service
public class BoardService {
	
	@Autowired
	BoardMapper boardMapper;
	@Autowired
	HttpSession session;
	
	// 게시글 등록
	@Transactional
	public boolean postBoard( BoardDto boardDto ) {
		
		boardMapper.postBoard( boardDto.getBtitle(), boardDto.getBcontent(), ((MemberInfoDto)session.getAttribute("memberInfo")).getMno() );
		
		return false;
	}
	
	// 게시글 수정
	@Transactional
	public boolean putBoard( BoardDto boardDto ) {
		
		boardMapper.putBoard( boardDto.getBtitle(), boardDto.getBcontent(), boardDto.getBno() );
		
		return false;
	}
	
	
	// 게시글 삭제
	@Transactional
	public boolean deleteBoard( int bno ) {
		
		boardMapper.deleteBoard( bno );
		
		return false;
	}
	
	
	
}
