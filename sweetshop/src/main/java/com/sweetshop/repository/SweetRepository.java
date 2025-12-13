package com.sweetshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sweetshop.model.Sweet;

public interface SweetRepository extends JpaRepository<Sweet, Long> {
	List<Sweet> findByNameContainingIgnoreCase(String name);
	List<Sweet> findByCategoryIgnoreCase(String category);
	
	@Query("select s from Sweet s where s.price between :min and :max")
	List<Sweet> findByPriceBetween(java.math.BigDecimal min, java.math.BigDecimal max);
}
