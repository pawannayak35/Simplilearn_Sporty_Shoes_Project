package com.simplilearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.entity.Products;
import com.simplilearn.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public List<Products> getProduct() {
		return productRepository.getProducts();
	}
	
	public void insertProducts(Products product) {
		productRepository.save(product);
	}
	
	public Products updateProduct(Products product) {
		return productRepository.save(product);
	}
	
	public void deleteProduct(int pid) {
		productRepository.deleteById(pid);
	}

}
