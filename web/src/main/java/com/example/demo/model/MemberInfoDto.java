package com.example.demo.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

@Alias("MemberInfoDto")
public class MemberInfoDto implements Serializable{
	
	private int mno;
	private String mname;
	private String mid;
	private String mpwd;
	private String memail;
	
	// 생성자
	public MemberInfoDto() {
		// TODO Auto-generated constructor stub
	}
	public MemberInfoDto(int mno, String mname, String mid, String mpwd, String memail) {
		super();
		this.mno = mno;
		this.mname = mname;
		this.mid = mid;
		this.mpwd = mpwd;
		this.memail = memail;
	}
	
	// getter setter
	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpwd() {
		return mpwd;
	}

	public void setMpwd(String mpwd) {
		this.mpwd = mpwd;
	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	@Override
	public String toString() {
		return "MemberInfoDto [mno=" + mno + ", mname=" + mname + ", mid=" + mid + ", mpwd=" + mpwd + ", memail="
				+ memail + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
