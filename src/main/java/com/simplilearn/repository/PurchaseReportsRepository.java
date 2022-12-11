package com.simplilearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.simplilearn.entity.PurchaseReports;

@Repository
public interface PurchaseReportsRepository extends JpaRepository<PurchaseReports, Integer> {

	// Native Query
	@Query(value = "select * from purchase", nativeQuery = true)
	public List<PurchaseReports> getPurchase();
	
	// JPQL Query
	@Query("select p from PurchaseReports p where p.category = :category And p.date = :pDateNew")
	public List<PurchaseReports> getPurchaseReportByCategoryAndDate(@Param("category") String category, @Param("pDateNew") String pDateNew);
}
