package com.sweetshop.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sweetshop.model.Sweet;
import com.sweetshop.repository.SweetRepository;

@Service
public class SweetService {

	
	private final SweetRepository repo;
	public SweetService(SweetRepository repo ) {this.repo = repo;}
	
	public Sweet add(Sweet s) {return repo.save(s);}
	public List<Sweet> list() {return repo.findAll();}
	public Sweet update(Long id, Sweet s) {
		Sweet existing = repo.findById(id).orElseThrow();
		existing.setName(s.getName());
		existing.setCategory(s.getCategory());
		existing.setPrice(s.getPrice());
		existing.setQuantity(s.getQuantity());
		return repo.save(existing);
	}
	
	public void delete(Long id) { repo.deleteById(id);}
	
	public List<Sweet> search(String name, String category, BigDecimal min, BigDecimal max){
		if(name!=null && !name.isBlank()) return repo.findByNameContainingIgnoreCase(name);
		if(category != null && !category.isBlank()) return repo.findByCategoryIgnoreCase(category);
		if(min != null && max!=null) return repo.findByPriceBetween(min, max);
		
		return repo.findAll();
	}
	
	public Sweet purchase(Long id) {
		Sweet s = repo.findById(id).orElseThrow();
		if(s.getQuantity()==null || s.getQuantity()<=0) throw new RuntimeException("Out of Stock");
		s.setQuantity(s.getQuantity()-1);
		return repo.save(s);
	}
			
	
	public Sweet restock(Long id, int amount) {
		Sweet s = repo.findById(id).orElseThrow();
		s.setQuantity((s.getQuantity()==null ? 0:s.getQuantity())+amount);
		return repo.save(s);
	}
	
	}

