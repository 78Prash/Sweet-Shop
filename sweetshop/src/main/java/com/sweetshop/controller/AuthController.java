package com.sweetshop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sweetshop.dto.AuthRequest;
import com.sweetshop.dto.AuthResponse;
import com.sweetshop.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	private final AuthService authService;
	public AuthController(AuthService authService) {this.authService = authService;}
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody AuthRequest req){
		authService.register(req);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/login")
	public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest req){
		return ResponseEntity.ok(authService.login(req));
	}
}
