package com.sweetshop.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sweetshop.model.Sweet;
import com.sweetshop.service.SweetService;

@RestController
@RequestMapping("/api/sweets")
public class SweetController {

	private final SweetService sweetService;
	public SweetController(SweetService sweetService) { this.sweetService = sweetService;}
	
	@PostMapping
	public ResponseEntity<Sweet> add(@RequestBody Sweet s, Authentication auth){
		boolean isAdmin = auth!=null && auth.getAuthorities().stream().anyMatch(a->a.getAuthority().equals("ROLE_ADMIN"));
		if(!isAdmin) return ResponseEntity.status(403).build();
		
		return ResponseEntity.ok(sweetService.add(s));
	}
	
	@GetMapping
	public ResponseEntity<List<Sweet>> all(){ return ResponseEntity.ok(sweetService.list());}
	
	@GetMapping
	public ResponseEntity<List<Sweet>> search(@RequestParam(required = false) String name,
												@RequestParam(required = false) String category,
												@RequestParam(required = false) BigDecimal min,
												@RequestParam(required = false) BigDecimal max){
		
		return ResponseEntity.ok(sweetService.search(name, category, min, max));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Sweet> update(@PathVariable Long id, @RequestBody Sweet s, Authentication auth){
		boolean isAdmin = auth != null && auth.getAuthorities().stream().anyMatch(a->a.getAuthority().equals("ROLE_ADMIN"));
		if(!isAdmin) return ResponseEntity.status(403).build();
		return ResponseEntity.ok(sweetService.update(id, s));
		
	}
	
	 @DeleteMapping("/{id}")
	    public ResponseEntity<?> delete(@PathVariable Long id, Authentication auth) {
	        boolean isAdmin = auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
	        if (!isAdmin) return ResponseEntity.status(403).build();
	        sweetService.delete(id);
	        return ResponseEntity.ok().build();
	    }

	    @PostMapping("/{id}/purchase")
	    public ResponseEntity<Sweet> purchase(@PathVariable Long id) {
	        return ResponseEntity.ok(sweetService.purchase(id));
	    }

	    @PostMapping("/{id}/restock")
	    public ResponseEntity<Sweet> restock(@PathVariable Long id, @RequestParam int amount, Authentication auth) {
	        boolean isAdmin = auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
	        if (!isAdmin) return ResponseEntity.status(403).build();
	        return ResponseEntity.ok(sweetService.restock(id, amount));
	    }
}
