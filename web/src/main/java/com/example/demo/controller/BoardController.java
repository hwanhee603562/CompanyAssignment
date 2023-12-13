package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {

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
	
	
	
	
}