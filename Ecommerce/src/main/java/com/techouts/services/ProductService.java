package com.techouts.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.techouts.dao.ProductDao;
import com.techouts.entities.Product;

public class ProductService {

	@Autowired
	ProductDao productDao;

	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	public void save(Product product) {
		productDao.save(product);
		
	}

	public List<Product> getProductByCategory(String categoryname) {
		List<Product> list =productDao.getProductByCategory(categoryname);
		return list;
		
	}

	public Product getProductById(int id) {
		Product product=productDao.getProductById(id);

		return product;
	}
	
	
	
}
