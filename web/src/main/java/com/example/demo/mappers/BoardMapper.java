package com.example.demo.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.model.MemberInfoDto;

@Mapper
public interface BoardMapper {
	
	// 게시글 등록
	void postBoard( 
			@Param("btitle") String btitle , 
			@Param("bcontent") String bcontent , 
			@Param("mno") int mno );

	// 게시글 수정
	void putBoard( 
			@Param("btitle") String btitle , 
			@Param("bcontent") String bcontent , 
			@Param("bno") int bno );
	
	// 게시글 삭제
	void deleteBoard( 
			@Param("bno") int bno );
	
	
}
