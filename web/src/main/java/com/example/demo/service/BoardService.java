package com.example.demo.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.mappers.BoardMapper;
import com.example.demo.model.BoardDto;
import com.example.demo.model.MemberInfoDto;

import jakarta.servlet.http.HttpSession;


@Service
@Transactional
public class BoardService {
	
	@Autowired
	BoardMapper boardMapper;
	@Autowired
	HttpSession session;
	
	// 게시글 등록
	public boolean postBoard( Map<String, String> board ) {
		
		try {
			
			boardMapper.postBoard( 
					board.get("btitle"), 
					board.get("bcontent").replace("/n", "<br/>"), 
					((MemberInfoDto)session.getAttribute("memberInfo")).getMno() 
				);
			
			return true;
			
		} catch (Exception e) {
			System.out.println(e);
		}
			
		return false;
	}
	
	// 게시글 수정
	public boolean putBoard( BoardDto boardDto ) {
		
		boardMapper.putBoard( boardDto.getBtitle(), boardDto.getBcontent(), boardDto.getBno() );
		
		return false;
	}
	
	
	// 게시글 삭제
	public boolean deleteBoard( int bno ) {
		
		boardMapper.deleteBoard( bno );
		
		return false;
	}
	
	
	// 게시물 리스트 조회
	public boolean getBoardList( int page ) {

		// 출력 게시물 개수 : 임시 15개 조회 고정
		int maxSize = 15;
		// 페이지 내 레코드 시작 번호
		int startRow = (page-1) * maxSize;
		
		
		
		
		return false;
	}
	
	
	
}














