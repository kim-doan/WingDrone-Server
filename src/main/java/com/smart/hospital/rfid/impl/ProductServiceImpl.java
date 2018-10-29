package com.smart.hospital.rfid.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smart.hospital.member.dao.MemberDAO;
import com.smart.hospital.member.vo.MemberVO;
import com.smart.hospital.rfid.dao.ProductDao;
import com.smart.hospital.rfid.service.ProductService;
import com.smart.hospital.rfid.vo.ProductVO;

@Service("productService")
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao daoMapper;

	@Override
	public ProductVO productProcess(String product) throws Exception {
		return daoMapper.productProcess(product);
	}
	
	@Override
	@Transactional
	public int insert(ProductVO product) {
		return daoMapper.insert(product);
	}
}
