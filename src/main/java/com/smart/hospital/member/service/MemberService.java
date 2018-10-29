package com.smart.hospital.member.service;

import java.util.*;

import javax.servlet.http.HttpSession;

import com.smart.hospital.member.vo.MemberVO;

public interface MemberService {
	public int insert(MemberVO member);
	public List selectMemberList() throws Exception;
	public MemberVO loginProcess(MemberVO member) throws Exception;
	public MemberVO accountProcess(MemberVO member) throws Exception;
	public int checkId(MemberVO member) throws Exception;
	public boolean loginCheck(MemberVO member) throws Exception;
	public MemberVO viewMember(MemberVO member) throws Exception;
	public void logout(HttpSession session) throws Exception;
	public boolean checkAccount(MemberVO member) throws Exception;
}
