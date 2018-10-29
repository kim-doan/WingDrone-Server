package com.smart.hospital.member.vo;

import java.util.Date;

public class MemberVO {
	private int no;
	private String id;
	private String password;
	private String name;
//	private Date date;
//	private String gateway;
	private String grade;
	private String phone;
//	private int age;
//	private String devicecode;
//	private String protectorphone;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
//	public Date getDate() {
//		return date;
//	}
//	public void setDate(Date date) {
//		this.date = date;
//	}
//	public String getGateway() {
//		return gateway;
//	}
//	public void setGateway(String gateway) {
//		this.gateway = gateway;
//	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "MemberVO [no=" + no + ", id=" + id + ", password=" + password + ", name=" + name + ", grade=" + grade + ", phone=" + phone + "]";
	}
//	public int getAge() {
//		return age;
//	}
//	public void setAge(int age) {
//		this.age = age;
//	}
//	public String getDevicecode() {
//		return devicecode;
//	}
//	public void setDevicecode(String devicecode) {
//		this.devicecode = devicecode;
//	}
//	public String getProtectorphone() {
//		return protectorphone;
//	}
//	public void setProtectorphone(String protectorphone) {
//		this.protectorphone = protectorphone;
//	}
	
	
}
