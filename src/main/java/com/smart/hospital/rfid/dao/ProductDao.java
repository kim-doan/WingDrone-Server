package com.smart.hospital.rfid.dao;

import org.springframework.stereotype.Repository;
import com.smart.hospital.rfid.vo.ProductVO;

@Repository
public interface ProductDao {
	public ProductVO productProcess(String product) throws Exception;
	public int insert(ProductVO product);
}
