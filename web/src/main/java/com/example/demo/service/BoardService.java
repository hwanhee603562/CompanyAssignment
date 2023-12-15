package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	// board 출력 고정 size
	private final int MAXSIZE = 15;
	
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
	public List<Map> getBoardList( int page ) {

		// 페이지 내 레코드 시작 번호
		int startRow = (page-1) * MAXSIZE;
		
		List<Map> list = boardMapper.getBoardList(startRow, MAXSIZE);
		
		return list;
	}
	
	// 게시물 사이즈 조회
	public int getBoardSize( int page ) {
		
		// 페이지 내 레코드 시작 번호
		int startRow = (page-1) * MAXSIZE;
		int totalPageCount = boardMapper.getBoardSize(startRow, MAXSIZE);
		
		return totalPageCount%MAXSIZE == 0
				? totalPageCount/MAXSIZE
				: totalPageCount/MAXSIZE+1;
                
	}
	
	
	
}














