package com.example.demo.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.MemberInfoDto;

@Mapper
public interface MemberMapper {
	
	// 파라미터 전달  ( @Param("text") String text )
	List<MemberInfoDto> getMember();
	
}
