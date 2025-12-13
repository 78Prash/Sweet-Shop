package com.sweetshop.security;

import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtFilter extends OncePerRequestFilter {
	private final JwtUtil jwtUtil;

	public JwtFilter(JwtUtil jwtUtil) {
		this.jwtUtil = jwtUtil;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws ServletException, IOException {
		String header = req.getHeader("Authorization");

		if (header != null && header.startsWith("Bearer ")) {

			try {
				String token = header.substring(7);
				String username = jwtUtil.getUsername(token);
				String role = jwtUtil.getRole(token);

				var auth = new UsernamePasswordAuthenticationToken(username, null, List.of(() -> "ROLE_" + role));
				SecurityContextHolder.getContext().setAuthentication(auth);
			} catch (Exception ex) {
				// TODO: handle exception
			}

		}
		 try {
			chain.doFilter(req, res);
		} catch (java.io.IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
