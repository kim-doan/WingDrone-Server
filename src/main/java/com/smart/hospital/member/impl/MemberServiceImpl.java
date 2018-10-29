package com.smart.hospital.member.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smart.hospital.member.dao.MemberDAO;
import com.smart.hospital.member.service.MemberService;
import com.smart.hospital.member.vo.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO daoMapper;
	
	@Override
	@Transactional
	public int insert(MemberVO member) {
		return daoMapper.insert(member);
	}

	@Override
	@Transactional
	public List selectMemberList() throws Exception {
		return daoMapper.selectMemberList();
	}

	@Override
	public MemberVO loginProcess(MemberVO member) throws Exception {
		return daoMapper.loginProcess(member);
	}
	
	@Override
	public MemberVO accountProcess(MemberVO member) throws Exception {
		return daoMapper.accountProcess(member);
	}
	
	@Override
	public boolean loginCheck(MemberVO member) throws Exception {
		MemberVO name = daoMapper.loginProcess(member);
		if(name != null) {
			System.out.println(name.getId());
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public boolean checkAccount(MemberVO member) throws Exception {
		MemberVO name = daoMapper.accountProcess(member);
		if(name != null) {
			System.out.println(name.getId());
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public MemberVO viewMember(MemberVO member) throws Exception {
		return daoMapper.loginProcess(member);
	}

	@Override
	public void logout(HttpSession session) throws Exception {
		session.invalidate();
	}
	
	@Override
	public int checkId(MemberVO member) throws Exception {
		return daoMapper.checkId(member);
	}
}
