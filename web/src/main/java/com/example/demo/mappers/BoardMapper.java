package com.example.demo.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
	
	// 게시글 조회
	List<Map> getBoardList( 
			@Param("startRow") int startRow ,
			@Param("maxSize") int maxSize );
	
	// 게시글 사이즈 조회
	Integer getBoardSize( 
			@Param("startRow") int startRow ,
			@Param("maxSize") int maxSize );
	
	
}
