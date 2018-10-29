package com.smart.hospital.rfid.vo;

import java.sql.Blob;

import org.springframework.web.multipart.MultipartFile;

public class ProductVO {
	private String id;
	private String name;
	private int amount;
	private String inputDate;
	private String outputDate;
	private byte[] image;
	
	@Override
	public String toString() {
		return "ProductVO [id=" + id + ", name=" + name + ", amount=" + amount + ", inputDate=" + inputDate
				+ ", outputDate=" + outputDate + ", image=" + image + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getInputDate() {
		return inputDate;
	}
	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}
	public String getOutputDate() {
		return outputDate;
	}
	public void setOutputDate(String outputDate) {
		this.outputDate = outputDate;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
}
