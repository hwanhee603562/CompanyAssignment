package com.example.demo.model;

import java.time.LocalDateTime;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Alias("BoardDto")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter 
@Setter
public class BoardDto {
	
	private int bno;
	private String btitle;
	private String bcontent;
	private int mno;
	private LocalDateTime bdate;
	
}
