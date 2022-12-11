package com.simplilearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.simplilearn.entity.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {
	
	@Query(value = "select * from products", nativeQuery = true)
	public List<Products> getProducts();
	
	//@Modifying
	//@Query(value = "insert into products (product_category, product_name, product_price) values (:proCat, :proName, :proPrice)",  nativeQuery = true)
	//public List<Products> insertProduct(@Param("proCat") String proCat, @Param("proName") String proName, @Param("proPrice") double proPrice);
}
