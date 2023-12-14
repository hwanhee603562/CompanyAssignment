package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.BoardDto;
import com.example.demo.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	// 게시판 렌더링
	@GetMapping( "/board" )
	public String board() {
			
		return "board";
		
	}
	
	// 게시글 작성 렌더링
	@GetMapping( "/write" )
	public String write() {
		
		return "write";
		
	}
	
	
	// 게시글 등록
	@PostMapping( "/postBoard" )
	@ResponseBody
	public boolean postBoard( @RequestBody BoardDto boardDto ) {
		
		return boardService.postBoard( boardDto );
	}
	
	
	// 게시글 수정
	@PutMapping( "/putBoard" )
	@ResponseBody
	public boolean putBoard( @RequestBody BoardDto boardDto ) {
		
		return boardService.putBoard( boardDto );
	}
	
	
	// 게시글 삭제
	@DeleteMapping( "/deleteBoard" )
	@ResponseBody
	public boolean deleteBoard( @RequestParam int bno ) {
		
		return boardService.deleteBoard( bno );
	}
	
	
	
	
	
	
}