package com.smart.hospital.member.dao;

import org.springframework.stereotype.Repository;
import com.smart.hospital.member.vo.MemberVO;

import java.util.*;

import javax.servlet.http.HttpSession;

@Repository
public interface MemberDAO {
	public int insert(MemberVO member);
	public List selectMemberList() throws Exception;
	public boolean loginCheck(MemberVO member) throws Exception;
	public MemberVO viewMember(MemberVO member) throws Exception;
	public int checkId(MemberVO member) throws Exception;
	public void logout(HttpSession session) throws Exception;
	public MemberVO loginProcess(MemberVO member) throws Exception;
	public MemberVO accountProcess(MemberVO member) throws Exception;
	public boolean checkAccount(MemberVO member) throws Exception;
}
