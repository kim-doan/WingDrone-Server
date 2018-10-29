package com.smart.hospital.rfid.service;

import com.smart.hospital.rfid.vo.ProductVO;

public interface ProductService {
	public ProductVO productProcess(String product) throws Exception;
	public int insert(ProductVO product);
}
